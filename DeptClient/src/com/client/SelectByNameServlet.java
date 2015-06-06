package com.client;

import java.io.IOException;

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
 * Servlet implementation class SelectByNameServlet
 */
public class SelectByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TableOperationsStub stub = new TableOperationsStub();
		DeptOperations deptOperations = new DeptOperations();
		Dept dept = new Dept();
		DeptArray dArray = new DeptArray();
		dArray.setOperationName(Operations.SELECTBYNAME);
		String flag="failure";
		dept.setDeptName(request.getParameter("select"));
		deptOperations.setD(dept);
		deptOperations.setDArray(dArray);
		Object obj =  stub.deptOperations(deptOperations).get_return();
		Dept[] deptArray = new Dept[1];
		if(obj instanceof String){
			flag = (String) obj;
		}
		else if(obj instanceof Dept){
			deptArray[0] = (Dept)obj;
			
		}
		request.setAttribute("deptAll",deptArray);
		RequestDispatcher reqDisp = request.getRequestDispatcher("/deptjsps/selectAll.jsp");
		reqDisp.include(request, response);
		
	}

}
