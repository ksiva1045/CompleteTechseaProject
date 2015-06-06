<!DOCTYPE html>
<html>
<head>
<title>EMP</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" conte
	nt="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
		<div align="right">
<a style="color:purple; font-family: fantasy;font-size: 25px;font-style: normal;font-weight:100;" href="AddOrSearchEmp.jsp">HOME</a>
</div>	       
		<div  class="form" >
    		<form id="add" action="../SelectAllEmpServlet" method="get"> 
    			<input type="hidden" name="hid1" value="1">			
				<input class="add" name="add" id="add" value="SearchAllEmp" type="submit"> 	 	 
			</form> 
			<!-- <form id="search" action="SearchEmp.jsp"> 
				<input type="hidden" name="hid2" value="2">			
				<input class="search" name="search" id="search" value="Search By Name" type="submit"> 	 
			</form>  -->
		</div>  
<%if(request.getParameter("hid1")!=null)
{
	 %>
 <jsp:include page="/SelectAllEmpServlet"></jsp:include>
<%} %>    
</div>
<!--  <% session.setAttribute("username","mohan"); %>-->
<% session.setAttribute("username",session.getAttribute("username")); %>
</body>
</html>
