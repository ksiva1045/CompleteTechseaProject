package com.employeeclient;

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
import com.table.operations.TableOperationsStub.Emp;
import com.table.operations.TableOperationsStub.EmpArray;
import com.table.operations.TableOperationsStub.EmpOperations;

public class SelectAllEmpServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String flag="";
			try{	
				TableOperationsStub tableStub=new TableOperationsStub();
			EmpOperations empOperations=new EmpOperations();
			EmpArray empArray=new EmpArray();			
			Emp emp=new Emp();
				String id = request.getParameter("id");
				Emp[] emp1=new Emp[1];
				if(id==null){
					
					empArray.setOperationName(Operations.SELECTALL);
					empOperations.setEmp(emp);
					empOperations.setEmpArray(empArray);
				
					empArray=(EmpArray) tableStub.empOperations(empOperations).get_return();					
					emp1=empArray.getEmp();
				}
				
							
				else{
					
					Emp empObj = new Emp();
					empObj.setEno(id);
					empArray.setOperationName(Operations.SELECTBYID);
					empOperations.setEmp(empObj);
					empOperations.setEmpArray(empArray);
					
			Object obj=tableStub.empOperations(empOperations).get_return();

			
					if(obj instanceof String){
						flag = (String) obj;
					}
					else if(obj instanceof Emp){
						emp1[0] = (Emp)obj;			
					}
				}
				if(!flag.equals("failure")){
					request.setAttribute("empAll", emp1);
					System.out.println("success");

					RequestDispatcher reqDisp = request.getRequestDispatcher("/empjsps/SelectAllEmp.jsp");
					reqDisp.include(request, response);
					System.out.println("success1");

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
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
	}*/
	}
		