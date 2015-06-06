package com.orderitems;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.OrderItems;
import com.table.operations.TableOperationsStub.OrderItemsArray;
import com.table.operations.TableOperationsStub.OrderItemsOperations;


public class InsertOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TableOperationsStub operationstub=new TableOperationsStub();
		OrderItemsOperations orderItemsOperations=new OrderItemsOperations();
		OrderItems orderitems=new OrderItems();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		
		//orderitems.setOrderItemId(request.getParameter("orderItemId"));
		orderitems.setProductId(request.getParameter("productId"));
		System.out.println("inside servlet "+request.getParameter("productId"));
		orderitems.setOrderItemStatusCode(request.getParameter("orderItemStatusCode"));	
		orderitems.setOrderItemQuantity(request.getParameter("orderItemQuantity"));
		orderitems.setOrderItemPrice(request.getParameter("orderItemPrice"));
		orderitems.setMerchantAuthNbr(request.getParameter("merchantAuthNbr"));
		orderitems.setMerchantIssuedBy(request.getParameter("merchantIssuedBy"));
		orderitems.setOtherOrderItemsDetails(request.getParameter("otherOrderItemsDetails"));
		orderitems.setSellerId(request.getParameter("sellerId"));
		orderitems.setMerchantAuthDate(GetDate.getDate(request.getParameter("merchantAuthDate")));
		orderitems.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		
		orderItemsArray.setOperationName(Operations.INSERT);
		orderItemsOperations.setOrderItems(orderitems);
		orderItemsOperations.setOrderItemsArray(orderItemsArray);
		
		orderItemsArray=(OrderItemsArray) operationstub.orderItemsOperations(orderItemsOperations).get_return();
		String res	=orderItemsArray.getResult();
request.setAttribute("sucessFlag",res);
RequestDispatcher  rd=request.getRequestDispatcher("/OrderItems/insertReturnOrderItems.jsp");
rd.forward(request,response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	}
