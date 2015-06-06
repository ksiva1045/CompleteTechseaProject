package com.operations;



	import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Customer;
import com.support.CustomerArray;
import com.support.SessionClass;

	public class CustomerOperationClass {		
	Customer customer=null;
		CustomerArray customerArray = null;
		
		public CustomerOperationClass(Customer customer,CustomerArray customerArray){
			
			this.customer = customer;
			this.customerArray=customerArray;
			
		}

	//insertDept is a method to insert data into department table
		
		
	public CustomerArray insertCustomer(Customer customer){
	CustomerArray customerArray = new CustomerArray();
		 //customer=new Customer();
	
	Session session = SessionClass.getSession();
	session.beginTransaction();

	session.getNamedQuery("insertcustomer").
	//setString("customerid", customer.getCustomerid()).
	setString("gender", customer.getGender()).
	setString("firstname", customer.getFirstname()).
	setString("middlename", customer.getMiddlename()).
	setString("lastname", customer.getLastname()).
	setString("email", customer.getEmail()).
	setString("loginname", customer.getLoginname()).
	setString("loginpassword", customer.getLoginpassword()).
	setString("phonenumber", customer.getPhonenumber()).
	setString("add1", customer.getAdd1()).
	setString("add2", customer.getAdd2()).
	setString("add3", customer.getAdd3()).
	setString("add4", customer.getAdd4()).
	setString("city", customer.getCity()).
	setString("state", customer.getState()).
	setString("country", customer.getCountry()).
	setString("zipcode", customer.getZipcode()).executeUpdate();
	session.getTransaction().commit();
	System.out.println(customer.getGender());
	System.out.println("hi insert");
	customerArray.setResult("success");
		return customerArray;
	}

	//delete dept is a method to delete a specific records in department table
	public CustomerArray deleteCustomer(Customer customer){
		CustomerArray customerArray = new CustomerArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
	    session.getNamedQuery("deletecustomer").
	    setString("customerid", customer.getCustomerid()).executeUpdate();
		try{
		session.getTransaction().commit();
		customerArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return customerArray;
	}

	//updateDept is a method to Update specific the records from department table
	public CustomerArray updateCustomer(Customer customer){
		CustomerArray customerArray  = new 	CustomerArray();
		System.out.println(customer.getCity()+" customer operation class");
	Session session = SessionClass.getSession();
	session.beginTransaction();
	session.getNamedQuery("updatecustomer").
	setString("customerid",customer.getCustomerid()).
	setString("gender", customer.getGender()).
	setString("firstname", customer.getFirstname()).
	setString("middlename", customer.getMiddlename()).
	setString("lastname", customer.getLastname()).
	setString("email", customer.getEmail()).
	setString("loginname", customer.getLoginname()).
	setString("loginpassword", customer.getLoginpassword()).
	setString("phonenumber", customer.getPhonenumber()).
	setString("add1", customer.getAdd1()).
	setString("add2", customer.getAdd2()).
	setString("add3", customer.getAdd3()).
	setString("add4", customer.getAdd4()).
	setString("city", customer.getCity()).
	setString("state", customer.getState()).
	setString("country", customer.getCountry()).
	setString("zipcode", customer.getZipcode()).executeUpdate();
	try{
	session.getTransaction().commit();
	customerArray.setResult("success");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return customerArray;

	}


	//Selectdept is a method to get the record on id base
	public Object selectCustomer(Customer customer){
	Session session = SessionClass.getSession();

	Object obj=null ;
	try{
	ArrayList list = (ArrayList) session.getNamedQuery("customerselectbyid").setString("customerid", customer.getCustomerid()).list();
	java.util.Iterator i = list.iterator();
	int sizeOfList = list.size();
	while(i.hasNext()){		
		customer = (Customer) i.next();	
	}

	if(sizeOfList>0) 
		obj=customer;
	else 
		obj=new String("failure");


	}
	catch(Exception e){
		e.printStackTrace();
		obj=new String("failure");
	}
	return obj;
	}	

	//SelectAll is a method to get all the records from department table

	public CustomerArray selectAll(){
		
		Session session = SessionClass.getSession();
		Object object=null;
		
			ArrayList list= (ArrayList) session.getNamedQuery("selectallcustomer").list();
			Iterator it = list.iterator();
			System.out.println(list);
			
			Customer[] customer = new Customer[list.size()];
			int i=0;
	while(it.hasNext()){
				
				customer[i]=(Customer) it.next();
	
				
				i++;
			}
			CustomerArray customerArray = new CustomerArray();
			customerArray.setCustomer(customer);
			object = customerArray;
			
		
		return (CustomerArray) object;
	}


	public Object selectCustomerDataByName(Customer customer){
		
		Session session = SessionClass.getSession();

		Object obj=null ;
		try{
	    ArrayList list = (ArrayList) session.getNamedQuery("customerselectbyname").setString("gender", customer.getGender()).list();
		java.util.Iterator i = list.iterator();
		int sizeOfList = list.size();
		while(i.hasNext()){		
			customer = (Customer) i.next();	
		}
	   
		if(sizeOfList>0) 
			obj=customer;
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
