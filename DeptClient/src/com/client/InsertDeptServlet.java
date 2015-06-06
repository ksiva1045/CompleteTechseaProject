package com.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;

/**
 * Servlet implementation class InsertDeptServlet
 */
public class InsertDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag = "false";
		response.setContentType("text/html");
try{
		TableOperationsStub table = new TableOperationsStub();
		
		DeptOperations deptOperations = new DeptOperations();
		HttpSession session = request.getSession(false);
		Dept dept = new Dept();
		System.out.println(session.getAttribute("username"));
		dept.setDeptName(request.getParameter("deptName"));
		dept.setLocation(request.getParameter("location"));
		dept.setCreatedUserId((String)session.getAttribute("username"));
	
		DeptArray dArray = new DeptArray();
		dArray.setOperationName(Operations.INSERT);
		deptOperations.setD(dept);
		deptOperations.setDArray(dArray);
	dArray = (DeptArray) table.deptOperations(deptOperations).get_return();
	flag =  dArray.getResult();
	System.out.println(flag);
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
		
		request.setAttribute("sucessFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/deptjsps/insertReturn.jsp");
		reqDis.forward(request, response);
		
	}

}
