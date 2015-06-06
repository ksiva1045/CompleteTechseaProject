package com.operations;


	
	
	
	
	import java.util.ArrayList;

import java.util.Iterator;

	import org.hibernate.Session;

import com.support.Deal;
import com.support.DealArray;
import com.support.Dept;
import com.support.DeptArray;
import com.support.SessionClass;

	public class DealOperataonsClass {
		Deal deal=null;
		DealArray dealArray = null;
		public DealOperataonsClass(Deal deal,DealArray dealArray){
			
			this.deal = deal;
			this.dealArray=dealArray;
			
		}

	//insertDept is a method to insert data into department table
		
		
	public DealArray insertDeal(Deal deal){
		DealArray dealArray = new DealArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();

	 session.getNamedQuery("insertdeal").
     setString("dealname", deal.getDealName()).
     setString("dealdetails", deal.getDealDetails()).
     setString("productid", deal.getProductId()).
     setString("sellerid", deal.getSellerId()).
     setString("startdate", deal.getStartDate()).
     setString("enddate", deal.getEndDate()).
     setString("creteduserid", deal.getCreatedUserId()).executeUpdate();
		try{
		session.getTransaction().commit();
		dealArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dealArray;
	}

	
	
	
public DealArray updateDeal(Deal deal){
	DealArray dealArray = new DealArray();
Session session = SessionClass.getSession();
session.beginTransaction();
session.getNamedQuery("updatedeal").
setString("dealid", deal.getDealId()).
setString("dealname", deal.getDealName()).
setString("dealdetails", deal.getDealDetails()).
setString("productid", deal.getProductId()).
setString("sellerid", deal.getSellerId()).
setString("startdate", deal.getStartDate()).
setString("enddate", deal.getEndDate()).
setString("lastmodifieduserid", deal.getLastModifiedUserId()).executeUpdate();
try{
session.getTransaction().commit();
dealArray.setResult("success");
}
catch(Exception e){
	e.printStackTrace();
}
return dealArray;
}
	


public DealArray deleteDeal(Deal deal){
DealArray dealArray = new DealArray();
Session session = SessionClass.getSession();
session.beginTransaction();
session.getNamedQuery("deletedeal").
setString("dealid", deal.getDealId()).executeUpdate();
try{
session.getTransaction().commit();
dealArray.setResult("success");
}
catch(Exception e){
	e.printStackTrace();
}
return dealArray;
}



public Object selectDeal(Deal deal){
DealArray dealArray = new DealArray();
Session session = SessionClass.getSession();
session.beginTransaction();
Object obj=null ;
try{
ArrayList list = (ArrayList) session.getNamedQuery("dealselectbyid").setString("dealid", deal.getDealId()).list();
java.util.Iterator i = list.iterator();
int sizeOfList = list.size();
while(i.hasNext()){		
	deal = (Deal) i.next();	
}

if(sizeOfList>0) 
	obj=deal;
else 
	obj=new String("failure");


}
catch(Exception e){
	e.printStackTrace();
	obj=new String("failure");
}
return obj;
}


public DealArray selectAll(){

Session session = SessionClass.getSession();
session.beginTransaction();
ArrayList list= (ArrayList) session.getNamedQuery("dealselectall").list();
Iterator it = list.iterator();
System.out.println(list);

Deal[] deals = new Deal[list.size()];
int i=0;
while(it.hasNext()){			
	deals[i]=(Deal) it.next();
	//System.out.println(deal[i].getCreatedUserId());			
	i++;
}
DealArray dealArray = new DealArray();
dealArray.setDeal(deals);		
return dealArray;

}
	
	}
	