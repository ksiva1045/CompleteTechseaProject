package com.customerpayments;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.products.Operations;
import com.table.operations.TableOperationsStub;

import com.table.operations.TableOperationsStub.CustomerPaymentMethod;
import com.table.operations.TableOperationsStub.CustomerPaymentMethodArray;
import com.table.operations.TableOperationsStub.OperationCustomerPaymentMethod;


public class SelectAllCustomerPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SelectAllCustomerPayment() {
        super();
     
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		 System.out.println("hello");
			TableOperationsStub stub = new TableOperationsStub();
			 OperationCustomerPaymentMethod operationCustomerPaymentMethod=new OperationCustomerPaymentMethod();
			 
			 CustomerPaymentMethod paymentMethod=new CustomerPaymentMethod();
			 CustomerPaymentMethodArray paymentMethodArray=new CustomerPaymentMethodArray();
			
			 paymentMethodArray.setOperationName(Operations.SELECTALL);
			 operationCustomerPaymentMethod.setCustomerPayments(paymentMethod);
			 operationCustomerPaymentMethod.setPaymentMethodArray(paymentMethodArray);
			 paymentMethodArray=(CustomerPaymentMethodArray) stub.operationCustomerPaymentMethod(operationCustomerPaymentMethod).get_return();
		request.setAttribute("paymentMethodArray", paymentMethodArray);
		
		RequestDispatcher redDisp=request.getRequestDispatcher("/CustomerJsp/selectAllCustomerPaymentmethod.jsp");
		
		redDisp.forward(request, response);
			
		}
		
	}
