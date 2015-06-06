<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>Order</title>
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
				<h1> Enter Order Details to Insert</h1>
				</center>
            </header>       
      <div  class="form" >
    		<form id="customerform" method="post" action="../insertOrder">
    		<input type="hidden" name="hid" value="insertOrder"> 
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
    			
    			
    			
    			<p class="contact"><label for="email">OrderStatusCode</label></p> 
    			<input id="statusCode" name="statusCode" placeholder="Enter Status code" required="" type="text"> </br> 
                
		
    			
    			
            <p class="contact"><label for="phone">OrderDetails</label></p> 
            <input id="orderdetail" name="orderdetail" placeholder="Enter OrderDetails" required="" type="text"> <br>

				
            <p class="contact"><label for="phone">OrderPlaceDate</label></p> 
            <input id="placeDate" name="placeDate" placeholder="Enter Place Date" required="" type="date"> <br>
			
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


$(document).ready(function()
		{
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/OrderJsp/AddOrSearchOrder.jsp");
		
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
