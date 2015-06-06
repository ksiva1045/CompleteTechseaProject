package com.sellers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Seller;
import com.table.operations.TableOperationsStub.SellerArray;
import com.table.operations.TableOperationsStub.SellerOperations;

/**
 * Servlet implementation class DeleteSellerServlet
 */
public class DeleteSellerServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		System.out.println(ar.length);
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
		
				TableOperationsStub stub = new TableOperationsStub();
				SellerOperations sellerOperations = new SellerOperations();
				Seller seller =new Seller();
				SellerArray sellerArray=new SellerArray();
				seller.setSid(value);
				sellerArray.setOperationName(Operations.DELETE);
				sellerOperations.setSellerObj(seller);
				sellerOperations.setSellerArray(sellerArray);
				stub.sellerOperations(sellerOperations).get_return();
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
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/sellerjsps/sellerdeleteStatus.jsp");
			reqDispatcher.forward(request, response);
			
			/*
			out.print("<center style='color:red'>");
        	out.print("<h2>");
        	out.print("No Of Records were delete    :"+count);
        	out.print("No Of Records were delete    :"+count);
        	out.print("</h2>");
        	out.print("</center>");
        	
			
			request.setAttribute("count", count);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/reselectAll.jsp");
			reqDispatcher.forward(request, response);
		*/
		}
		

	}


	}

	
