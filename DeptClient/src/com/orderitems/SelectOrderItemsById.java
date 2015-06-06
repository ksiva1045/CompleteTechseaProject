package com.orderitems;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.Operations;
import com.table.operations.TableOperationsStub;
//import com.table.operations.TableOperationsStub.Dept;
import com.table.operations.TableOperationsStub.OrderItems;
import com.table.operations.TableOperationsStub.OrderItemsArray;
import com.table.operations.TableOperationsStub.OrderItemsOperations;


public class SelectOrderItemsById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TableOperationsStub operationstub=new TableOperationsStub();
		OrderItemsOperations orderItemsOperations=new OrderItemsOperations();
		OrderItems oredritems=new OrderItems();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		String str=request.getParameter("ById");
		System.out.println(str);
		oredritems.setOrderItemId(str);
		orderItemsArray.setOperationName(Operations.SELECTBYID);
		orderItemsOperations.setOrderItems(oredritems);
		orderItemsOperations.setOrderItemsArray(orderItemsArray);
		Object obj= operationstub.orderItemsOperations(orderItemsOperations).get_return();

		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof OrderItems ){
			oredritems = (OrderItems) obj;
		}
		request.setAttribute("oredritems",obj);
RequestDispatcher  rd=request.getRequestDispatcher("/OrderItems/UpdateOrderItems.jsp");
rd.forward(request,response);
}
	}
