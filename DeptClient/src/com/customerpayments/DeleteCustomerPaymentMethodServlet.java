package com.customerpayments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.CustomerPaymentMethod;
import com.table.operations.TableOperationsStub.CustomerPaymentMethodArray;
import com.table.operations.TableOperationsStub.OperationCustomerPaymentMethod;

public class DeleteCustomerPaymentMethodServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 String str[] = request.getParameterValues("checkval");
			System.out.println(str.length);
			int count=0;
			if(str.length>0)
			{
				System.out.println("inside if block "+str.length);
				for(int i=0;i<str.length;i++)
				{
					System.out.println("inside for loop "+str[i]);
					String ch= str[i];
				
		 
		 TableOperationsStub operationStub=new TableOperationsStub();
		 OperationCustomerPaymentMethod operationCustomerPaymentMethod=new OperationCustomerPaymentMethod();
		 
		 CustomerPaymentMethod paymentMethod=new CustomerPaymentMethod();
		 paymentMethod.setCustomerPaymentId(ch);
		 System.out.println("PamentMethodId"+ch);
		 
		 CustomerPaymentMethodArray paymentMethodArray=new CustomerPaymentMethodArray();
		 paymentMethodArray.setOperationName(Operations.DELETE);
		 
		 operationCustomerPaymentMethod.setCustomerPayments(paymentMethod);
		 operationCustomerPaymentMethod.setPaymentMethodArray(paymentMethodArray);
		 operationStub.operationCustomerPaymentMethod(operationCustomerPaymentMethod).get_return();
				
		count++;
				}
			}
			else{    	
            	
            	out.print("No Records were selected to delete"); 	
            	
            }
			if(count>0)
			{
				request.setAttribute("count", count);
		 RequestDispatcher reqDis =  request.getRequestDispatcher("/CustomerJsp/DeleteCustomerPaymentReturn.jsp");
		 reqDis.forward(request, response);
			}
	System.out.println("one");
	
	

}
}
