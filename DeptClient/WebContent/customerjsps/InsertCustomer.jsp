<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>customer</title>
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
				<h1> Enter Customer Details to Insert</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" method="post" action="../InsertCustomerServlet">
    		<input type="hidden" name="hid" value="InsertCustomer"> 
    			<!-- <p class="contact"><label for="name">CustomerID</label></p> 
    			<input id="name" name="customerid" placeholder="Enter CustomerID" required=""  type="text"> -->
    			 
    			<p class="contact"><label for="email">Gender</label></p> 
    			<input id="email" name="gender" placeholder="Enter Gender" required="" type="text"> 
    			
    			<p class="contact"><label for="email">Firstname</label></p> 
    			<input id="email" name="firstname" placeholder="Enter Firstname" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Middlename</label></p> 
    			<input id="email" name="middlename" placeholder="Enter Middlename" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Lastname</label></p> 
    			<input id="email" name="lastname" placeholder="Enter Lastname" required="" type="text"> 
    			
    			 <p class="contact"><label for="email">EmailAddress</label></p> 
    			<input id="email" name="email" placeholder="Enter EmailAddress" required="" type="text"> 
                
                
                 <p class="contact"><label for="email">Loginname</label></p> 
    			<input id="email" name="loginname" placeholder="Enter Loginname" required="" type="text"> 
                
                
                 <p class="contact"><label for="email">LoginPassword</label></p> 
    			<input id="email" name="loginpassword" placeholder="Enter LoginPassword" required="" type="text"> 
                
                
                
                <p class="contact"><label for="email">PhoneNumber</label></p> 
    			<input id="email" name="phonenumber" placeholder="Enter PhoneNumber" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Address1</label></p> 
    			<input id="email" name="add1" placeholder="Enter Address1" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Address2</label></p> 
    			<input id="email" name="add2" placeholder="Enter Address2" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Address3</label></p> 
    			<input id="email" name="add3" placeholder="Enter Address3" required="" type="text"> 
                
                <p class="contact"><label for="email">Address4</label></p> 
    			<input id="email" name="add4" placeholder="Enter Address4" required="" type="text"> 
                
                
                <p class="contact"><label for="email">City</label></p> 
    			<input id="email" name="city" placeholder="Enter City" required="" type="text"> 
                
                
                <p class="contact"><label for="email">State</label></p> 
    			<input id="email" name="state" placeholder="Enter State" required="" type="text"> 
                
                
                <p class="contact"><label for="email">Country</label></p> 
    			<input id="email" name="country" placeholder="Enter Country" required="" type="text"> 
                
                
		
            <p class="contact"><label for="phone">ZipCode</label></p> 
            <input id="phone" name="zipcode" placeholder="Enter ZipCode" required="" type="text"> <br>

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
		window.location.replace("/DeptClient/customerjsps/AddOrSearch.jsp");
		
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
