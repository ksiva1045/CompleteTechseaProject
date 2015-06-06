package com.customerpayments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.CustomerPaymentMethod;
import com.table.operations.TableOperationsStub.CustomerPaymentMethodArray;
import com.table.operations.TableOperationsStub.OperationCustomerPaymentMethod;


public class InsertCustomerPaymentsServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 
		 
		 TableOperationsStub operationStub=new TableOperationsStub();
		 OperationCustomerPaymentMethod operationCustomerPaymentMethod=new OperationCustomerPaymentMethod();
		 
		 CustomerPaymentMethod paymentMethod=new CustomerPaymentMethod();
		 System.out.println(request.getParameter("cid"));
		 paymentMethod.setCustomerId(Integer.parseInt(request.getParameter("cid")));
		 paymentMethod.setPaymentMethodCode(request.getParameter("paymentCode"));
		 paymentMethod.setPaymentMethodDetails1(request.getParameter("details1"));
		 paymentMethod.setPaymentMethodDetails2(request.getParameter("details2"));
		 
		 
		 CustomerPaymentMethodArray paymentMethodArray=new CustomerPaymentMethodArray();
		 paymentMethodArray.setOperationName(Operations.INSERT);
		 operationCustomerPaymentMethod.setCustomerPayments(paymentMethod);
		 operationCustomerPaymentMethod.setPaymentMethodArray(paymentMethodArray);
		 
		 paymentMethodArray=(CustomerPaymentMethodArray) operationStub.operationCustomerPaymentMethod(operationCustomerPaymentMethod).get_return();
		 String flag=paymentMethodArray.getResult();
		 request.setAttribute("sucessFlag",flag);
		 RequestDispatcher reqDis =  request.getRequestDispatcher("/CustomerJsp/InsertRetunCustomerPayment.jsp");
		 reqDis.forward(request, response);
		 
	}

}
