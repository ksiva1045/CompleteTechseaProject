package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;





import com.support.Deal;
import com.support.DealArray;
import com.support.Invoices;
import com.support.InvoicesArray;
import com.support.SessionClass;

public class InvoicesOperations {
	Invoices invoices=null;
	InvoicesArray invoicesarray=null;
	public InvoicesOperations(Invoices invoices,InvoicesArray invoicesarray){
		this.invoices=invoices;
		this.invoicesarray=invoicesarray;
	}
	public InvoicesArray insertInvoice(Invoices invoices){
		InvoicesArray invoicesarray= new InvoicesArray();
		Session session= SessionClass.getSession();
		session.beginTransaction();
		
		System.out.println(invoices.getINVOICE_ID());
		System.out.println(invoices.getINVOICE_DATE());
		
		session.getNamedQuery("insertInvoices").
		setString("INVOICE_ID", invoices.getINVOICE_ID()).
		setInteger("ORDER_ID", invoices.getORDER_ID()).
		setString("INVOICE_STATUS_CODE",invoices.getINVOICE_STATUS_CODE()).
		setString("INVOICE_DATE", invoices.getINVOICE_DATE()).
		setString("INVOICE_DETAILS", invoices.getINVOICE_DETAILS()).executeUpdate();
		session.getTransaction().commit();
		invoicesarray.setResult("success");
		session.close();
		return invoicesarray ;}
	
	public InvoicesArray updateInvoice(Invoices invoices){
		InvoicesArray invoicesarray= new InvoicesArray();
		Session session= SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("updateInvoices").
		setString("INVOICE_ID", invoices.getINVOICE_ID()).
		setInteger("ORDER_ID", invoices.getORDER_ID()).
		setString("INVOICE_STATUS_CODE",invoices.getINVOICE_STATUS_CODE()).
		setString("INVOICE_DATE", invoices.getINVOICE_DATE()).
		setString("INVOICE_DETAILS", invoices.getINVOICE_DETAILS()).executeUpdate();
		
		session.getTransaction().commit();
		invoicesarray.setResult("success");
		session.close();
		return invoicesarray;
		}
	public InvoicesArray deleteInvoice(Invoices invoices){
		InvoicesArray invoicesarray= new InvoicesArray();
		Session session= SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("deleteInvoices").
		setString("INVOICE_ID", invoices.getINVOICE_ID()).executeUpdate();
		session.getTransaction().commit();
		invoicesarray.setResult("success");
		session.close();
		return invoicesarray;
		
	}
	
	public Object selectInvoice(Invoices invoices){
		InvoicesArray invoicesarray= new InvoicesArray();
		Session session= SessionClass.getSession();
		session.beginTransaction();
		Object obj= null;
		ArrayList list = (ArrayList) session.getNamedQuery("selectByIdInvoices").setString("INVOICE_ID", invoices.getINVOICE_ID()).list();
		java.util.Iterator i = list.iterator();
		int sizeOfList = list.size();
		while(i.hasNext()){
			obj=(Object)i.next();
			invoices= (Invoices)obj;
			if(sizeOfList>0) {
				obj=invoices;
			}
			else {
				obj=new String("failure");
			}
		}
		return obj;
	}
	
	public InvoicesArray selectAll(){

		Session session = SessionClass.getSession();
		session.beginTransaction();
		ArrayList list= (ArrayList) session.getNamedQuery("selectAllInvoices").list();
		Iterator it = list.iterator();
		System.out.println(list);

		Invoices[] invoices = new Invoices[list.size()];
		int i=0;
		while(it.hasNext()){			
			invoices[i]=(Invoices) it.next();
			i++;}
		InvoicesArray invoicesarray = new InvoicesArray();
		invoicesarray.setInvoice(invoices);		
		return invoicesarray;

		}

}
