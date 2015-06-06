<!DOCTYPE html>
<html>
<head>
<title>SellerProduct</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" conte
	nt="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="SearchDeal.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div align="right" style="margin-top: 20px;margin-right: 40px;">

<a style="color:purple; font-family: fantasy;font-size: 25px;font-style: normal;font-weight:100;" href="AddOrSearchDeal.jsp">HOME</a>

</div>	       
		<div  class="form" >
    		<form id="add" action="../SelectAllProductSellerServlet"> 
    			<input type="hidden" name="hid1" value="1">			
				<input class="add" name="add" id="add" value="SearchAll" type="submit"> 	 	 
			</form> 
			<!-- <form id="search" action="SearchDeal.jsp"> 
				<input type="hidden" name="hid2" value="2">			
				<input class="search" name="search" id="search" value="Search By Name" type="submit"> 	 
			</form>  -->
		</div>  
<%if(request.getParameter("hid1")!=null)
{
	 %>
 <jsp:include page="/SelectAllProductSellerServlet"></jsp:include>
<%} %>    
</div>

<% session.setAttribute("username",session.getAttribute("username")); %>
</body>
</html>
