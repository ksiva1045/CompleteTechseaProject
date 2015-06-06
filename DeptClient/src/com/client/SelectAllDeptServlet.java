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
 * Servlet implementation class SelectAllDeptServlet
 */
public class SelectAllDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	

TableOperationsStub stub = new TableOperationsStub();
DeptOperations deptOperations = new DeptOperations();
Dept deptObj = new Dept();
com.table.operations.TableOperationsStub.DeptArray dArray = new com.table.operations.TableOperationsStub.DeptArray();
dArray.setOperationName(Operations.SELECTALL);
deptOperations.setD(deptObj);
deptOperations.setDArray(dArray);

	String id = request.getParameter("id");
	Dept[] dept=new Dept[1];
	if(id==null){

		dArray = (DeptArray) stub.deptOperations(deptOperations).get_return();
		 dept= dArray.getDept();
	flag="success";
	 System.out.println(dept.length);
	for(int i=0;i<dept.length;i++){
		Dept dept1 = dept[i];
		//System.out.println(dept1);
		
		System.out.print(dept1.getDeptNo()+"\t");
		System.out.print(dept1.getDeptName()+"\t");
		System.out.print(dept1.getLocation()+"\t");
		System.out.print(dept1.getCreatedUserId()+"\t");
		System.out.print(dept1.getLastModifiedDate()+"\t");
		System.out.print(dept1.getLastModifiedUserId()+"\t");
		System.out.print(dept1.getUserCreatedDate()+"\n");
	
		
		
	}
	}
	else{
		
		 deptObj = new Dept();
		deptObj.setDeptName(id);
		deptObj.setDeptNo(id);
		dArray.setOperationName(Operations.SELECTALL);
		deptOperations.setD(deptObj);
		deptOperations.setDArray(dArray);
		Object obj = stub.deptOperations(deptOperations).get_return();
		if(obj instanceof String){
			flag = (String) obj;
		}
		else if(obj instanceof Dept){
			dept[0] = (Dept)obj;
			
		}
		
	
	}
	if(!flag.equals("failure")){
	
	request.setAttribute("deptAll", dept);
	RequestDispatcher reqDisp = request.getRequestDispatcher("/deptjsps/selectAll.jsp");
	reqDisp.include(request, response);
	}
	else
	{
		
	 	out.print("<center style='color:red'>");
    	out.print("<h2>");
    	out.print("No Records were selected to delete");
    	out.print("</h2>");
    	out.print("</center>");
	}
	}
		catch(Exception e){
			out.print("<center style='color:red'>");
	    	out.print("<h2>");
	    	out.print("No Record is found to Display");
	    	out.print("</h2>");
	    	out.print("</center>");
			
		}

	}
}
