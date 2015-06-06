package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.ProductCat;
import com.support.ProductCatArray;
import com.support.ProductCatStatic;
import com.support.ProductCatStaticArray;
import com.support.SessionClass;

public class ProductCatStaticOperataonsClass {

	ProductCatStatic proCatStaticObj;
	ProductCatStaticArray proCatStaticArray;
	public ProductCatStaticOperataonsClass(ProductCatStatic proCatStaticObj,ProductCatStaticArray proCatStaticArray){

		this.proCatStaticObj = proCatStaticObj;
		this.proCatStaticArray=proCatStaticArray;
	}
	
	
	public ProductCatStaticArray insertProdCatStatic(ProductCatStatic proCatStatic){
		ProductCatStaticArray prodCatStaticArray = new ProductCatStaticArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("insertproductcatstatic").
		setString("productquality1", proCatStatic.getProductquality1()).
		setString("productquality2", proCatStatic.getProductquality2()).
		setString("productquality3", proCatStatic.getProductquality3()).
		setString("productquality4", proCatStatic.getProductquality4()).
		setString("productquality5", proCatStatic.getProductquality5()).
		setString("productquality6", proCatStatic.getProductquality6()).
		setString("productquality7", proCatStatic.getProductquality7()).
		setString("productquality8", proCatStatic.getProductquality8()).
		setString("productquality9", proCatStatic.getProductquality9()).
		setString("productquality10", proCatStatic.getProductquality10()).
		//setString("productcatid", proCatStatic.getProductcatid()).
		executeUpdate();
		try{
			session.getTransaction().commit();
			prodCatStaticArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return prodCatStaticArray;
	}
	
	public ProductCatStaticArray updateProdCatStatic(ProductCatStatic proCatStatic){
		
		ProductCatStaticArray prodCatStaticArray = new ProductCatStaticArray();
		Session session = SessionClass.getSession();

		session.beginTransaction();		
		session.getNamedQuery("updateproducatcatstatic").
		setString("productquality1", proCatStatic.getProductquality1()).
		setString("productquality2", proCatStatic.getProductquality2()).
		setString("productquality3", proCatStatic.getProductquality3()).
		setString("productquality4", proCatStatic.getProductquality4()).
		setString("productquality5", proCatStatic.getProductquality5()).
		setString("productquality6", proCatStatic.getProductquality6()).
		setString("productquality7", proCatStatic.getProductquality7()).
		setString("productquality8", proCatStatic.getProductquality8()).
		setString("productquality9", proCatStatic.getProductquality9()).
		setString("productquality10", proCatStatic.getProductquality10()).
		setString("productcatid", proCatStatic.getProductcatid()).executeUpdate();
		try{
			session.getTransaction().commit();
			prodCatStaticArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return prodCatStaticArray;
	}
	
	public ProductCatStaticArray deleteProdCatStatic(ProductCatStatic proCatStatic){
	
		ProductCatStaticArray prodCatStaticArray = new ProductCatStaticArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("deleteproductcatstatic").
		setString("productcatid", proCatStatic.getProductcatid()).executeUpdate();
		try{
			session.getTransaction().commit();
			prodCatStaticArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return prodCatStaticArray;
	}
	
	
	public ProductCatStatic selectProdCatStatic(ProductCatStatic proCatStatic){

		Session session = SessionClass.getSession();
		session.beginTransaction();
		Object obj=null ;
		try{
			ArrayList list = (ArrayList) session.getNamedQuery("ProductCatStaticselectbyid").setString("productcatid", proCatStatic.getProductcatid()).list();
			java.util.Iterator i = list.iterator();
			int sizeOfList = list.size();
			while(i.hasNext()){		
				proCatStatic = (ProductCatStatic) i.next();	
			}
   
			if(sizeOfList>0) 
				obj=proCatStatic;
			else 
				obj=new String("failure");
		}
		catch(Exception e){
			e.printStackTrace();
			obj=new String("failure");
		}

		return (ProductCatStatic) obj;
	}	
	
	public ProductCatStaticArray selectAll(){

		Session session = SessionClass.getSession();
		session.beginTransaction();
		ArrayList list= (ArrayList) session.getNamedQuery("ProductCatStaticSelectAll").list();
		Iterator it = list.iterator();
		System.out.println(list);
	
		ProductCatStatic[] proCatStatic = new ProductCatStatic[list.size()];
		int i=0;
		while(it.hasNext()){
		
			proCatStatic[i]=(ProductCatStatic) it.next();
			System.out.println(proCatStatic[i].getProductcategorystatic());
			i++;
		}
		ProductCatStaticArray prodCatStaticArray = new ProductCatStaticArray();
		prodCatStaticArray.setProductcatstatic(proCatStatic);
	
		return prodCatStaticArray;
	
	}
}
