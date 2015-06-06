package com.orders;

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.products.Operations;
import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.Order;
import com.table.operations.TableOperationsStub.OrderArray;
import com.table.operations.TableOperationsStub.OrderOperations;


public class SelectAllOrderServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public SelectAllOrderServlet() {
        super();
     
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		 
			TableOperationsStub stub = new TableOperationsStub();
			 OrderOperations operationOrder=new OrderOperations();
			 Order order=new Order();
			 
			 OrderArray orderArray=new OrderArray();
			 orderArray.setOperationName(Operations.SELECTALL);
			 
			 operationOrder.setOrder(order);
			 operationOrder.setOrderArray(orderArray);
			
			 orderArray=(OrderArray) stub.orderOperations(operationOrder).get_return();
			 
		request.setAttribute("orderArray", orderArray);
		 System.out.println("inside in order selectall"+orderArray);
		RequestDispatcher rd=request.getRequestDispatcher("/OrderJsp/SelectAllOrder.jsp");
		rd.forward(request, response);
			
		}
		
	}
