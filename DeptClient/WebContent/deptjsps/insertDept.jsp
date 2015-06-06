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
				<h1> Enter Department Details to Insert</h1>
            </header>       
      <div  class="form" >
    		<form id="contactform" method="post" action="../InsertDeptServlet">
    		<input type="hidden" name="hid" value="insertDept"> 
    		<%--	<p class="contact"><label for="name">Deparment Number</label></p> 
    			<input id="name" name="deptNo" placeholder="Enter Deparment number" required=""  type="text"> --%> 
    			 
    			<p class="contact"><label for="email">Department Name</label></p> 
    			<input id="email" name="deptName" placeholder="Enter department name" required="" type="text"> 
                
		
            <p class="contact"><label for="phone">Location</label></p> 
            <input id="phone" name="location" placeholder="Enter Location" required="" type="text"> <br>

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
		window.location.replace("/DeptClient/deptjsps/AddOrSearch.jsp");
		
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
