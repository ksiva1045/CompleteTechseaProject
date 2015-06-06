package com.orderitems;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.OrderItems;
import com.table.operations.TableOperationsStub.OrderItemsArray;
import com.table.operations.TableOperationsStub.OrderItemsOperations;


public class SelectAllOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TableOperationsStub operationstub=new TableOperationsStub();
		OrderItemsOperations orderItemsOperations=new OrderItemsOperations();
		OrderItems oredritems=new OrderItems();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		
		orderItemsArray.setOperationName("selectAll");
		orderItemsOperations.setOrderItems(oredritems);
		orderItemsOperations.setOrderItemsArray(orderItemsArray);
		
		orderItemsArray=(OrderItemsArray) operationstub.orderItemsOperations(orderItemsOperations).get_return();
		request.setAttribute("orderItemsArray",orderItemsArray);
RequestDispatcher  rd=request.getRequestDispatcher("/OrderItems/SelectAllOrderItems.jsp");
rd.forward(request,response);
}
	}
