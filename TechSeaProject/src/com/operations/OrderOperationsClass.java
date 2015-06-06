package com.operations;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.support.Order;
import com.support.OrderArray;
import com.support.SessionClass;

import java.util.*;
public class OrderOperationsClass 
{
	Order order=null;
	OrderArray orderArray=null;
	
	public OrderOperationsClass(Order order,OrderArray orderArray)
	{
		this.order=order;
		this.orderArray=orderArray;
	}
	public OrderArray insertOrder(Order order)
	{
		OrderArray orderArray= new OrderArray();
			
			Session session = SessionClass.getSession();
			session.beginTransaction();
			session.getNamedQuery("insertOrder").	 	
			setString("customerId",order.getCustomerId()).
			setString("orderStatusCode", order.getOrderStatusCode()).
			setString("orderDetails",order.getOrderDetails()).
			setString("orderPlaceDate", order.getOrderPlaceDate()).executeUpdate();
			 	 try
			 	 {
			 		session.getTransaction().commit();
		            orderArray.setResult("success");
			 	 }catch(Exception e)
			 	 {
			 		 e.printStackTrace();
			 	 }
			 	 System.out.println(orderArray.getResult());
		return orderArray;
		
	}
	
	public OrderArray updateOrder(Order order)
	{
		OrderArray orderArray= new OrderArray();
			
			Session session = SessionClass.getSession();
			Transaction transaction = session.beginTransaction();
			 Query query = session.getNamedQuery("updateOrder");
			 	query.setInteger("orderId",order.getOrderId());
			 	query.setString("customerId",order.getCustomerId());
			 	query.setString("orderStatusCode", order.getOrderStatusCode());
			 	query.setString("orderDetails",order.getOrderDetails());
			 	query.setString("orderPlaceDate", order.getOrderPlaceDate());
			 	 query.executeUpdate();
		            transaction.commit();
		            orderArray.setResult("success");
		return orderArray;
		
	}
	public OrderArray deleteOrder(Order order)
	{
		OrderArray orderArray= new OrderArray();
		Session session = SessionClass.getSession();
		Transaction transaction = session.beginTransaction();
		 session.getNamedQuery("deleteOrder").setInteger("orderId", order.getOrderId()).executeUpdate();	
		 try
	 	 {
            transaction.commit();
            orderArray.setResult("success");
	 	 }catch(Exception e)
	 	 {
	 		 e.printStackTrace();
	 	 }
		return orderArray;
		
	}
	public OrderArray selectAllOrder(Order order)
	{
		OrderArray orderArray= new OrderArray();
		Session session = SessionClass.getSession();
		Transaction transaction = session.beginTransaction();
		ArrayList arlist=(ArrayList)session.getNamedQuery("selectAllOrder").list();
		Order[] p=new Order[arlist.size()];
		Iterator itr= arlist.iterator();
		int i=0;
		while(itr.hasNext())
		{
		p[i]=(Order)itr.next();
		
		i++;
		}
		orderArray.setOrder(p);	
		
		return orderArray;
	}

	
	public Object selectByIdOrder(Order order)
	{
		Object obj=null;
		
		OrderArray orderArray= new OrderArray();
		Session session = SessionClass.getSession();
		Transaction transaction = session.beginTransaction();
		
		ArrayList list=(ArrayList)session.getNamedQuery("selectByIdOrder").setInteger("orderId", order.getOrderId()).list();
		
		 java.util.Iterator it = list.iterator();
		 int sizeOfList = list.size();
			while(it.hasNext())
			{
				order=(Order)it.next();
			}
				if(sizeOfList>0)
					obj=order;
					
				else
					obj=new String("failure");
			
		return obj;
		
	}
}
