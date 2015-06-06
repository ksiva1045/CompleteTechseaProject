package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.ProductCatStatic;
import com.support.ProductSpecification;
import com.support.ProductSpecificationArray;
import com.support.SessionClass;

public class ProductSpecificationOperationClass {


	ProductSpecification productSpecificationobj;
	ProductSpecificationArray productSpecificationArray;
	public ProductSpecificationOperationClass(ProductSpecification productSpecification,ProductSpecificationArray productSpecificationArray){
	    this.productSpecificationobj = productSpecificationobj;
        this.productSpecificationArray = productSpecificationArray;
	
	}
	

	public Object insertProductSpecification(ProductSpecification productSpecific) {
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		
		
		Session session = SessionClass.getSession();
		session.beginTransaction();

		session.getNamedQuery("insertproductSpecification").
		setString("product_typecode", productSpecific.getProduct_typecode()).
		setString("product_colour", productSpecific.getProduct_colour()).
		setString("product_size", productSpecific.getProduct_size()).
		setString("product_features", productSpecific.getProduct_features()).
		
		setString("productquality4", productSpecific.getProduct_quality4()).
		setString("productquality5", productSpecific.getProduct_quality5()).
		setString("productquality6", productSpecific.getProduct_quality6()).
		
		setString("productquality7", productSpecific.getProduct_quality7()).
		setString("productquality8", productSpecific.getProduct_quality8()).
		setString("productquality9", productSpecific.getProduct_quality9()).
		setString("productquality10", productSpecific.getProduct_quality10()).
		//setString("product_id", productSpecific.getProduct_id())
		executeUpdate();
		try{
			session.getTransaction().commit();
			productSpecificationArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    return productSpecificationArray;
			
	}

	public Object productSpecificationselectAll() {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ArrayList list= (ArrayList) session.getNamedQuery("ProductspecificationSelectAll").list();
		Iterator it = list.iterator();
		System.out.println(list);
		ProductSpecification[] productSpecification=new ProductSpecification[list.size()];

		int i=0;
		while(it.hasNext()){
		
			productSpecification[i]=(ProductSpecification) it.next();
			System.out.println(productSpecification[i].getProduct_spec_id());
			i++;
		}
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		productSpecificationArray.setProductSpecification(productSpecification);
	
		return productSpecificationArray;
	
	}
		
		
	

	public Object updateProductSpection(ProductSpecification productSpecific) {
		
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("updateproductspecification").
		setString("product_typecode", productSpecific.getProduct_typecode()).
		setString("product_colour", productSpecific.getProduct_colour()).
		setString("product_size", productSpecific.getProduct_size()).
		setString("product_features", productSpecific.getProduct_features()).
		
		setString("productquality4", productSpecific.getProduct_quality4()).
		setString("productquality5", productSpecific.getProduct_quality5()).
		setString("productquality6", productSpecific.getProduct_quality6()).
		
		setString("productquality7", productSpecific.getProduct_quality7()).
		setString("productquality8", productSpecific.getProduct_quality8()).
		setString("productquality9", productSpecific.getProduct_quality9()).
		setString("productquality10", productSpecific.getProduct_quality10()).
		setString("product_id", productSpecific.getProduct_id()).executeUpdate();
		try{
			session.getTransaction().commit();
			productSpecificationArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return productSpecificationArray;
	}

	public Object deleteProductSpecification(ProductSpecification productSpecific) {
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("deleteproductspecification").
		setString("product_id", productSpecific.getProduct_id()).executeUpdate();
		try{
			session.getTransaction().commit();
			productSpecificationArray.setResult("success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return productSpecificationArray;
	}

	public Object selectProductSpecification(ProductSpecification productSpecific) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Object obj=null ;
		try{
			ArrayList list = (ArrayList) session.getNamedQuery("Productspecificationselectbyid").setString("product_id", productSpecific.getProduct_id()).list();
			java.util.Iterator i = list.iterator();
			int sizeOfList = list.size();
			while(i.hasNext()){		
				productSpecific = (ProductSpecification) i.next();	
			}
   
			if(sizeOfList>0) 
				obj=productSpecific;
			else 
				obj=new String("failure");
		}
		catch(Exception e){
			e.printStackTrace();
			obj=new String("failure");
		}

		return (ProductSpecification) obj;
	}
}