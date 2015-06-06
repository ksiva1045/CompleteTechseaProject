package com.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductCat;
import com.table.operations.TableOperationsStub.ProductCatArray;
import com.table.operations.TableOperationsStub.ProductCategoryOperations;

public class ProductCatIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TableOperationsStub stub = new TableOperationsStub();

		HttpSession session=request.getSession();
	
		String toPages=(String) session.getAttribute("toPage");

		
		//product Categories
		ProductCategoryOperations productCategoryOperations = new ProductCategoryOperations();
		ProductCat productCat = new ProductCat();
		ProductCatArray productCatArray = new ProductCatArray();
		
		productCatArray.setOperationName(Operations.SELECTALL);
		productCategoryOperations.setProCatObj(productCat);
		productCategoryOperations.setProCatArray(productCatArray);
		productCatArray = (ProductCatArray) stub.productCategoryOperations(productCategoryOperations).get_return();
		
	
		try{
			RequestDispatcher reqDis=null;

			if(toPages.equalsIgnoreCase("insert")){

				request.setAttribute("productCatArray",productCatArray);
				reqDis =  request.getRequestDispatcher("/productjsps/insert.jsp");
			}
			else if(toPages.equalsIgnoreCase("update")){
				
				request.setAttribute("productCatArray",productCatArray);
				session.setAttribute("product", session.getAttribute("product"));
				request.setAttribute("productSpecification",request.getAttribute("productSpecification"));
				reqDis =  request.getRequestDispatcher("/productjsps/ProductUpdate.jsp");
			}
		
			reqDis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
