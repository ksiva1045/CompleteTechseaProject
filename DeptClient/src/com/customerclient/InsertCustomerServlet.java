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
 * Servlet implementation class InsertCustomerServlet
 */
public class InsertCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag = "false";
		response.setContentType("text/html");
try{
		TableOperationsStub table = new TableOperationsStub();
		
		
		CustomerOperations customerOperations=new CustomerOperations();
		HttpSession session = request.getSession(false);
		Customer customer=new Customer();
		System.out.println(session.getAttribute("username"));
		//customer.setCustomerid((String)session.getAttribute("username"));
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
		
		System.out.println(request.getParameter("gender"));
		
		CustomerArray customerArray=new CustomerArray();
		
		customerArray.setOperationName(Operations.INSERT);
		
		customerOperations.setCustomerObj(customer);
		customerOperations.setCustomerArray(customerArray);
		
		customerArray=(CustomerArray) table.customerOperations(customerOperations).get_return();
	flag =  customerArray.getResult();
	System.out.println(flag);
	out.println("hi");
	
	}
	catch(Exception e){
	e.printStackTrace();
	}
		
		request.setAttribute("successFlag",flag);
		RequestDispatcher reqDis =  request.getRequestDispatcher("/customerjsps/InsertCustomerReturn.jsp");
		reqDis.forward(request, response);
		
	}

}
