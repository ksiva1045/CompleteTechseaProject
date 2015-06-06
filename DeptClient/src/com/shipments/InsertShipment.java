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
 * Servlet implementation class InsertShipment
 */
public class InsertShipment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flag = "false";
		String staticFlag = "false";
		response.setContentType("text/html");
		
		TableOperationsStub table = new TableOperationsStub();
		HttpSession session = request.getSession(false);
		
		
	try
	{
		//products
		//Shipments shipments=(Shipments)session.getAttribute("product");
		Shipments shipments=new Shipments();
		ShipmentArray shipmentArray=new ShipmentArray();
		
		ShipmentsOperations shipmentoperations = new ShipmentsOperations();	
		
		shipmentArray.setOperationName(Operations.INSERT);
		//shipments.setShipmentId(request.getParameter("ShipmentId"));
		//System.out.println(request.getParameter("ShipmentId"));
		
		shipments.setOrderId(Integer.parseInt(request.getParameter("orderId")));
		shipments.setInvoiceId(request.getParameter("invoiceId"));
		//shipments.setShipmentDate(GetDate.getDate(request.getParameter("shipmentDate")));
		shipments.setShipmentDate(GetDate.getDate(request.getParameter("shipmentDate")));
		shipments.setShipmentDetails(request.getParameter("shipmentDetails"));
		shipments.setShipmentTrackingNumber(request.getParameter("shipmentTrackingNumber"));
		
		shipmentoperations.setShipments(shipments);
		shipmentoperations.setShipmentsArray(shipmentArray);
		
	    //productSpecification
		/*ProductSpecificationOperations productSpecificationOperations = new ProductSpecificationOperations();
		ProductSpecification productSpecification = new ProductSpecification();
		ProductSpecificationArray productSpecificationArray = new ProductSpecificationArray();
		
		productSpecification.setProduct_typecode(request.getParameter("product_typecode"));
		productSpecification.setProduct_colour(request.getParameter("product_colour"));
		productSpecification.setProduct_size(request.getParameter("product_size"));
		productSpecification.setProduct_features(request.getParameter("product_features"));
		productSpecification.setProduct_quality4(request.getParameter("productquality4"));
 
		productSpecification.setProduct_quality5(request.getParameter("productquality5"));
		productSpecification.setProduct_quality6(request.getParameter("productquality6"));
		productSpecification.setProduct_quality7(request.getParameter("productquality7"));
		productSpecification.setProduct_quality8(request.getParameter("productquality8"));
		productSpecification.setProduct_quality9(request.getParameter("productquality9"));
		productSpecification.setProduct_quality10(request.getParameter("productquality10"));
		
		productSpecificationArray.setOperationName(Operations.INSERT);
	    productSpecificationOperations.setProductSpecificObj(productSpecification);	    
	    productSpecificationOperations.setProductSpecificationArray(productSpecificationArray);*/

		
		shipmentArray=(ShipmentArray) table.shipmentsOperations(shipmentoperations).get_return();
		flag=shipmentArray.getResult();

		System.out.println("inside insert servlet flag "+flag);
        //productSpecificationArray = (ProductSpecificationArray) table.productSpecificationOperations(productSpecificationOperations).get_return();
		//staticFlag=productSpecificationArray.getResult();
	}
	catch(Exception e){
		e.printStackTrace();
	}

	
	request.setAttribute("sucessFlag",flag);
	
	RequestDispatcher reqDis =  request.getRequestDispatcher("shipmentjsps/insertReturn.jsp");
	reqDis.forward(request, response);

	}
	

}
