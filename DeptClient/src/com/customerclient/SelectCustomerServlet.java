package com.customerclient;

import java.io.IOException;





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
import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.DeptArray;
import com.table.operations.TableOperationsStub.DeptOperations;

/**
 * Servlet implementation class SelectCustomerServlet
 */
public class SelectCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 session.setAttribute("username",session.getAttribute("username")); 
		 TableOperationsStub stub = new TableOperationsStub();
		 CustomerOperations customerOperations=new CustomerOperations();
		 Customer customer=new Customer();
		 CustomerArray customerArray=new CustomerArray();
		 customer.setCustomerid(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		customerArray.setOperationName(Operations.SELECTBYID);
		customerOperations.setCustomerObj(customer);
		customerOperations.setCustomerArray(customerArray);
		
		Object obj = stub.customerOperations(customerOperations).get_return();
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Customer){
			customer = (Customer)obj;
			
		}
		System.out.println(customer.getGender());
		System.out.println(customer.getFirstname());
		System.out.println(customer.getMiddlename());
		System.out.println(customer.getLastname());
		System.out.println(customer.getEmail());
		System.out.println(customer.getAdd1());
		System.out.println(customer.getAdd2());
		System.out.println(customer.getAdd3());
		System.out.println(customer.getAdd4());
		System.out.println(customer.getCity());
		System.out.println(customer.getState());
		System.out.println(customer.getCountry());
		System.out.println(customer.getZipcode());

		
		request.setAttribute("customerObj", customer);
		RequestDispatcher reqDis = request.getRequestDispatcher("/customerjsps/UpdateCustomer.jsp");
		reqDis.forward(request, response);
	}

}
