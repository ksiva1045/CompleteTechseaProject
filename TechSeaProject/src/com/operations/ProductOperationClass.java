package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.ProductArray;
import com.support.ProductBean;
import com.support.SessionClass;

public class ProductOperationClass {

	public ProductBean productBean;
	public ProductArray productArray;
	public ProductOperationClass( ProductBean productBean,  ProductArray productArray){
		this.productArray=productArray;
		this.productBean=productBean;
	}
	
	
	
	public ProductArray insertProduct(ProductBean product){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ProductArray pArray = new ProductArray();
		
		
		session.getNamedQuery("insertproduct").
		//setString("pid",product.getProductId()).
		setString("ptcode",product.getProductCode()).
		setString("pname",product.getProductName()).
		setString("pprice",product.getPrice()).
		setString("pscode",product.getServiceCode()).
		setString("prod_cat_id",product.getProuduct_cat_id()).
		setString("cuid",product.getCreatedUserID()).executeUpdate();
		try{
			session.getTransaction().commit();
			pArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return pArray;
	}
	
	
	public ProductArray updateProduct(ProductBean product){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ProductArray pArray = new ProductArray();
		
		int query = session.getNamedQuery("updateproduct").
				setString("pid",product.getProductId()).
				setString("ptcode",product.getProductCode()).
				setString("pname",product.getProductName()).
				setString("pprice",product.getPrice()).
				setString("pscode",product.getServiceCode()).
				setString("prod_cat_id",product.getProuduct_cat_id()).
				setString("lmuid",product.getLastModifiedUserID()).executeUpdate();

				//Transaction tx=(Transaction) session.beginTransaction();
				
		try{
			session.getTransaction().commit();
			pArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return pArray;
	
	}
	
	public ProductArray updateProductTopRating(ProductBean product){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ProductArray pArray = new ProductArray();
		
		int query = session.getNamedQuery("updateproducttoprating").
				setString("pid",product.getProductId()).executeUpdate();			
		try{
			session.getTransaction().commit();
			pArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return pArray;
	
	}
	
	
	public ProductArray deleteProduct(ProductBean product){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		ProductArray pArray = new ProductArray();
		session.beginTransaction();
        session.getNamedQuery("deleteproducts").
        setString("pid", product.getProductId()).executeUpdate();
		try{
			session.getTransaction().commit();
			pArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return pArray;
	
	}
	
	
	
	public Object selectProduct(ProductBean product){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Object obj=null;
		try{
	        ArrayList list = (ArrayList) session.getNamedQuery("productselectbyid").setString("pid", product.getProductId()).list();
			java.util.Iterator i = list.iterator();
			int sizeOfList = list.size();
			
			while(i.hasNext()){		
				product = (ProductBean) i.next();	
			}
	       
			if(sizeOfList>0) 
				obj=product;
			else 
				obj=new String("failure");

			
			}
			catch(Exception e){
				e.printStackTrace();
				obj=new String("failure");
			}
			return obj;
	
	}
	
	
	public ProductArray getProductByWord(ProductBean product){
		Session session = SessionClass.getSession();
		ProductArray productArray=new ProductArray();
		session.beginTransaction();
		Object obj=null;
	        ArrayList list = (ArrayList) session.getNamedQuery("getProductByWord").setString("productname", product.getProductName()).list();			
			Iterator it = list.iterator();
			System.out.println(list);
		
			ProductBean[] productBeans = new ProductBean[list.size()];
			int i=0;
			while(it.hasNext()){			
				productBeans[i]=(ProductBean) it.next();
				//System.out.println(deal[i].getCreatedUserId());			
				i++;
			}
			productArray.setProduct(productBeans);
			return productArray;
	
	}
	
	
	
	
	public ProductArray selectAll(){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		//ProductArray pArray = new ProductArray();
		ArrayList list= (ArrayList) session.getNamedQuery("selectproduct").list();
		Iterator it = list.iterator();
		System.out.println(list);
		
		ProductBean[] products = new ProductBean[list.size()];
		int i=0;
		
		
         while(it.hasNext()){
        	 products[i]=(ProductBean) it.next();
			//System.out.println("incide service service code ; " +products[i].getServiceCode());
			
			i++;
		}
		ProductArray productArray = new ProductArray();
		productArray.setProduct(products);
		
		return productArray;
	
	}
	
}
