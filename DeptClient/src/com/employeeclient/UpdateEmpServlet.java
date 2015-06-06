package com.employeeclient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeeclient.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;
import com.table.operations.TableOperationsStub.Emp;
import com.table.operations.TableOperationsStub.EmpArray;
import com.table.operations.TableOperationsStub.EmpOperations;

/**
 * Servlet implementation class UpdateEmpServlet
 */
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		
	              EmpOperations empOperations=new EmpOperations();
	              EmpArray empArray=new EmpArray();
		          Emp emp=new Emp();
		
		          empArray.setOperationName(Operations.UPDATE);
		          
		HttpSession session = request.getSession(false);
		Emp emp1 = (Emp) session.getAttribute("emp");
		
		emp.setEno(emp1.getEno());
		emp.setEname(request.getParameter("Empname"));
		emp.setEskill(request.getParameter("Empskill"));
		emp.setEpdesc(request.getParameter("Empprojectdesc"));
	    emp.setHiredate(GetDate.getDate(request.getParameter("hiredate")));
	    emp.setMname(request.getParameter("Managername"));
	    emp.setDno(request.getParameter("Deptno"));
	    emp.setUid(request.getParameter("UserId"));
	    emp.setPswd(request.getParameter("Password"));
	    emp.setLmuid((String)session.getAttribute("username"));
	    
	   empOperations.setEmp(emp);
	   empOperations.setEmpArray(empArray);

	empArray=(EmpArray) tableStub.empOperations(empOperations).get_return();
		String flag=empArray.getResult();
		
		System.out.println(flag);
		if(flag.equals("success")){
			request.setAttribute("successFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/empjsps/UpdateReturnEmp.jsp");
			reqDis.forward(request,response);
		}
	}

}
