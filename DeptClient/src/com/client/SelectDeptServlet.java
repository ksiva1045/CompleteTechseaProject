package com.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsCallbackHandler;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;



/**
 * Servlet implementation class SelectDeptServlet
 */
public class SelectDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 session.setAttribute("username",session.getAttribute("username")); 
		 TableOperationsStub stub = new TableOperationsStub();
		 DeptOperations deptOperations = new DeptOperations();
		 Dept dept = new Dept();
		dept.setDeptNo(request.getParameter("id"));
		DeptArray dArray = new DeptArray();
		dArray.setOperationName(Operations.SELECTBYID);
		deptOperations.setD(dept);;
		deptOperations.setDArray(dArray);
		
		Object obj = stub.deptOperations(deptOperations).get_return();
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Dept){
			dept = (Dept)obj;
			
		}
		System.out.println(dept.getDeptNo());
		System.out.println(dept.getDeptName());
		System.out.println(dept.getLocation());
		System.out.println(dept.getLastModifiedUserId());
		request.setAttribute("deptObj", dept);
		RequestDispatcher reqDis = request.getRequestDispatcher("/deptjsps/update.jsp");
		reqDis.forward(request, response);
	}

}
