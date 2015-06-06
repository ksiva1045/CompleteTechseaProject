package com.customerclient;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerclient.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Customer;
import com.table.operations.TableOperationsStub.CustomerArray;
import com.table.operations.TableOperationsStub.CustomerOperations;


/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag="failure";
		TableOperationsStub stub = new TableOperationsStub();
		CustomerOperations customerOperations=new CustomerOperations();
		CustomerArray customerArray=new CustomerArray();
		Customer customer=new Customer();
		
		customerArray.setOperationName(Operations.UPDATE);
		
		customerOperations.setCustomerArray(customerArray);
		customerOperations.setCustomerObj(customer);
	
	
		HttpSession session = request.getSession(false);
	Customer customer1 = (Customer) session.getAttribute("customer");
    customer.setCustomerid(customer1.getCustomerid());
	customer.setGender(request.getParameter("gender"));
	customer.setFirstname(request.getParameter("firstname"));
	customer.setMiddlename(request.getParameter("middlename"));
	customer.setLastname(request.getParameter("lastname"));
	customer.setEmail(request.getParameter("email"));
	customer.setLoginname(request.getParameter("loginname"));
	customer.setLoginpassword(request.getParameter("loginpassword"));
	customer.setPhonenumber(request.getParameter("phonenumber"));
	customer.setAdd1(request.getParameter("add1"));
	customer.setAdd2(request.getParameter("add2"));
	customer.setAdd3(request.getParameter("add3"));
	customer.setAdd4(request.getParameter("add4"));
	
	customer.setCity(request.getParameter("city"));
	customer.setState(request.getParameter("state"));
	customer.setCountry(request.getParameter("country"));
	customer.setZipcode(request.getParameter("zipcode"));
	
		
		System.out.println("hi update servlet");
	//customerArray=(CustomerArray) stub.customerOperations(customerOperations).get_return();
		customerArray=(CustomerArray) stub.customerOperations(customerOperations).get_return();
		System.out.println("hi update servlet");
		flag = customerArray.getResult();
		if(flag.equals("success")){
			request.setAttribute("successFlag",flag);
			
			RequestDispatcher reqDis = 	request.getRequestDispatcher("/customerjsps/UpdateCustomerReturn.jsp");
			reqDis.forward(request,response);
		}
	}

}
