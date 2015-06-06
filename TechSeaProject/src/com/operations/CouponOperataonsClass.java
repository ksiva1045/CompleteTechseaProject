package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Coupon;
import com.support.CouponArray;

import com.support.SessionClass;

public class CouponOperataonsClass {
	Coupon coupon=null;
	CouponArray couponArray=null;
public CouponOperataonsClass(Coupon coupon,CouponArray couponArray){
	
		
		this.coupon = coupon;
		this.couponArray=couponArray;
		
	}

//insertDept is a method to insert data into department table
	
public CouponArray insertCoupon(Coupon coupon){	
//CouponArray couponArray = new CouponArray();
	
Session session = SessionClass.getSession();
//System.out.println("session called successfully"+ session);
session.beginTransaction();
 session.getNamedQuery("insertcoupon").
 setString("couponName", coupon.getCouponName()).
 setString("couponCode", coupon.getCouponCode()).
 setString("couponDetails", coupon.getCouponDetails()).
 setString("sellerId", coupon.getSellerId()).
 setString("issueDate", coupon.getIssueDate()).
 setString("expireDate", coupon.getExpireDate()).
 setString("createdUserId", coupon.getCreatedUserId()).executeUpdate();
	System.out.println(coupon.getCouponName());

	try{
	session.getTransaction().commit();
	couponArray.setResult("success");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return couponArray;
}




public CouponArray updateCoupon(Coupon coupon){
	
CouponArray couponArray = new CouponArray();
Session session = SessionClass.getSession();
session.beginTransaction();
System.out.println(coupon.getIssueDate());
session.getNamedQuery("updatecoupon").
setString("couponId", coupon.getCouponId()).
setString("couponName", coupon.getCouponName()).
setString("couponCode", coupon.getCouponCode()).
setString("couponDetails", coupon.getCouponDetails()).
setString("sellerId", coupon.getSellerId()).
setString("issueDate", coupon.getIssueDate()).
setString("expireDate", coupon.getExpireDate()).
setString("lastModifiedUserId", coupon.getLastModifiedUserId()).executeUpdate();
try{
session.getTransaction().commit();
couponArray.setResult("success");
}
catch(Exception e){
e.printStackTrace();
}
return couponArray;
}



public CouponArray deleteCoupon(Coupon coupon){
	CouponArray couponArray = new CouponArray();

Session session = SessionClass.getSession();
session.beginTransaction();
session.getNamedQuery("deletecoupon").
setString("couponId", coupon.getCouponId()).executeUpdate();
try{
session.getTransaction().commit();
couponArray.setResult("success");
}
catch(Exception e){
e.printStackTrace();
}
return couponArray;
}



public Object selectCoupon(Coupon coupon){
CouponArray couponArray = new CouponArray();	

Session session = SessionClass.getSession();
session.beginTransaction();
Object obj=null ;
try{
ArrayList list = (ArrayList) session.getNamedQuery("couponselectbyid").setString("couponId", coupon.getCouponId()).list();
java.util.Iterator i = list.iterator();
int sizeOfList = list.size();
while(i.hasNext()){		
	coupon = (Coupon) i.next();	
}

if(sizeOfList>0) 
obj=coupon;
else 
obj=new String("failure");


}
catch(Exception e){
e.printStackTrace();
obj=new String("failure");
}
return obj;
}


public CouponArray selectAll(){

Session session = SessionClass.getSession();
session.beginTransaction();
ArrayList list= (ArrayList) session.getNamedQuery("couponselectall").list();
Iterator it = list.iterator();
System.out.println(list);
Coupon[] coupons = new Coupon[list.size()];
int i=0;
while(it.hasNext()){			
coupons[i]=(Coupon) it.next();
		
i++;
}
CouponArray couponArray = new CouponArray();
couponArray.setCoupon(coupons);
	
return couponArray;

}
}

