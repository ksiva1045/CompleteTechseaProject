<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Order</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			       
		<div class="form">
    		<form id="add" action="InsertOrder.jsp"> 			
				<input class="add" name="add" id="add" value="Add Order" type="submit"> 	 	 
			</form> 
			<form id="search" action="SearchOrder.jsp" method="post"> 			
				<input class="search" name="search" id="search" value="Search Order" type="submit"> 	 
			</form> 
		</div>      
</div>


<% session.setAttribute("username",session.getAttribute("username")); %>
</body>
</html>
