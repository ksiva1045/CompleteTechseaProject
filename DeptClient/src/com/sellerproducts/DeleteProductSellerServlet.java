package com.sellerproducts;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.SellerProduct;
import com.table.operations.TableOperationsStub.SellerProductArray;
import com.table.operations.TableOperationsStub.SellerProductOperations;

public class DeleteProductSellerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
		
				TableOperationsStub tableStub=new TableOperationsStub();
				SellerProductOperations sellerProductOperations=new SellerProductOperations();
				SellerProduct sellerProduct = new SellerProduct();
				SellerProductArray sellerProductArray=new SellerProductArray();
				
				sellerProductArray.setOperationName(Operations.DELETE);
				sellerProduct.setPsid(value);


				sellerProductOperations.setSellerProductObj(sellerProduct);
				sellerProductOperations.setSellerProductArray(sellerProductArray);
		
				
		tableStub.sellerProductOperations(sellerProductOperations).get_return();
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
			System.out.println(count);

			request.setAttribute("count", count);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/SellerProductJsps/DeleteSellerProduct.jsp");
			reqDispatcher.forward(request, response);
			
		}
		

	}

}


