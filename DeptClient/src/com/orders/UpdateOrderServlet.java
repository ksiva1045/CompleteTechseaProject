package com.orders;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Order;
import com.table.operations.TableOperationsStub.OrderArray;
import com.table.operations.TableOperationsStub.OrderOperations;


public class UpdateOrderServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 
		
		 TableOperationsStub operationStub=new TableOperationsStub();
	
		 
		 OrderOperations operationOrder=new OrderOperations();
		 Order order=new Order();

			HttpSession session = request.getSession(false);
			
			Order odr = (Order)session.getAttribute("order");
			order.setOrderId(odr.getOrderId());
			order.setCustomerId(request.getParameter("cid"));
			order.setOrderStatusCode(request.getParameter("satusCode"));
			order.setOrderDetails(request.getParameter("details1"));
			order.setOrderPlaceDate(GetDate.getDate(request.getParameter("placeDate")));
			
			 OrderArray orderArray=new OrderArray();
		 
			 orderArray.setOperationName(Operations.UPDATE);
			 operationOrder.setOrder(order);
			 operationOrder.setOrderArray(orderArray);;
		 
			 orderArray=(OrderArray) operationStub.orderOperations(operationOrder).get_return();
		 String flag=orderArray.getResult();
		 request.setAttribute("successFlag",flag);
		 RequestDispatcher reqDis =  request.getRequestDispatcher("/OrderJsp/UpdateOrderReturn.jsp");
		 reqDis.forward(request, response);
		 
	}

}
