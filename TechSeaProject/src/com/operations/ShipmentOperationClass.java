package com.operations;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.support.SessionClass;
import com.support.ShipmentArray;
import com.support.Shipments;

public class ShipmentOperationClass {
	public Shipments shipment;
	public ShipmentArray shipmentArray;
	
	public ShipmentOperationClass(Shipments shipment,ShipmentArray shipmentArray){
		this.shipment=shipment;
		this.shipmentArray=shipmentArray;
	}
	
	
	//operations performed
	
	public ShipmentArray insertShipments(Shipments sp){
		ShipmentArray ssArray = new ShipmentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
			 
			 //insert
			 session.getNamedQuery("insertShipments").
			 //setString("SHIPMENT_ID",sp.getShipmentId()).
	         setInteger("ORDER_ID",sp.getOrderId()).
			 setString("INVOICE_ID",sp.getInvoiceId()).
			 setString("SHIPMENT_DATE",sp.getShipmentDate()).
			 setString("SHIPMENT_DETAILS",sp.getShipmentDetails()).
			 setString("SHIPMENT_TRACKING_NUMBER",sp.getShipmentTrackingNumber()).executeUpdate();
			 session.getTransaction().commit(); 
			 ssArray.setResult("success");
			 System.out.println("successfully saved");  
			 return ssArray;
			  }
	
	//update
	public ShipmentArray updateShipments(Shipments sp){
		ShipmentArray ssArray = new ShipmentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
		
			//update
			 session.getNamedQuery("updateShipments").
			 setString("SHIPMENT_ID",sp.getShipmentId()).
	         setInteger("ORDER_ID",sp.getOrderId()).
			 setString("INVOICE_ID",sp.getInvoiceId()).
			 setString("SHIPMENT_DATE",sp.getShipmentDate()).
			 setString("SHIPMENT_DETAILS",sp.getShipmentDetails()).
			 setString("SHIPMENT_TRACKING_NUMBER",sp.getShipmentTrackingNumber()).executeUpdate();
			 session.getTransaction().commit();
			 ssArray.setResult("success");
			  System.out.println("successfully update");
			  return ssArray;
			 
		}

	//delete
	public ShipmentArray deleteShipments(Shipments sp){
		ShipmentArray ssArray = new ShipmentArray();
	Session session = SessionClass.getSession();
	session.beginTransaction();
			
			 session.getNamedQuery("deleteShipments").
			 setString("SHIPMENT_ID",sp.getShipmentId()).executeUpdate();
			 session.getTransaction().commit();
			 ssArray.setResult("success");
			 System.out.println("successfully delete");
			 return ssArray;
			 
		}
		
	//selectbyid
	public Object selectbyIdShipments(Shipments sp){
		Session session = SessionClass.getSession();
	     Object obj=null;
			
	     try{
			ArrayList list=(ArrayList)session.getNamedQuery("selectbyIdShipments").setString("SHIPMENT_ID", sp.getShipmentId()).list();
			java.util.Iterator i = list.iterator();
			int sizeOfList = list.size();
			while(i.hasNext()){		
				sp = (Shipments) i.next();
				System.out.println(sp.getOrderId());
				System.out.println(sp.getInvoiceId());
				System.out.println(sp.getShipmentDetails());
				System.out.println(sp.getShipmentTrackingNumber());
				System.out.println(sp.getShipmentDate());
				}
			if(sizeOfList>0) 
				obj=sp;
			else 
				obj=new String("failure");
			

			}
			catch(Exception e){
				e.printStackTrace();
				obj=new String("failure");
			}
			return obj;
			}	
	


public ShipmentArray selectAllShipments(){

Session session = SessionClass.getSession();
session.beginTransaction();
ArrayList list= (ArrayList) session.getNamedQuery("selectAllShipments").list();
Iterator it = list.iterator();
System.out.println(list);

Shipments[] shipment = new Shipments[list.size()];
int i=0;
while(it.hasNext()){			
	shipment[i]=(Shipments) it.next();
	//System.out.println(deal[i].getCreatedUserId());			
	i++;
}
ShipmentArray shipmentArray = new ShipmentArray();
shipmentArray.setShipment(shipment);		
return shipmentArray;

}


}
