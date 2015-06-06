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
 * Servlet implementation class DeleteShipmentRecords
 */
public class DeleteShipmentRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShipmentRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ar[] = request.getParameterValues("checkval");
		int count=0;
		if(ar.length>0){
			for(int i=0;i<ar.length;i++){
				System.out.println(ar[i]);
				String value= ar[i];
		
				TableOperationsStub tableStub=new TableOperationsStub();
				ShipmentsOperations shipmentoperations = new ShipmentsOperations();
				ShipmentArray shipmentArray=new ShipmentArray();
				Shipments shipments=new Shipments();

				shipmentArray.setOperationName(Operations.DELETE);
				shipments.setShipmentId(value);

				shipmentoperations.setShipments(shipments);
				shipmentoperations.setShipmentsArray(shipmentArray);
		
				
		tableStub.shipmentsOperations(shipmentoperations).get_return();
				count++;
			}
		}

		
		else{    	
        	out.print("<center style='color:red'>");
        	out.print("<h2>");
        	out.print("No Records were selected to delete");
        	out.print("</h2>");
        	out.print("</center>");
        	
        	
        }
	if(count>0){
		System.out.println(count);

		request.setAttribute("count", count);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/shipmentjsps/deleteStatus.jsp");
		reqDispatcher.forward(request, response);
		
	}
	

}

		
	}


