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
 * Servlet implementation class UpdateDeptServlet
 */
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag="failure";
		TableOperationsStub stub = new TableOperationsStub();
		DeptOperations deptOperations = new DeptOperations();
		Dept dept = new Dept();
		DeptArray dArray = new DeptArray();
		
		dArray.setOperationName(Operations.UPDATE);
	
	
		HttpSession session = request.getSession(false);
		Dept department = (Dept) session.getAttribute("dept");
		
	    dept.setDeptNo(department.getDeptNo());
	    dept.setDeptName(request.getParameter("deptName"));
	    dept.setLocation(request.getParameter("location"));
	    dept.setLastModifiedUserId((String)session.getAttribute("username"));
		deptOperations.setDArray(dArray);
		deptOperations.setD(dept);
		
		
		dArray= (DeptArray) stub.deptOperations(deptOperations).get_return();
		
		
		flag = dArray.getResult();
		if(flag.equals("success")){
			request.setAttribute("sucessFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/deptjsps/updateReturn.jsp");
			reqDis.forward(request,response);
		}
	}

}
