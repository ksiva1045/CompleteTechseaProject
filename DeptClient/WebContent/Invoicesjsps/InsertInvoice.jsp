<%@ page import="com.clientsupport.SelectAllData" %>
<%@page import="com.table.operations.TableOperationsStub.Order"%>
<%@page import="com.table.operations.TableOperationsStub.OrderArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>dept</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Enter Invoices Details to Insert</h1>
            </header>  
            <% OrderArray orderarray= SelectAllData.orderSellectAll();
            Order order[]= orderarray.getOrder();
            %>     
      <div  class="form" >
    		<form id="contactform" method="post" action="../InvoicesInsertServlet">
    		<input type="hidden" name="hid" value="insertDept"> 
    		<%--	<p class="contact"><label for="name">Deparment Number</label></p> 
    			<input id="name" name="deptNo" placeholder="Enter Deparment number" required=""  type="text"> --%> 
    			 
    			 
		
            <p class="contact"><label for="phone">ORDER_ID</label></p> 
            <!-- <input id="phone" name="ORDER_ID" placeholder="ORDER_ID" required="" type="text"> <br>  -->
            <select name="ORDER_ID">
  	 			<%
  	 				for(int i=0;i<order.length;i++) {
  	 			%>
    				<option value="<%=order[i].getOrderId() %>"><%=order[i].getOrderStatusCode() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			

			<p class="contact"><label for="email">INVOICE_STATUS_CODE</label></p> 
    			<input id="email" name="INVOICE_STATUS_CODE" placeholder="INVOICE_STATUS_CODE" required="" type="text"> 
            <p class="contact"><label for="phone">INVOICE_DATE</label></p> 
            <input id="phone" name="INVOICE_DATE" placeholder="INVOICE_DATE" required="" type="date"> <br>
             <p class="contact"><label for="phone">INVOICE_DETAILS</label></p> 
            <input id="phone" name="INVOICE_DETAILS" placeholder="INVOICE_DETAILS" required="" type="text"> <br>


      <!--           <p class="contact"><label for="username">Create a username</label></p> 
    			<input id="username" name="username" placeholder="username" required=""  type="text"> 
            -->    
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
            <input class="buttom" name="submit" id="cancel" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/Invoicesjsps/AddOrSearch.jsp");
		
	});
		
});

</script>

<!-- 
<%
String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
%>
<center>
<h2 style="color: red;font: 50">Record Sucessfully Inserted</h2>
</center>
<%}}%>
 -->   
</div>
</body>
</html>
