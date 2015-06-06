<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Caller</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="demo.css" media="all" /> 
	</head>

	<body>
		`<div class="container">	
			<header>
				<h1>Enter Caller Mobile Number</h1>
            </header>
            
            <%
            Date date=new Date();
			long startTime = date.getTime();
			session.setAttribute("startTime",startTime); 
			%>      
      		<div  class="form" >
    			<form id="contactform" method="post" action="../ProductCatIDProductIDSevlet" name="form1">
    			
    				<p class="contact"><label for="email">Mobile Number</label></p>
					<input id="callerMobileNo" name="callerMobileNo" placeholder="Enter Mobile Number" type="text">

					<input class="buttom" name="searchProducts" id="searchProducts" value="SearchProducts" type="submit">  	 							
				</form>
			</div>
		</div>
		<% session.setAttribute("username","rajesh"); %>
		<%-- session.setAttribute("username",session.getAttribute("username")); --%>
	</body>
</html>
