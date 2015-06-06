package com.orders;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Order;
import com.table.operations.TableOperationsStub.OrderArray;
import com.table.operations.TableOperationsStub.OrderOperations;


public class SelectByIdOrderServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		
		TableOperationsStub tableStub=new TableOperationsStub();
		 OrderOperations operationOrder=new OrderOperations();
		 		
		 Order order=new Order();	 
		OrderArray orderArray=new OrderArray();
		 
		orderArray.setOperationName(Operations.SELECTBYID);
		int oid=Integer.parseInt(request.getParameter("id"));
		order.setOrderId(oid);
		operationOrder.setOrder(order);
		operationOrder.setOrderArray(orderArray);

		Object obj= tableStub.orderOperations(operationOrder).get_return();
		
		
		if(obj instanceof String){
			System.out.println(obj);
		}
		else if(obj instanceof Order)
		{
			order = (Order)obj;			
		}
		
		request.setAttribute("order", order);
		RequestDispatcher reqDis = request.getRequestDispatcher("/OrderJsp/UpdateOrder.jsp");
		reqDis.forward(request, response);
	
	}

}
