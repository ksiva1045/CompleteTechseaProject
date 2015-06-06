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
				<h1> Admin Login</h1>
            </header>       
           
      <div  class="form">
    		<form id="contactform" action="../AuthenticationServlet" method="post"> 
    			
                <p class="contact"><label for="username">UserName</label></p> 
    			<input id="username" name="username" placeholder="username" required="required"  type="text"> 
    			
    			<p class="contact"><label for="name">Password</label></p> 
    			<input id="name" name="password" placeholder="password" required="required"  type="password"> 
    		
    			
               
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form> 

</div>   

    <%System.out.print(request.getAttribute("error"));
    
    if(request.getAttribute("error")!=null){
System.out.print(request.getAttribute("error"));
%>
		<h2 align="center" style="color: red;">Either UserName Or Password is wrong</h2>
<%}
   
    

	%>
	 
</div>

</body>
</html>
