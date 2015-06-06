package com.customerpayments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.CustomerPaymentMethod;
import com.table.operations.TableOperationsStub.CustomerPaymentMethodArray;
import com.table.operations.TableOperationsStub.OperationCustomerPaymentMethod;


public class SelectCustomerPaymentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		
		TableOperationsStub tableStub=new TableOperationsStub();
		 OperationCustomerPaymentMethod operationCustomerPaymentMethod=new OperationCustomerPaymentMethod();
		
		CustomerPaymentMethod paymentmethod=new CustomerPaymentMethod();
		CustomerPaymentMethodArray paymentmethodarray=new CustomerPaymentMethodArray();
		
		 
		 
		paymentmethodarray.setOperationName(Operations.SELECTBYID);
		String pid=request.getParameter("id");
		paymentmethod.setCustomerPaymentId(pid);
		operationCustomerPaymentMethod.setCustomerPayments(paymentmethod);
		operationCustomerPaymentMethod.setPaymentMethodArray(paymentmethodarray);

		Object obj= tableStub.operationCustomerPaymentMethod(operationCustomerPaymentMethod).get_return();
		
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof CustomerPaymentMethod){
			paymentmethod = (CustomerPaymentMethod)obj;			
		}
		
		request.setAttribute("paymentmethod", paymentmethod);
		RequestDispatcher reqDis = request.getRequestDispatcher("/CustomerJsp/updateCustomerPaymentMethod.jsp");
		reqDis.forward(request, response);
	
	}

}
