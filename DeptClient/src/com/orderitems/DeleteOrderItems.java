package com.orderitems;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.OrderItems;
import com.table.operations.TableOperationsStub.OrderItemsArray;
import com.table.operations.TableOperationsStub.OrderItemsOperations;


public class DeleteOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//OrderItemsArray orderItemsArray=new OrderItemsArray();
		 int count=0;
		PrintWriter out=response.getWriter();
		String[] str=request.getParameterValues("checkval");
		System.out.println(str.length);
		
		if(str.length>0){
		for(int i=0;i<str.length;i++){
		
		TableOperationsStub operationstub=new TableOperationsStub();
		OrderItemsOperations orderItemsOperations=new OrderItemsOperations();
		OrderItems oredritems=new OrderItems();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		
		orderItemsArray.setOperationName("delete");
		System.out.println(str[i]);
		String value=str[i];
		oredritems.setOrderItemId(value);
		orderItemsOperations.setOrderItems(oredritems);
		orderItemsOperations.setOrderItemsArray(orderItemsArray);
		orderItemsArray=(OrderItemsArray) operationstub.orderItemsOperations(orderItemsOperations).get_return();
		count++;
		}
		
	}
		else{
			out.print("<center style='color:red'>");
        	out.print("<h2>");
        	out.print("No Records were selected to delete");
        	out.print("</h2>");
        	out.print("</center>");
        	
        	
        }
		if(count>0){
			System.out.println(count);

			request.setAttribute("count", count);

			//request.setAttribute("success",orderItemsArray);
	RequestDispatcher  rd=request.getRequestDispatcher("/OrderItems/DeleteOrderItems.jsp");
	rd.forward(request,response);
	}

		}
}
