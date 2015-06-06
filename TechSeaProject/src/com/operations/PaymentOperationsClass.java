package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Payment;
import com.support.PaymentArray;
import com.support.SessionClass;



public class PaymentOperationsClass {
 
	Payment p=null;
	PaymentArray pArray = null;
	public  PaymentOperationsClass(Payment p, PaymentArray pArray) {
		
	
		this.p = p;
		this.pArray=pArray;
		
	}
	public PaymentArray insert(Payment p){
		PaymentArray pp = new PaymentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
			    
			    
		//insert
		  session.getNamedQuery("paymentinsert").
		   setInteger("PAYMENT_ID1",p.getPAYMENT_ID()).
		   setString("PAYMENT_DETAILS1", p.getPAYMENT_DETAILS()).
		   setString("INVOICE_ID1",p.getINVOICE_ID()).
		   setString("PAYMENT_STATUS1",p.getPAYMENT_STATUS()).
		   setString("PAYMENT_DATE1",p.getPAYMENT_DATE()).
		   setString("PAYMENT_AMOUNT1",p.getPAYMENT_AMOUNT()).executeUpdate();
		  try{
			  session.getTransaction().commit();
			  pp.setResult("success");
		  }
		  catch(Exception e){
			  
		  }
		  
		   System.out.println("successfully saved"); 
 		       
		   return pp;
		   
		   
		  //update   
			}  
	
	public PaymentArray update(Payment p){
		PaymentArray pp = new PaymentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
			  System.out.println(p.getPAYMENT_ID());  
			    
		//insert
		  session.getNamedQuery("paymentupdate").
		   setInteger("PAYMENT_ID1",p.getPAYMENT_ID()).
		   setString("PAYMENT_DETAILS1", p.getPAYMENT_DETAILS()).
		   setString("INVOICE_ID1",p.getINVOICE_ID()).
		   setString("PAYMENT_STATUS1",p.getPAYMENT_STATUS()).
		   setString("PAYMENT_DATE1",p.getPAYMENT_DATE()).
		   setString("PAYMENT_AMOUNT1",p.getPAYMENT_AMOUNT()).executeUpdate();
		  session.getTransaction().commit();
		  pp.setResult("success");
		   System.out.println("successfully updated"); 
		       
		   return pp;
		   
		   
		  //delete 
			}  
	
	public PaymentArray delete(Payment p){
		PaymentArray pp = new PaymentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
	 session.getNamedQuery("paymentdelete").
	 setInteger("PAYMENT_ID1",p.getPAYMENT_ID()).executeUpdate();
	session.getTransaction().commit();
	pArray.setResult("success");
	 System.out.println("deleted ");
	return pp;
	}	
	
	
	public Object select(Payment p){
		Session session = SessionClass.getSession();
		System.out.println("inside payment Operations");
		

		Object obj=null ;
		try{
		ArrayList list = (ArrayList) session.getNamedQuery("paymentselect").
				 setInteger("PAYMENT_ID1",p.getPAYMENT_ID()).list();
		java.util.Iterator i = list.iterator();
		int sizeOfList = list.size();
		while(i.hasNext()){		
			p= (Payment) i.next();	
		}

		if(sizeOfList>0) 
			obj=p;
		else 
			obj=new String("failure");


		}
		catch(Exception e){
			e.printStackTrace();
			obj=new String("failure");
		}
		return obj;
		}	
	public PaymentArray selectAll(Payment p){
		
		Session session = SessionClass.getSession();
		Object object=null;
		
			ArrayList list= (ArrayList) session.getNamedQuery("paymentselectall").list();
			Iterator it = list.iterator();
			System.out.println(list);
			
			Payment[] p1 = new Payment[list.size()];
			int i=0;
	while(it.hasNext()){
				
				p1[i]=(Payment) it.next();
				//System.out.println(dept[i].getCreatedUserId());
				
				i++;
			}
	PaymentArray pArray = new PaymentArray();
			pArray.setPayments(p1);
			object = pArray;
			
		
		return (PaymentArray) object;
	}
}
