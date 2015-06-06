
<%@page import="com.table.operations.TableOperationsStub.OrderArray"%>
<%@page import="com.shipments.GetDate"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<title>Deal</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="dealjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="dealjsps/demo.css" media="all" />
</head>
<body background="dealjsps/images/bgnoise_lg.png">
<%@ page import="com.table.operations.TableOperationsStub.Shipments"%>
<%@ page import="com.table.operations.TableOperationsStub.ShipmentArray"%>
<%@ page import="com.clientsupport.SelectAllData" %>
<%@ page import="com.table.operations.TableOperationsStub.Invoices"%>
<%@ page import="com.table.operations.TableOperationsStub.InvoicesArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Order"%>
<%@ page import="com.table.operations.TableOperationsStub.OrderArray"%>




<%@ page import="com.shipments.GetDate" %>
<div class="container">
			<header>
				<h1> Update Shipment Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Shipments shipments = (Shipments)request.getAttribute("shipmentObj");
            session.setAttribute("shipments", shipments);
            String startDate=GetDate.getReqFormat(shipments.getShipmentDate());
           
            InvoicesArray invoicesArray=SelectAllData.invoiceSellectAll();
            Invoices invoices[]=invoicesArray.getInvoice();
            
            OrderArray orderArray=SelectAllData.orderSellectAll();
            Order orders[]=orderArray.getOrder();
           
               %>
               
               
      <div  class="form" >
    		<form id="contactform" action="UpdateShipment" method="post"> 
    			<p class="contact"><label for="email">orderId</label></p> 
    			<%--<input id="email" name="orderId" placeholder="Enter OrderId" required="" type="text" value="<%=shipments.getOrderId() %>"> --%>                
		
		          <select name="orderId">
  	 			<%  	
    			for(int i=0;i<orders.length;i++)
    			{
    				if(orders[i].getOrderId()==(shipments.getOrderId()))
    				{
    					%>
        				<option value="<%=orders[i].getOrderId() %>" selected="selected"><%=orders[i].getOrderId() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=orders[i].getOrderId() %>"><%=orders[i].getOrderId() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
		        
		       
            	<p class="contact"><label for="phone">invoiceId</label></p> 
            	<%--<input id="phone" name="invoiceId" placeholder="Enter InvoiceId" required="" type="text" value="<%=shipments.getInvoiceId()%>">--%> <br>

                  <select name="invoiceId">
  	 			<%  	
    			for(int i=0;i<invoices.length;i++)
    			{
    				if(invoices[i].getINVOICE_ID().equalsIgnoreCase(shipments.getInvoiceId()))
    				{
    					%>
        				<option value="<%=invoices[i].getINVOICE_ID() %>" selected="selected"><%=invoices[i].getINVOICE_ID() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=invoices[i].getINVOICE_ID() %>"><%=invoices[i].getORDER_ID() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
                 
           
				<p class="contact"><label for="email">shipmentDate</label></p> 
    			 <input id="email" name="shipmentDate" placeholder="Enter Product ID" required="" type="date" value="<%=startDate %>"> 
                <p class="contact"><label for="phone">shipmentDetails</label></p> 
            	<input id="phone" name="shipmentDetails" placeholder="Enter shipmentDetails" required="" type="text" value="<%=shipments.getInvoiceId()%>"> <br>

				<p class="contact"><label for="email">shipmentTrackingNumber</label></p> 
    			 <input id="email" name="shipmentTrackingNumber" placeholder="Enter shipmentTrackingNumber" required="" type="text" value="<%=shipments.getShipmentTrackingNumber()%>"> 
                		
                                
 
            	<input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   			</form> 
   
	</div>

     <%
     /*
         dept.setDeptNo(request.getParameter("deptNo"));
          dept.setDeptNo(request.getParameter("deptName"));
          dept.setDeptNo(request.getParameter("location"));
           dept.setDeptNo(request.getParameter("username"));
           request.setAttribute("reqDeptObj", dept);
       */     
            %>      
</div>

</body>
</html>
