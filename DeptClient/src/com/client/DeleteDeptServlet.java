package com.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;

/**
 * Servlet implementation class DeleteDeptServlet
 */
public class DeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
				DeptOperations deptOperations = new DeptOperations();
				Dept dept = new Dept();
				dept.setDeptNo(value);
				DeptArray dArray = new DeptArray();
				dArray.setOperationName(Operations.DELETE);
				deptOperations.setDArray(dArray);
				deptOperations.setD(dept);
				
				
				stub.deptOperations(deptOperations).get_return();
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
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/deptjsps/deleteStatus.jsp");
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
