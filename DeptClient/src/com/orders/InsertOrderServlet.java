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

public class InsertOrderServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		 String flag=null;
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
	
		 TableOperationsStub operationStub=new TableOperationsStub();
		 OrderOperations operationOrder=new OrderOperations();
		 Order order=new Order();
		 order.setCustomerId(request.getParameter("cid"));
		 order.setOrderStatusCode(request.getParameter("statusCode"));
		 order.setOrderDetails(request.getParameter("orderdetail"));
		 order.setOrderPlaceDate(GetDate.getDate(request.getParameter("placeDate")));
		 
		 OrderArray orderArray=new OrderArray();
		 orderArray.setOperationName(Operations.INSERT);
		 operationOrder.setOrder(order);
		 operationOrder.setOrderArray(orderArray);
		 		 
		 orderArray=(OrderArray)operationStub.orderOperations(operationOrder).get_return();

		 flag=orderArray.getResult();

		 request.setAttribute("sucessFlag",flag);
		 RequestDispatcher reqDis =  request.getRequestDispatcher("/OrderJsp/InsertOrderReturn.jsp");
		 reqDis.forward(request, response);
	}  
	

}
