<!DOCTYPE html>
<html>
<head>
<title>Coupon</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
			       
		<div  class="form" >
    		<form id="add" action="InsertCoupon.jsp"> 			
				<input class="add" name="add" id="add" value="Add Coupon" type="submit"> 	 	 
			</form> 
			<form id="search" action="SearchCoupon.jsp"> 			
				<input class="search" name="search" id="search" value="Search Coupon" type="submit"> 	 
			</form> 
		</div>      
</div>
<% session.setAttribute("username","rajesh"); %>
<%-- session.setAttribute("username",session.getAttribute("username")); --%>
</body>
</html>
