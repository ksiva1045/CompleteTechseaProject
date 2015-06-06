<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%--<%@page import="com.table.operations.TableOperationsStub.ProductCatStatic"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCat"%>--%>
<%@ page import="com.table.operations.TableOperationsStub.ShipmentArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Invoices"%>
<%@ page import="com.table.operations.TableOperationsStub.InvoicesArray"%>
<%@ page import="com.clientsupport.SelectAllData" %>
<%@ page import="com.table.operations.TableOperationsStub.Order"%>
<%@ page import="com.table.operations.TableOperationsStub.OrderArray"%>


<!DOCTYPE html>
<html>
	<head>
<script type="text/javascript" src="Validations.js">
</script>


<%-- ProductCatStatic prod =  (ProductCatStatic)request.getAttribute("productCatStatic");
if(prod!=null){
	
	System.out.println(prod.getProductquality1());
	System.out.println(prod.getProductquality2());
	System.out.println(prod.getProductquality3());
	
}
--%>

		<title>Shipments</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
		<link rel="stylesheet" type="text/css" href="shipmentjsps/style.css" media="all" />
		<link rel="stylesheet" type="text/css" href="shipmentjsps/demo.css" media="all" />
		<link rel="stylesheet" type="text/css" href="style.css" media="all" />
		<link rel="stylesheet" type="text/css" href="demo.css" media="all" />		    
	</head>
<body>
<div class="container">
             <%-- 
             ProductCatStatic productCatStatic=(ProductCatStatic)request.getAttribute("productCatStatic"); 
             --%>    
			<header>			
				<h1> Enter Shipments Details to Insert</h1>
            </header> 
            
                <%
               OrderArray orderArray=SelectAllData.orderSellectAll();
               Order orders[]=orderArray.getOrder();
               
               InvoicesArray invoicesArray=SelectAllData.invoiceSellectAll();
               Invoices invoices[]=invoicesArray.getInvoice();
               %>
               
      <div  class="form">
    		<form id="contactform" method="get" action="../InsertShipment">
    		<input type="hidden" name="hid" value="insertshipments"> 
    		<%--	<p class="contact"><label for="name">Depar ment Number</label></p> 
    			<input id="name" name="deptNo" placeholder="Enter Deparment number" required=""  type="text"> 
    			 
    			 <p class="contact"><label for="email">ShipmentId</label></p> 
    			<input id="email" name="ShipmentId" placeholder="Enter ProductTypeCode" required="" type="text"> --%>
         
    			<p class="contact"><label for="email">orderId</label></p> 
    			<%--<input id="email" name="orderId" placeholder="Enter orderId" required="" type="text"> --%>
         
                <select name="orderId">
  	 			<%
  	 				for(int i=0;i<orders.length;i++) {
  	 			%>
    				<option value="<%=orders[i].getOrderId() %>"><%=orders[i].getOrderDetails() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			
         
                
	            <p class="contact"><label for="phone">invoiceId</label></p> 
               <%-- <input id="phone" name="invoiceId" placeholder="Enter ProductName" required="" type="text" >  --%>
               
               <select name="invoiceId">
  	 			<%
  	 				for(int i=0;i<invoices.length;i++) {
  	 			%>
    				<option value="<%=invoices[i].getINVOICE_ID() %>"><%=invoices[i].getINVOICE_STATUS_CODE() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			
    			
               
               
               <br>
			
			
				
                <p class="contact"><label for="phone">shipmentDate</label></p> 
                <input id="phone" name="shipmentDate" placeholder="Enter shipmentDate" required="" type="date"  > <br>
              <span style="color:red;" id="error1" > </span>
              
                <p class="contact"><label for="phone">shipmentDetails</label></p> 
                <input id="phone" name="shipmentDetails" placeholder="Enter shipmentDetails" required="" type="text"> <br>
			
                
                <p class="contact"><label for="phone">shipmentTrackingNumber</label></p> 
                <input id="phone" name="shipmentTrackingNumber" placeholder="Enter shipmentTrackingNumber" required="" type="text"> <br>
              
             <%--  <select class="txtfield" id="prod_cat_id" name="prod_cat_id" onchange="changelables()"  onfocusout="isNumber(this,2)">
               		
               		 
               
              <% 

                		
               ShipmentArray shipmentArray =(ShipmentArray) request.getAttribute("productCatArray");
                		ShipmentArray[] productCat=null;
					if(ShipmentArray!=null){
						productCat = ShipmentArray.get();%>
					
					<option value="-" selected="selected">-</option>	
					<% for(int i=0;i<productCat.length;i++){
					%>
					<option value="<%=productCat[i].getId()%>"><%=productCat[i].getPname() %></option>
			
					<% }} %>
					</select>
					<span style="color:red;" id="error2"> </span>
				</p>
--%> 
		
                
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit" >
            <input class="buttom" name="cancel" id="cancel" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>

<script type="text/javascript" src="shipmentjsps/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#cancel').click(function(){
		alert("hI");
		window.location.replace("/shipmentjsps/AddOrSearch.jsp");
		
	});
		
});
</script>

<!-- 
<%
String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
%>

<%}}%>
 -->   
</div>
</body>
</html>
