
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>Payment Details</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
    
    <!-- <script language="javascript" type="text/javascript" src="dealjsps/datetimepicker.js">
</script> -->
</head>
<body>

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Invoices"%>
<%@ page import="com.table.operations.TableOperationsStub.InvoicesArray"%>
<%@ page import="com.clientsupport.SelectAllData" %>
<% session.setAttribute("username",session.getAttribute("username")); %>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Enter Payment Details to Insert</h1>
            </header>     
             <%
               InvoicesArray invoicesArray=SelectAllData.invoiceSellectAll();
               Invoices invoices[]=invoicesArray.getInvoice();
               %>  
      <div  class="form" >
    		<form id="contactform" method="post" action="../PaymentInsert">
    		<input type="hidden" name="hid" value="insertPayent"> 
     			 
    			<p class="contact"><label for="email">Payment Details</label></p> 
    			<input id="email" name="paymentdetails" placeholder="Enter Payment Details" required="" type="text"> 
 
     			<p class="contact"><label for="name">Invoice ID</label></p> 
    			<!--  <input id="name" name="invoiceid" placeholder="Enter Invoice ID" required=""  type="text">   -->             
		 
		 <select name="invoiceid">
  	 			<%
  	 				for(int i=0;i<invoices.length;i++) {
  	 			%>
    				<option value="<%=invoices[i].getINVOICE_ID() %>"><%=invoices[i].getINVOICE_STATUS_CODE() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			
            	<p class="contact"><label for="phone">Payment Status</label></p> 
            <input id="phone" name="paymentstatus" placeholder="Enter Payment Status" required="" type="text"> <br> 


     			<p class="contact"><label for="name">Payment Date</label></p> 
    			<input id="name" name="paymentdate" placeholder="Enter Payment Date" required=""  type="date">                
		
            	<p class="contact"><label for="phone">Payment Amount</label></p> 
            <input id="phone" name="paymentamount" placeholder="Enter Payment Amount" required="" type="text"> <br> 



  			
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
            <input class="buttom" name="submit" id="cancel" tabindex="5" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="paymentsjsps/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		alert("code ok");
		window.location.replace("/DeptClient/paymentsjsps/AddOrSearchPayment.jsp");
		
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






</body>
</html>