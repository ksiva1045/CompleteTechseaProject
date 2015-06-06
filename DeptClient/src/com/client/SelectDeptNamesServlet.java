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
 * Servlet implementation class SelectDeptNamesServlet
 */
public class SelectDeptNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		TableOperationsStub stub = new TableOperationsStub();
		DeptOperations deptOperations = new DeptOperations();
		Dept deptObj = new Dept();
		com.table.operations.TableOperationsStub.DeptArray dArray = new com.table.operations.TableOperationsStub.DeptArray();
		dArray.setOperationName(Operations.SELECTALL);
		deptOperations.setD(deptObj);
		deptOperations.setDArray(dArray);
		dArray = (DeptArray) stub.deptOperations(deptOperations).get_return();
	
		try{	
			
			request.setAttribute("deptArray",dArray);
			RequestDispatcher reqDis =  request.getRequestDispatcher("/deptjsps/searchdept.jsp");
			reqDis.include(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
