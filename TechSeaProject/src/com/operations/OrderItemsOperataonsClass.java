package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.OrderItems;
import com.support.OrderItemsArray;
import com.support.SessionClass;



public class OrderItemsOperataonsClass {
	
	OrderItems orderItems=null;
	OrderItemsArray orderItemsArray=null;
	public OrderItemsOperataonsClass(OrderItems orderItems,OrderItemsArray orderItemsArray){
		this.orderItems=orderItems;
		this.orderItemsArray=orderItemsArray;
	}
		
	
	public  OrderItemsArray insertOrderItems(OrderItems orderItems){
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		Session session=SessionClass.getSession();
		
		session.beginTransaction();
		session.getNamedQuery("insertORDER_ITEMS").
		setString("MERCHANT_AUTH_DATE",orderItems.getMerchantAuthDate()).
		setString("PRODUCT_ID",orderItems.getProductId()).
		setString("ORDER_ITEM_STATUS_CODE",orderItems.getOrderItemStatusCode()).
		setString("ORDER_ITEM_QUANTITY",orderItems.getOrderItemQuantity()).
		setString("ORDER_ITEM_PRICE",orderItems.getOrderItemPrice()).
		setString("MERCHANT_AUTH_NBR",orderItems.getMerchantAuthNbr()).
		setString("MERCHANT_ISSUED_BY",orderItems.getMerchantIssuedBy()).
		setString("OTHER_ORDER_ITEM_DETAILS",orderItems.getOtherOrderItemsDetails()).
		setString("SELLER_ID",orderItems.getSellerId()).
		setInteger("ORDER_ID",orderItems.getOrderId()).
		executeUpdate();
		try{
			session.getTransaction().commit();
			orderItemsArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orderItemsArray;
	
		}
	public OrderItemsArray updateOrderItems(OrderItems orderItems){
		
		Session session=SessionClass.getSession();
		OrderItemsArray orderItemsArray=new OrderItemsArray();
		session.beginTransaction();
		session.getNamedQuery("updateORDER_ITEMS").
		setString("ORDER_ITEM_ID",orderItems.getOrderItemId()).
		setString("MERCHANT_AUTH_DATE",orderItems.getMerchantAuthDate()).
		setString("PRODUCT_ID",orderItems.getProductId()).
		setString("ORDER_ITEM_STATUS_CODE",orderItems.getOrderItemStatusCode()).
		setString("ORDER_ITEM_QUANTITY",orderItems.getOrderItemQuantity()).
		setString("ORDER_ITEM_PRICE",orderItems.getOrderItemPrice()).
		setString("MERCHANT_AUTH_NBR",orderItems.getMerchantAuthNbr()).
		setString("MERCHANT_ISSUED_BY",orderItems.getMerchantIssuedBy()).
		setString("OTHER_ORDER_ITEM_DETAILS",orderItems.getOtherOrderItemsDetails()).
		setString("SELLER_ID",orderItems.getSellerId()).
		setInteger("ORDER_ID",orderItems.getOrderId()).
		executeUpdate();
		try{
			session.getTransaction().commit();
			orderItemsArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return orderItemsArray;
	
		}
	
	
public OrderItemsArray deleteOrderItems(OrderItems orderItems){
	Session session=SessionClass.getSession();
	OrderItemsArray orderItemsArray=new OrderItemsArray();
	session.beginTransaction();
	session.getNamedQuery("deleteORDER_ITEMS").setString("ORDER_ITEM_ID",orderItems.getOrderItemId()).
	executeUpdate();
	try{
		session.getTransaction().commit();
		orderItemsArray.setResult("success");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return orderItemsArray;

	}


public OrderItemsArray selectAll(){
	Session session=SessionClass.getSession();
	OrderItemsArray orderItemsArray=new OrderItemsArray();
	ArrayList list= (ArrayList)session.getNamedQuery("SelectORDER_ITEMS").list();
	OrderItems[] order1=new OrderItems[list.size()];
	Iterator it=list.iterator();
	int i=0;
	while(it.hasNext()){
		order1[i]=(OrderItems)it.next();
		i++;
	}
	orderItemsArray.setOrderItems(order1);
	return orderItemsArray;
	}


public Object  selectOrderItems(OrderItems orderItems){
	Session session=SessionClass.getSession();
	OrderItemsArray orderItemsArray=new OrderItemsArray();
	Object obj=null ;
	try{
	ArrayList list= (ArrayList)session.getNamedQuery("SelectbyidORDER_ITEMS").setString("ORDER_ITEM_ID",orderItems.getOrderItemId()).list();
	int sizeOfList=list.size();
	OrderItems[] order1=new OrderItems[list.size()];
	Iterator it=list.iterator();
	while(it.hasNext()){		
		orderItems = (OrderItems) it.next();
		System.out.println("inside service product id "+orderItems.getProductId());
	}

	if(sizeOfList>0) 
		obj=orderItems;
	else 
		obj=new String("failure");
	}
	catch(Exception e){
		e.printStackTrace();
		obj=new String("failure");
	}
	
	return obj;

	}

}
