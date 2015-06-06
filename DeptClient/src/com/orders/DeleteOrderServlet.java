package com.orders;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Order;
import com.table.operations.TableOperationsStub.OrderArray;
import com.table.operations.TableOperationsStub.OrderOperations;

public class DeleteOrderServlet extends HttpServlet 
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
					int ch= Integer.parseInt(str[i]);
				
		 
		 TableOperationsStub operationStub=new TableOperationsStub();
		 OrderOperations operationOrder=new OrderOperations();
		 
		 Order order=new Order();
		 order.setOrderId(ch);
		 System.out.println("PamentMethodId"+ch);
		 
		 OrderArray orderArray=new OrderArray();
		 orderArray.setOperationName(Operations.DELETE);
		 
		 operationOrder.setOrder(order);
		 operationOrder.setOrderArray(orderArray);
		 operationStub.orderOperations(operationOrder).get_return();
				
		count++;
				}
			}
			else{    	
            	
            	out.print("No Records were selected to delete"); 	
            	
            }
			if(count>0)
			{
				request.setAttribute("count", count);
		 RequestDispatcher reqDis =  request.getRequestDispatcher("/OrderJsp/DeleteOrderReturn.jsp");
		 reqDis.forward(request, response);
			}
	System.out.println("one");
	
	

}
}
