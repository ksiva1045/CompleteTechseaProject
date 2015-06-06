<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>Deal</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="dealjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="dealjsps/demo.css" media="all" />
    
    <!-- <script language="javascript" type="text/javascript" src="dealjsps/datetimepicker.js">
</script> -->
</head>
<body>

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%>
<% session.setAttribute("username",session.getAttribute("username")); %>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Enter Deal Details to Insert</h1>
            </header>       
      <div  class="form" >
    		<form id="contactform" method="post" action="InsertDealServlet">
    		<input type="hidden" name="hid" value="insertDeal"> 
     			 
    			<p class="contact"><label for="email">Deal Name</label></p> 
    			<input id="email" name="dealname" placeholder="Enter Deal Name" required="" type="text"> 
 
     			<p class="contact"><label for="name">Deal Details</label></p> 
    			<input id="name" name="dealdetails" placeholder="Enter Details" required=""  type="text">                
		
            	<p class="contact"><label for="phone">Product ID</label></p> 
            	<%--<input id="phone" name="productid" placeholder="Enter Product ID" required="" type="text"> <br> --%>

  				<select class="txtfield" name="productid">
 	 			<% 
 	 				ProductArray productArray =(ProductArray) request.getAttribute("productArray");
					ProductBean[] productBean=null;
					if(productArray!=null){
					productBean = productArray.getProduct();

					for(int i=0;i<productBean.length;i++){
				%>
				<option value="<%=productBean[i].getProductCode() %>"><%=productBean[i].getProductCode() %></option>
				<%}} %>
				</select><br>
				
				
				
				<p class="contact"><label for="phone">Seller ID</label></p> 
            	<%--<input id="phone" name="productid" placeholder="Enter Product ID" required="" type="text"> <br> --%>

  				<select class="txtfield" name="sellerid">
 	 			<% 
 	 				SellerArray sellerArray =(SellerArray) request.getAttribute("sellerArray");
					Seller[] seller=null;
					if(sellerArray!=null){
					seller = sellerArray.getSeller();

					for(int i=0;i<seller.length;i++){
				%>
				<option value="<%=seller[i].getSName() %>"><%=seller[i].getSName() %></option>
				<%}} %>
				</select><br>

				<p class="contact"><label for="email">Start Date</label></p> 
    			<input id="email" name="startdate"  required="" type="date"> 
 
     			<p class="contact"><label for="name">End Date</label></p> 
    			<input id="name" name="enddate"  required=""  type="date"><br>
    			
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
            <input class="buttom" name="submit" id="cancel" tabindex="5" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="dealjsps/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		
		window.location.replace("/DeptClient/dealjsps/AddOrSearchDeal.jsp");
		
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
