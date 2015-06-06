<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.clientsupport.*" %>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.Seller" %>

<!DOCTYPE html>
<html>
<head>
<title>coupon</title>
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
				<h1> Enter Coupon Details to Insert</h1>
            </header>       
      <div  class="form" >
    		<form id="contactform" method="post" action="../InsertCouponServlet">
    		<input type="hidden" name="hid" value="InsertCoupon"> 
     			 
    			<p class="contact"><label for="email">Coupon Name</label></p> 
    			<input id="email" name="couponName" placeholder="Enter Coupon Name" required="" type="text"> 
 				
 				<p class="contact"><label for="name">Coupon code</label></p> 
    			<input id="name" name="couponCode" placeholder="Enter Coupon code" required=""  type="text">                
     			
     			<p class="contact"><label for="name">Coupon Details</label></p> 
    			<input id="name" name="couponDetails" placeholder="Enter Coupon Details" required=""  type="text">                
		
            	

                <p class="contact"><label for="username">Seller ID</label></p> 
    			<select class="txtfield" name="sellerId">
    			<%
    			SellerArray sellerArray= SelectAllData.sellerSellectAll();
                		Seller sellers[] =null;
                		if(sellerArray!=null){
        					sellers = sellerArray.getSeller();

        					for(int i=0;i<sellers.length;i++){
        				%>
        				<option value="<%=sellers[i].getSid() %>"><%=sellers[i].getSName() %></option>
        				<%}} %>
        				</select><br>

    			
    			
    			
    			
    			
    					<p class="contact"><label for="phone">issue Date</label></p> 
            	
            	<input type="date"  class="issueDate"   placeholder="Enter issue Date" min="2014-09-08" name="issueDate" >
            	<br>

                <p class="contact"><label for="username">EXpiry Date</label></p> 
                <input type="date"  class="expireDate"   placeholder="Enter EXpiry Date" min="2014-09-08" name="expireDate" ><br>
                
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
            <input class="buttom" name="submit" id="cancel" tabindex="5" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		
		window.location.replace("/DeptClient/Couponjsps/AddOrSearchCoupon.jsp");
		
	});
		
});

</script>

<!-- 
<%
String obj =(String) request.getAttribute("successFlag");
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
