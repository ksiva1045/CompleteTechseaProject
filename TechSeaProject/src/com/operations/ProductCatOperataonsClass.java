package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Dept;
import com.support.DeptArray;
import com.support.ProductCat;
import com.support.ProductCatArray;
import com.support.SessionClass;

public class ProductCatOperataonsClass {
	
	
	ProductCat proCatObj;
	ProductCatArray proCatArray;
	public ProductCatOperataonsClass(ProductCat proCatObj,ProductCatArray proCatArray){
		
		this.proCatObj = proCatObj;
		this.proCatArray=proCatArray;
		
	}
	
	
	public ProductCatArray insertProdCat(ProductCat productCat){
		ProductCatArray prodCatArray = new ProductCatArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
	 session.getNamedQuery("insertproductcat").
     // setString("id", productCat.getId()).
      setString("pname", productCat.getPname()).
      setString("pdetails", productCat.getPdetails()).
      setString("product_parent_id", productCat.getProd_parent_id()).
      setString("cuid", productCat.getCuid())
      .executeUpdate();
	 try{
			session.getTransaction().commit();
			prodCatArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return prodCatArray;
		}
	
	
	
	public ProductCatArray updateProdCat(ProductCat productCat){
		ProductCatArray prodCatArray = new ProductCatArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
	System.out.println("Inside Service  : "+productCat.getProd_parent_id());
	 session.getNamedQuery("updateProducatCat").
     setString("id", productCat.getId()).
     setString("pname", productCat.getPname()).
     setString("pdetails", productCat.getPdetails()).
     setString("prod_parent_id", productCat.getProd_parent_id()).
     setString("lmuid", productCat.getLmuid()).executeUpdate();
	 try{
			session.getTransaction().commit();
			prodCatArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return prodCatArray;
		}
	
	public ProductCatArray deleteProdCat(ProductCat productCat){
		ProductCatArray prodCatArray = new ProductCatArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
	 session.getNamedQuery("deleteProductCat").
     setString("id", productCat.getId()).executeUpdate();
	 try{
			session.getTransaction().commit();
			prodCatArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return prodCatArray;
		}
	
	
	
	public ProductCat selectProdCat(ProductCat productCat){

		Session session = SessionClass.getSession();
	session.beginTransaction();
	Object obj=null ;
	try{
    ArrayList list = (ArrayList) session.getNamedQuery("ProductCatselectbyid").setString("id", productCat.getId()).list();
	java.util.Iterator i = list.iterator();
	int sizeOfList = list.size();
	while(i.hasNext()){		
		productCat = (ProductCat) i.next();	
	}
   
	if(sizeOfList>0) 
		obj=productCat;
	else 
		obj=new String("failure");
	}
	catch(Exception e){
		e.printStackTrace();
		obj=new String("failure");
	}

	return (ProductCat) obj;
}	
	
	
	
	
	public ProductCatArray selectProdCatParent(ProductCat productCat){

		Session session = SessionClass.getSession();
		session.beginTransaction();
		Object obj=null ;
		
		System.out.println("inside servide productcatid "+productCat.getId());
		ArrayList list = (ArrayList) session.getNamedQuery("selectByParentId").setString("id", productCat.getId()).list();
		Iterator it = list.iterator();
		System.out.println(list);
		ProductCat[] productCats = new ProductCat[list.size()];
		int i=0;
	    while(it.hasNext()){
	    	productCats[i]=(ProductCat) it.next();
			System.out.println(productCats[i].getId());
			i++;				
		}
		ProductCatArray productCatArray = new ProductCatArray();
		productCatArray.setProductCat(productCats);
		
		return productCatArray;

	}
	
	
	
	public ProductCatArray selectAll(){

		Session session = SessionClass.getSession();
	session.beginTransaction();
	ArrayList list= (ArrayList) session.getNamedQuery("SelectAll").list();
	Iterator it = list.iterator();
	System.out.println(list);
	
	ProductCat[] productCats = new ProductCat[list.size()];
	int i=0;
while(it.hasNext()){
		
productCats[i]=(ProductCat) it.next();
		System.out.println(productCats[i].getId());
		
		i++;
	}
ProductCatArray productCatArray = new ProductCatArray();
productCatArray.setProductCat(productCats);
	
	return productCatArray;
	
}
	
}
