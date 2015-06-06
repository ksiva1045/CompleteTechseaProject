package com.prod_cat;

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
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

/**
 * Servlet implementation class NoOfProductParenIDServlet
 */
public class NoOfProductParenIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();
		HttpSession session=request.getSession();
		String toPages=(String) session.getAttribute("toPage");
		
		ProductCategoryOperations productCategoryOperations = new ProductCategoryOperations();
		ProductCat productCat = new ProductCat();
		ProductCatArray productCatArray = new ProductCatArray();
		productCatArray.setOperationName(Operations.SELECTALL);
		productCategoryOperations.setProCatObj(productCat);
		productCategoryOperations.setProCatArray(productCatArray);
		productCatArray = (ProductCatArray) stub.productCategoryOperations(productCategoryOperations).get_return();
		
		
		try{
			RequestDispatcher reqDis=null;
			
			request.setAttribute("productCatArray",productCatArray);	
			
			if(toPages.equalsIgnoreCase("insert")){
				reqDis =  request.getRequestDispatcher("/productCatjspPages/InsertProductCat.jsp");
			}
			else if(toPages.equalsIgnoreCase("update")){
				request.setAttribute("productCatObj", request.getAttribute("productCatObj"));
				reqDis =  request.getRequestDispatcher("/productCatjspPages/Update.jsp");
			}
			
			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
