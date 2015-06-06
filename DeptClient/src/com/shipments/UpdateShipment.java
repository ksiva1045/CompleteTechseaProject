package com.shipments;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateShipment
 */
public class UpdateShipment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShipment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		TableOperationsStub tableStub=new TableOperationsStub();
		PrintWriter out = response.getWriter();
		
		ShipmentsOperations shipmentOperations=new ShipmentsOperations();
		ShipmentArray shipmentArray=new ShipmentArray();
		Shipments shipments=new Shipments();
		
		shipmentArray.setOperationName(Operations.UPDATE);
		HttpSession session = request.getSession(false);
		Shipments shipments1= (Shipments) session.getAttribute("shipments");
		
		System.out.println("shipment"+request.getParameter("orderId"));
		
		shipments.setShipmentId(shipments1.getShipmentId());
		
		System.out.println(shipments1.getShipmentId());
		shipments.setOrderId(Integer.parseInt(request.getParameter("orderId")));

		shipments.setInvoiceId(request.getParameter("invoiceId"));
		
		shipments.setShipmentDate(GetDate.getDate(request.getParameter("shipmentDate")));
		
		shipments.setShipmentDetails(request.getParameter("shipmentDetails"));
		shipments.setShipmentTrackingNumber(request.getParameter("shipmentTrackingNumber"));
		
		//shipments.setStartDate(GetDate.getDate(request.getParameter("startdate")));
		//shipments.setEndDate(GetDate.getDate(request.getParameter("enddate")));
		//shipments.setLastModifiedUserId((String)session.getAttribute("username"));
		shipmentOperations.setShipments(shipments);
		shipmentOperations.setShipmentsArray(shipmentArray);
		
		shipmentArray=(ShipmentArray) tableStub.shipmentsOperations(shipmentOperations).get_return();
		String flag=shipmentArray.getResult();
		
		request.setAttribute("sucessFlag",flag);
		
		RequestDispatcher reqDis =  request.getRequestDispatcher("shipmentjsps/UpdateReturn.jsp");
		reqDis.forward(request, response);

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
