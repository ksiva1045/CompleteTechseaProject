package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.SellerProduct;
import com.support.SellerProductArray;
import com.support.SessionClass;

public class SellerProductOperationClass {
	SellerProduct sellerProduct=null;
	SellerProductArray sellerProductArray=null;
public SellerProductOperationClass(SellerProduct sellerProduct,SellerProductArray sellerProductArray){
	
		
		this.sellerProduct = sellerProduct;
		this.sellerProductArray=sellerProductArray;
		
	}

//insertDept is a method to insert data into department table
	
public SellerProductArray insertSellerProduct(SellerProduct sellerProduct){	
//CouponArray couponArray = new CouponArray();
	
Session session = SessionClass.getSession();
//System.out.println("session called successfully"+ session);
session.beginTransaction();
 session.getNamedQuery("insertsellerproduct").
 //setString("SellerProductId", sellerProduct.getPsid()).
 setString("SellerId", sellerProduct.getSid()).
 setString("ProductId", sellerProduct.getPid()).
 setString("SellerProductPrice", sellerProduct.getPsprice()).executeUpdate();
	//System.out.println(coupon.getCouponName());

	try{
	session.getTransaction().commit();
	sellerProductArray.setResult("success");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return sellerProductArray;
}




public SellerProductArray updateSellerProduct(SellerProduct sellerProduct){
	
	SellerProductArray sellerProductArray = new SellerProductArray();
Session session = SessionClass.getSession();
session.beginTransaction();
//System.out.println(coupon.getIssueDate());
session.getNamedQuery("updateSellerProduct").
setString("SellerProductId", sellerProduct.getPsid()).
setString("SellerId", sellerProduct.getSid()).
setString("ProductId", sellerProduct.getPid()).
setString("SellerProductPrice", sellerProduct.getPsprice()).executeUpdate();
try{
session.getTransaction().commit();
sellerProductArray.setResult("success");
}
catch(Exception e){
e.printStackTrace();
}
return sellerProductArray;
}



public SellerProductArray deleteSellerProduct(SellerProduct sellerProduct){
	SellerProductArray sellerProductArray = new SellerProductArray();

Session session = SessionClass.getSession();
session.beginTransaction();
session.getNamedQuery("deletesellerproduct").
setString("SellerProductId", sellerProduct.getPsid()).executeUpdate();
try{
session.getTransaction().commit();
sellerProductArray.setResult("success");
}
catch(Exception e){
e.printStackTrace();
}
return sellerProductArray;
}



public Object selectSellerProduct(SellerProduct sellerProduct){
	SellerProductArray sellerProductArray = new SellerProductArray();	

Session session = SessionClass.getSession();
session.beginTransaction();
Object obj=null ;
try{
ArrayList list = (ArrayList) session.getNamedQuery("SellerProductselectbyid").setString("SellerProductId", sellerProduct.getPsid()).list();
java.util.Iterator i = list.iterator();
int sizeOfList = list.size();
while(i.hasNext()){		
	sellerProduct = (SellerProduct) i.next();	
}

if(sizeOfList>0) 
obj=sellerProduct;
else 
obj=new String("failure");


}
catch(Exception e){
e.printStackTrace();
obj=new String("failure");
}
return obj;
}


public SellerProductArray selectAll(){

Session session = SessionClass.getSession();
session.beginTransaction();
ArrayList list= (ArrayList) session.getNamedQuery("SellerProductselectall").list();
Iterator it = list.iterator();
System.out.println(list);
SellerProduct[] sellerProduct = new SellerProduct[list.size()];
int i=0;
while(it.hasNext()){			
	sellerProduct[i]=(SellerProduct) it.next();
		
i++;
}
SellerProductArray sellerProductArray = new SellerProductArray();
sellerProductArray.setSellerProduct(sellerProduct);
	
return sellerProductArray;

}
}



