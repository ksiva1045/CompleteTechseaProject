<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>CustomerPaymentMethod</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<%@ page import="com.table.operations.TableOperationsStub.CustomerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.Customer" %>
<%@ page import="com.clientsupport.SelectAllData" %>

<%
CustomerArray customerArray=SelectAllData.customerSellectAll();
Customer customer[]=customerArray.getCustomer();
%>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
			<center>
				<h1> Enter CustomerPaymentMethod Details to Insert</h1>
				</center>
            </header>       
      <div  class="form" >
    		<form id="customerform" method="post" action="../insertCustomerPaymentMethod">
    		<input type="hidden" name="hid" value="insertDept"> 
    		<%--	<p class="contact"><label for="name">Deparment Number</label></p> 
    			<input id="name" name="deptNo" placeholder="Enter Deparment number" required=""  type="text"> --%> 
    			 
    			<p class="contact"><label for="email">CustomerID</label></p> 
    			<%--<input id="customeId" name="customeId" placeholder="Enter CustomerID" required="" type="text"></br>--%>
    			
    			 <select name="cid">
  	 			<%  	
    			for(int i=0;i<customer.length;i++)
    			{
    			%>
    				<option value="<%=customer[i].getCustomerid() %>"><%=customer[i].getFirstname() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			
    			
    			<p class="contact"><label for="email">PaymentMethodCode</label></p> 
    			<input id="paymentCode" name="paymentCode" placeholder="Enter Payment Method code" required="" type="text"> </br> 
                
		
    			
    			
            <p class="contact"><label for="phone">PaymentMethodDetails1</label></p> 
            <input id="details1" name="details1" placeholder="Enter Details" required="" type="text"> <br>

				
            <p class="contact"><label for="phone">PaymentMethodDetails2</label></p> 
            <input id="details2" name="details2" placeholder="Enter Details" required="" type="text"> <br>
			
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
		window.location.replace("/DeptClient/CustomerJsp/AddOrSearchCustomerPayments.jsp");
		
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
<%}
	}%>
 -->   
</div>
</body>
</html>
