package com.shipments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.table.operations.TableOperationsStub;
import com.table.operations.TableOperationsStub.ShipmentArray;
import com.table.operations.TableOperationsStub.Shipments;
import com.table.operations.TableOperationsStub.ShipmentsOperations;

/**
 * Servlet implementation class SelectByIdShipments
 */
public class SelectByIdShipments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username",session.getAttribute("username")); 
		session.setAttribute("toPage",session.getAttribute("toPage"));
		
		TableOperationsStub tableStub=new TableOperationsStub();
		ShipmentsOperations shipmentOperations=new ShipmentsOperations();
		ShipmentArray shipmentArray=new ShipmentArray();
		Shipments shipments=new Shipments();
		shipmentArray.setOperationName(Operations.SELECTBYID);
		System.out.println("id is:"+request.getParameter("id"));
		shipments.setShipmentId(request.getParameter("id"));
		shipmentOperations.setShipments(shipments);
		shipmentOperations.setShipmentsArray(shipmentArray);

		Object obj= tableStub.shipmentsOperations(shipmentOperations).get_return();
		System.out.println(obj);
		
		
		if(obj instanceof String){
			System.out.println("string"+obj);
		}
		else if(obj instanceof Shipments){
			shipments = (Shipments)obj;			
		}
		
		request.setAttribute("shipmentObj", shipments);
		RequestDispatcher reqDis = request.getRequestDispatcher("/shipmentjsps/UpdateShipment.jsp");
		reqDis.forward(request, response);
	
	}

}
