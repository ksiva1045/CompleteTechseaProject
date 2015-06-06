package com.customerclient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customerclient.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Customer;
import com.table.operations.TableOperationsStub.CustomerArray;
import com.table.operations.TableOperationsStub.CustomerOperations;


/**
 * Servlet implementation class SelectAllCustomerServlet
 */
public class SelectAllCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	

TableOperationsStub stub = new TableOperationsStub();

CustomerOperations customerOperations=new CustomerOperations();
CustomerArray customerArray=new CustomerArray();
Customer customerObj=new Customer();


customerArray.setOperationName(Operations.SELECTALL);
customerOperations.setCustomerObj(customerObj);
customerOperations.setCustomerArray(customerArray);

	String id = request.getParameter("id");
	Customer[] customer=new Customer[1];
	if(id==null){

		customerArray = (CustomerArray) stub.customerOperations(customerOperations).get_return();
		 customer= customerArray.getCustomer();
	flag="success";
	 System.out.println(customer.length);
	for(int i=0;i<customer.length;i++){
		Customer customer1 = customer[i];
		//System.out.println(dept1);
		
		System.out.print(customer1.getCustomerid()+"\t");
		System.out.print(customer1.getGender()+"\t");
		System.out.println(customer1.getFirstname()+"\t");
		System.out.println(customer1.getMiddlename()+"\t");
		System.out.println(customer1.getLastname()+"\t");
		System.out.println(customer1.getEmail()+"\t");
		System.out.println(customer1.getAdd1()+"\t");
		System.out.println(customer1.getAdd2()+"\t");
		System.out.println(customer1.getAdd3()+"\t");
		System.out.println(customer1.getAdd4()+"\t");
		System.out.println(customer1.getCity()+"\t");
		System.out.println(customer1.getState()+"\t");
		System.out.println(customer1.getCountry()+"\t");
		System.out.println(customer1.getZipcode()+"\t");

	
		
		
	}
	}
	else{
		
		customerObj = new Customer();
		
		
		customerArray.setOperationName(Operations.SELECTBYID);
		customerOperations.setCustomerObj(customerObj);
		customerOperations.setCustomerArray(customerArray);
		Object obj = stub.customerOperations(customerOperations).get_return();
		
		if(obj instanceof String){
			flag = (String) obj;
		}
		else if(obj instanceof Customer){
			customer[0] = (Customer)obj;
			
		}
		
	
	}
	if(!flag.equals("failure")){
	
	request.setAttribute("customerAll", customer);
	RequestDispatcher reqDisp = request.getRequestDispatcher("/customerjsps/SelectAllCustomer.jsp");
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
