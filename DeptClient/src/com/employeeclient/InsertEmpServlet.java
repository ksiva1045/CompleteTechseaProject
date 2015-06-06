package com.employeeclient;

import java.io.IOException;
import java.io.PrintWriter;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Emp;
import com.table.operations.TableOperationsStub.EmpArray;
import com.table.operations.TableOperationsStub.EmpOperations;


public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");			
				
				HttpSession session = request.getSession(false);
				TableOperationsStub table=new TableOperationsStub();
				EmpOperations empOperations=new EmpOperations();
				EmpArray empArray=new EmpArray();
				Emp emp=new Emp();
				
				empArray.setOperationName(Operations.INSERT);
				
				emp.setEname(request.getParameter("Empname"));
				emp.setEskill(request.getParameter("Empskill"));
				emp.setEpdesc(request.getParameter("Empprodesc"));
				emp.setHiredate(GetDate.getDate(request.getParameter("Hiredate")));
				emp.setMname(request.getParameter("ManagerName"));
				emp.setDno(request.getParameter("Deptno"));
				emp.setUid(request.getParameter("Userid"));
				emp.setPswd(request.getParameter("Pswd"));
				emp.setCuid((String)session.getAttribute("username"));



				
				empOperations.setEmp(emp);
				empOperations.setEmpArray(empArray);
				
				empArray =(EmpArray) table.empOperations(empOperations).get_return();
				String flag = empArray.getResult();
				System.out.println(flag);
	
	request.setAttribute("sucessFlag",flag);
	
	RequestDispatcher reqDis =  request.getRequestDispatcher("/empjsps/InsertReturnEmp.jsp");
	reqDis.forward(request, response);		
}

}
