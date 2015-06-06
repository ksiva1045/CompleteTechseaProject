package com.employeeclient;

import java.io.IOException;

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
import com.table.operations.TableOperationsStub.Emp;
import com.table.operations.TableOperationsStub.EmpArray;
import com.table.operations.TableOperationsStub.EmpOperations;

/**
 * Servlet implementation class SearchByID
 */
public class SelectEmpServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 session.setAttribute("username",session.getAttribute("username")); 
		 
		 TableOperationsStub tableStub = new TableOperationsStub();
		 EmpOperations empOperations = new EmpOperations();
		 EmpArray empArray = new EmpArray();
		 Emp emp = new Emp();
		 
		emp.setEno(request.getParameter("id"));
		
		empArray.setOperationName(Operations.SELECTBYID);
		empOperations.setEmp(emp);;
		empOperations.setEmpArray(empArray);
		
		Object obj = tableStub.empOperations(empOperations).get_return();
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Emp){
			emp = (Emp)obj;
			
		}
		System.out.println(emp.getEno());
		System.out.println(emp.getEname());
		System.out.println(emp.getEpdesc());
		System.out.println(emp.getEskill());
		System.out.println(emp.getHiredate());
		System.out.println(emp.getMname());
		System.out.println(emp.getDno());
		System.out.println(emp.getUid());
		System.out.println(emp.getPswd());
		
		request.setAttribute("empObj", emp);
		RequestDispatcher reqDis = request.getRequestDispatcher("/empjsps/UpdateEmp.jsp");
		reqDis.forward(request, response);
	}

}



