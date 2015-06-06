package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Caller;
import com.support.CallerArray;
import com.support.Coupon;
import com.support.CouponArray;
import com.support.Customer;
import com.support.CustomerArray;
import com.support.SessionClass;

public class CallerOperationsClass {

	Caller caller=null;
	CallerArray callerArray=null;
public CallerOperationsClass(Caller caller,CallerArray callerArray){		
		this.caller = caller;
		this.callerArray=callerArray;
		
	}

//insertDept is a method to insert data into department table
	
public CallerArray insertCaller(Caller caller){	
	
	CallerArray callerArray = new CallerArray();
	
	Session session = SessionClass.getSession();
	//System.out.println("session called successfully"+ session);


	session.beginTransaction();
	session.getNamedQuery("insertcaller").
	setString("costomerID", caller.getCostomerID()).
	setString("callerSearchInfo", caller.getCallerSearchInfo()).
	setString("callerSentInfo", caller.getCallerSentInfo()).
	setString("sentInfoUserId", caller.getSentInfoUserId()).
	setString("callDuration", caller.getCallDuration()).
	setString("empId", caller.getEmpId()).executeUpdate();

	try{
		session.getTransaction().commit();
		callerArray.setResult("success");
		System.out.println(callerArray.getResult());
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return callerArray;
}

public CallerArray selectAll(){
	
	Session session = SessionClass.getSession();
	
	
	Object object=null;
	System.out.println("");
		ArrayList list= (ArrayList) session.getNamedQuery("selectallcaller").list();
		Iterator it = list.iterator();
		System.out.println(list);
		
		Caller[] caller = new Caller[list.size()];
		int i=0;
while(it.hasNext()){
			
	caller[i]=(Caller) it.next();

			
			i++;
		}
		CallerArray callerArray = new CallerArray();
		callerArray.setCaller(caller);
		object = callerArray;
	
	return (CallerArray) object;
}


}
