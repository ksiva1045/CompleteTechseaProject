package com.products;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ProductArray;
import com.table.operations.TableOperationsStub.ProductBean;
import com.table.operations.TableOperationsStub.ProductOperations;
import com.table.operations.TableOperationsStub.ProductSpecification;
import com.table.operations.TableOperationsStub.ProductSpecificationArray;
import com.table.operations.TableOperationsStub.ProductSpecificationOperations;


/**
 * Servlet implementation class ClientServletDelete
 */
public class ClientServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
				TableOperationsStub tablestub=new TableOperationsStub();
				
				
	               // Product Specification
					ProductSpecificationOperations productSpecificationOperations =  new ProductSpecificationOperations();
					ProductSpecification productSpecification = new ProductSpecification();
					ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
					productSpecificationArray.setOperationName(Operations.DELETE);
					productSpecification.setProduct_id(value);
					productSpecificationOperations.setProductSpecificationArray(productSpecificationArray);
					productSpecificationOperations.setProductSpecificObj(productSpecification);
					tablestub.productSpecificationOperations(productSpecificationOperations).get_return();
				
				
				//product
				ProductOperations productopertions=new ProductOperations();
				ProductBean product = new ProductBean();
				ProductArray productArray = new ProductArray();
				productArray.setOperationName(Operations.DELETE);
				product.setProductId(value);
				
				productopertions.setProductArray(productArray);		
				productopertions.setProductBean(product);
				tablestub.productOperations(productopertions).get_return();
				
				
				count++;
			}
			}		
			else{    	
	            	out.print("<center style='color:red'>");
	            	out.print("<h2>");
	            	out.print("No Records were selected to delete");
	            	out.print("</h2>");
	            	out.print("</center>");
	            	
	            	
			}
			if(count>0){
				request.setAttribute("count", count);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("productjsps/deleteStatus.jsp");
			reqDispatcher.forward(request, response);
			
		
		}
	}

}
