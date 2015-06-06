package com.operations;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.support.CustomerPaymentMethod;
import com.support.CustomerPaymentMethodArray;
import com.support.SessionClass;

	public class CustomerPaymentMethodOperationsClass 
	{
		CustomerPaymentMethod customerPaymentsMethod=null;
		CustomerPaymentMethodArray paymentArray =null;
		public CustomerPaymentMethodOperationsClass(CustomerPaymentMethod customerPaymentsMethod,CustomerPaymentMethodArray paymentArray)
		{
			System.out.println("customer");
			this.customerPaymentsMethod=customerPaymentsMethod;
			this.paymentArray=paymentArray;
			System.out.println(paymentArray+" : "+customerPaymentsMethod);
		}
		   

	    Session session = SessionClass.getSession();

	    
	    Transaction transaction = session.beginTransaction();
	    
		public CustomerPaymentMethodArray insertCustomerPaymentMethod(CustomerPaymentMethod customerPaymentsMethod)
		{
			CustomerPaymentMethodArray paymentArray=new CustomerPaymentMethodArray();
			
			try {
		        
	            Query query = session.getNamedQuery("insertCustomerPamentMethod");
	           
	            System.out.println("Inside Service Insert:::"+customerPaymentsMethod.getPaymentMethodCode());
	            
	            query.setInteger("cid", customerPaymentsMethod.getCustomerId());
	            query.setString("mcode", customerPaymentsMethod.getPaymentMethodCode());
	            query.setString("dts1", customerPaymentsMethod.getPaymentMethodDetails1());
	            query.setString("dts2", customerPaymentsMethod.getPaymentMethodDetails2());
	            query.executeUpdate();
	            transaction.commit();
	            paymentArray.setResult("success");
	         
	 
	        } catch (HibernateException e)
	        {
	            e.printStackTrace();
	            System.out.println("error");
	        }
			return paymentArray;
		
		}
		public CustomerPaymentMethodArray updateCustomerPaymentMethod(CustomerPaymentMethod customerPaymentsMethod)
		{
			CustomerPaymentMethodArray paymentArray=new CustomerPaymentMethodArray();
			
			Query query =session.getNamedQuery("updateCustomerPamentMethod");
			 System.out.println(customerPaymentsMethod.getCustomerPaymentId());
			 System.out.println(customerPaymentsMethod.getPaymentMethodCode());
			 System.out.println(customerPaymentsMethod.getCustomerId());
			 
			 
			 
	         query.setString("pid", customerPaymentsMethod.getCustomerPaymentId());
	         query.setInteger("cid",customerPaymentsMethod.getCustomerId());
	         query.setString("mcode", customerPaymentsMethod.getPaymentMethodCode());
	         query.setString("dts1", customerPaymentsMethod.getPaymentMethodDetails1() );
	         query.setString("dts2", customerPaymentsMethod.getPaymentMethodDetails2());
	         query.executeUpdate();
	         try
	         {
	         transaction.commit();
	         paymentArray.setResult("success");
	         }
	         catch(Exception e)
	         {
	        	 e.printStackTrace();
	         }
			return paymentArray;
		}
		public CustomerPaymentMethodArray deleteCustomerPaymentMethod(CustomerPaymentMethod customerPaymentsMethod)
		{
			System.out.println("two");
			CustomerPaymentMethodArray paymentArray=new CustomerPaymentMethodArray();
			
			    session.getNamedQuery("deleteCustomerPamentMethod").setString("pid",customerPaymentsMethod.getCustomerPaymentId()).executeUpdate();
			    try
			    {
			    session.getTransaction().commit();
			    paymentArray.setResult("success");
			    }catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
			    return paymentArray;
		    }
		public CustomerPaymentMethodArray selectAllCustomerDetails()
		{
			CustomerPaymentMethodArray paymentArray=new CustomerPaymentMethodArray();
			
			ArrayList obj=(ArrayList)session.getNamedQuery("selectallCustomerPamentMethod").list();
			CustomerPaymentMethod[] p=new CustomerPaymentMethod[obj.size()];
			Iterator itr= obj.iterator();
			int i=0;
			while(itr.hasNext())
			{
				
				p[i]=(CustomerPaymentMethod)itr.next();
				i++;
			}
			//System.out.println(p[i]);
			paymentArray.setCustomerPaymentMethod(p);
			return paymentArray;
		}
		public Object selectCustomerPaymentMethod(CustomerPaymentMethod customerPaymentsMethod)
		{
			Object obj=null;
			CustomerPaymentMethod	customer=null;
			
			 ArrayList list=(ArrayList)session.getNamedQuery("selectByIdCustomerPamentMethod").setString("pid",customerPaymentsMethod.getCustomerPaymentId()).list();
			 java.util.Iterator it = list.iterator();
			 int sizeOfList = list.size();
			while(it.hasNext())
			{
				customer=(CustomerPaymentMethod)it.next();
			}
				if(sizeOfList>0)
					obj=customer;
					
				else
					obj=new String("failure");
			
				return obj;
					
			
		}
	}
		



