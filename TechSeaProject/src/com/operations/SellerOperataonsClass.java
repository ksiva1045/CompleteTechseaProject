package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.Dept;
import com.support.DeptArray;
import com.support.Seller;
import com.support.SellerArray;
import com.support.SessionClass;

public class SellerOperataonsClass {


	SellerArray sellerArray;
	Seller sellerObj;
		public SellerOperataonsClass(Seller sellerObj,SellerArray sellerArray){
			
			this.sellerObj =sellerObj;
			this.sellerArray=sellerArray;
			
		}	
		
		
		public SellerArray insertSeller(Seller seller){
			SellerArray sellerArray = new SellerArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("insertseller").
	       // setString("sid", seller.getSid()).			
	        setString("sName", seller.getsName()).
	        setString("sellerAddress", seller.getSellerAddress()).
	        setString("sellerType", seller.getSellerType()).
	        setString("sPincode", seller.getsPincode()).
	        setString("sellerEmpContactNo", seller.getSellerEmpContactNo()).
	        setString("sMarketingNo", seller.getsMarketingNo()).
	        setString("sManagerNo", seller.getsManagerNo()).
	        setString("sMarketingMailId", seller.getsMarketingMailId()).
	        setString("sBusinessMailId", seller.getsBusinessMailId()).
	        setString("bestTimeToContact", seller.getBestTimeToContact()).
	        setString("contactFrequency", seller.getContactFrequency()).
	        setString("sellerCatId", seller.getSellerCatId()).
	        setString("cuid", seller.getCreatedUserId()).executeUpdate();

		try{
			session.getTransaction().commit();
			sellerArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return sellerArray;
		}
		
		
		
		public SellerArray updateSeller(Seller seller){
			SellerArray sellerArray = new SellerArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("updateseller").
		setString("sid", seller.getSid()).
		setString("sName", seller.getsName()).
        setString("sellerAddress", seller.getSellerAddress()).
        setString("sellerType", seller.getSellerType()).
        setString("sPincode", seller.getsPincode()).
        setString("sellerEmpContactNo", seller.getSellerEmpContactNo()).
        setString("sMarketingNo", seller.getsMarketingNo()).
        setString("sManagerNo", seller.getsManagerNo()).
        setString("sMarketingMailId", seller.getsMarketingMailId()).
        setString("sBusinessMailId", seller.getsBusinessMailId()).
        setString("bestTimeToContact", seller.getBestTimeToContact()).
        setString("contactFrequency", seller.getContactFrequency()).
        setString("sellerCatId", seller.getSellerCatId()).
        setString("lastmodifieduserid", seller.getLastModifiedUserId()).executeUpdate();
        try{
			session.getTransaction().commit();
			sellerArray.setResult("success");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return sellerArray;
		}
		
		
		public SellerArray deleteSeller(Seller seller){
			SellerArray sellerArray = new SellerArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.getNamedQuery("deleteseller").
        setString("sid", seller.getSid()).executeUpdate();
		  try{
				session.getTransaction().commit();
				sellerArray.setResult("success");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return sellerArray;
			}
		
		
		public Seller selectSeller(Seller seller){
			SellerArray sellerArray = new SellerArray();
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Object obj=null ;
		try{
        ArrayList list = (ArrayList) session.getNamedQuery("sellerselectbyid").setString("sid", seller.getSid()).list();
		java.util.Iterator i = list.iterator();
		int sizeOfList = list.size();
		while(i.hasNext()){		
			seller = (Seller) i.next();	
		}
       
		if(sizeOfList>0) 
			obj=seller;
		else 
			obj=new String("failure");

		
		}
		catch(Exception e){
			e.printStackTrace();
			obj=new String("failure");
		}
		return (Seller) obj;
	}	
		
		
		public SellerArray selectAll(){

			Session session = SessionClass.getSession();
		session.beginTransaction();
		
		ArrayList list= (ArrayList) session.getNamedQuery("sellerSel").list();
		Iterator it = list.iterator();
		System.out.println(list);
		
		Seller[] sellers = new Seller[list.size()];
		int i=0;
while(it.hasNext()){
			
	sellers[i]=(Seller) it.next();
			System.out.println(sellers[i].getCreatedUserId());
			
			i++;
		}
		SellerArray sellerArray = new SellerArray();
		sellerArray.setSeller(sellers);
		
		return sellerArray;
		
	}

		
		
		
}
		
	

