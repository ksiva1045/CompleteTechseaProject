
package com.sellerproducts;

import java.io.IOException;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;
import com.table.operations.TableOperationsStub.SellerProduct;

public class ProductID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();
		session.setAttribute("seller", session.getAttribute("seller"));
		String toPages=(String) session.getAttribute("toPage");
		String productName="";
		
		//product
		ProductOperations productOperations = new ProductOperations();
		ProductBean productObj = new ProductBean();
		ProductArray productArray = new ProductArray();
		productArray.setOperationName(Operations.SELECTALL);
		productOperations.setProductBean(productObj);
		productOperations.setProductArray(productArray);
		productArray = (ProductArray) stub.productOperations(productOperations).get_return();
		
		productName=request.getParameter("Product_Name");
		System.out.println("inside product id : "+productName);
		SellerProduct sellerProduct1=(SellerProduct) session.getAttribute("SellerProduct");
		
		ProductBean[] productBean=null;
		if(productArray!=null){
			productBean = productArray.getProduct();

			for(int i=0;i<productBean.length;i++){

				if(productBean[i].getProductName().equalsIgnoreCase(productName)){
					//System.out.println("inside productid servlet if condition");

					productName=productBean[i].getProductId();
					//System.out.println("inside productid servlet : "+productName);
				}
			}
		}
		
		
		try{
			RequestDispatcher reqDis=null;
			//product
			request.setAttribute("productArray",productArray);
			
			if(toPages.equalsIgnoreCase("insert")){
				reqDis =  request.getRequestDispatcher("/SellerProductJsps/InsertSellerProduct.jsp");
			}
			else if(toPages.equalsIgnoreCase("insertseller")){
			System.out.print("Calling insertseller");
				reqDis =  request.getRequestDispatcher("/SellerProductJsps/ProductSellerInsert.jsp");
			}
			
			
			
			else if(toPages.equalsIgnoreCase("update")){
				session.setAttribute("productName",productName);// request.getAttribute("SellerProductObj"));
				reqDis =  request.getRequestDispatcher("/UpdateProductSellerServlet");
			}
			else if(toPages.equalsIgnoreCase("insertsellerproduct")){
				session.setAttribute("productName",productName);
				session.setAttribute("fromPage", "productid");
				reqDis =  request.getRequestDispatcher("/InsertProductSellerServlet");
			}
			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
