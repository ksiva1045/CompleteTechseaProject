package com.orderitems;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.OrderItems;
import com.table.operations.TableOperationsStub.OrderItemsArray;
import com.table.operations.TableOperationsStub.OrderItemsOperations;


public class UpdateOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TableOperationsStub operationstub=new TableOperationsStub();
		OrderItemsOperations orderItemsOperations=new OrderItemsOperations();
		OrderItems orderitems=new OrderItems();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		HttpSession session=request.getSession(false);
		OrderItems orderitems1=(OrderItems)session.getAttribute("OrderItems");
		System.out.println("inside update servlet orderitem id"+orderitems1.getOrderItemId());
		orderitems.setOrderItemId(orderitems1.getOrderItemId());
		orderitems.setProductId(request.getParameter("PRODUCT_ID"));
		orderitems.setOrderItemStatusCode(request.getParameter("ORDER_ITEM_STATUS_CODE"));	
		orderitems.setOrderItemQuantity(request.getParameter("ORDER_ITEM_QUANTITY"));
		orderitems.setOrderItemPrice(request.getParameter("ORDER_ITEM_PRICE"));
		orderitems.setMerchantAuthNbr(request.getParameter("MERCHANT_AUTH_NBR"));
		orderitems.setMerchantIssuedBy(request.getParameter("MERCHANT_ISSUED_BY"));
		orderitems.setOtherOrderItemsDetails(request.getParameter("OTHER_ORDER_ITEM_DETAILS"));
		orderitems.setSellerId(request.getParameter("SELLER_ID"));
		orderitems.setMerchantAuthDate(GetDate.getDate(request.getParameter("MERCHANT_AUTH_DATE")));
		orderitems.setOrderId(Integer.parseInt(request.getParameter("ORDER_ID")));
		
		orderItemsArray.setOperationName(Operations.UPDATE);
		orderItemsOperations.setOrderItems(orderitems);
		orderItemsOperations.setOrderItemsArray(orderItemsArray);
		
		orderItemsArray=(OrderItemsArray) operationstub.orderItemsOperations(orderItemsOperations).get_return();
		String res	=orderItemsArray.getResult();
request.setAttribute("sucessFlag",res);
RequestDispatcher  rd=request.getRequestDispatcher("/OrderItems/UpdateReturnOrderItems.jsp");
rd.forward(request,response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	}
