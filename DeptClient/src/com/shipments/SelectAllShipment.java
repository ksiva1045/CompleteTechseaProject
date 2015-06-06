package com.shipments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ShipmentArray;
import com.table.operations.TableOperationsStub.Shipments;
import com.table.operations.TableOperationsStub.ShipmentsOperations;

/**
 * Servlet implementation class SelectAllShipment
 */
public class SelectAllShipment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String flag="";
		try{	
			TableOperationsStub tableStub=new TableOperationsStub();
			ShipmentsOperations shipmentlOperations=new ShipmentsOperations();
			Shipments shipments=new Shipments();
			ShipmentArray shipmentArray=new ShipmentArray();
			//Deal deal=new Deal();
			String id = request.getParameter("id");
			Shipments[] shipments1=new Shipments[1];
			if(id==null){
				System.out.println("inside if");
				shipmentArray.setOperationName(Operations.SELECTALL);
				shipmentlOperations.setShipments(shipments);
				shipmentlOperations.setShipmentsArray(shipmentArray);
				System.out.println(shipmentArray);
				//shipmentArray=(ShipmentArray)tableStub.shipmentsOperations(shipmentlOperations).get_return();
			
				shipmentArray=(ShipmentArray) tableStub.shipmentsOperations(shipmentlOperations).get_return();
				System.out.println(shipmentArray);
				shipments1=shipmentArray.getShipment();
				System.out.println(shipments1);
				System.out.println(shipments1.length);
			}
			
						
			else{
				
				Shipments shipmentsObj = new Shipments();
				shipmentsObj.setShipmentId(id);
				shipmentArray.setOperationName(Operations.SELECTBYID);
				shipmentlOperations.setShipments(shipmentsObj);
				shipmentlOperations.setShipmentsArray(shipmentArray);
		Object obj=tableStub.shipmentsOperations(shipmentlOperations).get_return();

		
				if(obj instanceof String){
					flag = (String) obj;
				}
				else if(obj instanceof Shipments){
					shipments1[0] = (Shipments)obj;			
				}
			}
			
			if(!flag.equals("failure")){
				request.setAttribute("shipmentAll", shipments1);
				RequestDispatcher reqDisp = request.getRequestDispatcher("shipmentjsps/SelectAll.jsp");
				reqDisp.include(request, response);
			}
			else
			{		
				out.print("<center style='color:red'>");
				out.print("<h2>");
				out.print("No Records were selected to delete");
				out.print("</h2>");
				out.print("</center>");
			}
		}
		catch(Exception e){
			out.print("<center style='color:red'>");
			e.printStackTrace();
	    	out.print("<h2>");
	    	out.print("No Record is found to Display");
	    	out.print("</h2>");
	    	out.print("</center>");
			
		}
	}


}
