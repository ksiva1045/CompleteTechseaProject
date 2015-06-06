
package com.deal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

public class ProductIDAndSellerID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();
		String toPages=(String) session.getAttribute("toPage");
		
		//product
		ProductOperations productOperations = new ProductOperations();
		ProductBean productObj = new ProductBean();
		ProductArray productArray = new ProductArray();
		productArray.setOperationName(Operations.SELECTALL);
		productOperations.setProductBean(productObj);
		productOperations.setProductArray(productArray);
		productArray = (ProductArray) stub.productOperations(productOperations).get_return();
		
		
		//sellers
		SellerOperations sellerOperations = new SellerOperations();
		Seller sellerObj = new Seller();
		
		SellerArray sellerArray = new SellerArray();
		sellerArray.setOperationName(Operations.SELECTALL);
		sellerOperations.setSellerObj(sellerObj);
		sellerOperations.setSellerArray(sellerArray);
		sellerArray=(SellerArray) stub.sellerOperations(sellerOperations).get_return();
		
		try{
			RequestDispatcher reqDis=null;
			//product
			request.setAttribute("productArray",productArray);
			
			//sellers
			request.setAttribute("sellerArray",sellerArray);
			System.out.println(toPages+" success");
			
			if(toPages.equalsIgnoreCase("insert")){
				reqDis =  request.getRequestDispatcher("/dealjsps/InsertDeal.jsp");
			}
			else if(toPages.equalsIgnoreCase("update")){
				request.setAttribute("dealObj", request.getAttribute("dealObj"));
				reqDis =  request.getRequestDispatcher("/dealjsps/UpdateDeal.jsp");
			}
			
			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
