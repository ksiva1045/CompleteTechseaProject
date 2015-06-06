<html>
<head>
<title>Employee</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>

<div class="container">
	<!--/ freshdesignweb top bar -->
			       
		<div  class="form" >
    		<form id="add" action="InsertEmp.jsp" method="get"> 			
				<input class="add" name="add" id="add" value="Add Employee" type="submit"> 	 	 
			</form> 
			<form id="search" action="SearchEmp.jsp"> 			
				<input class="search" name="search" id="search" value= "Search Employee" type="submit"> 	 
			</form> 
		</div>      
</div>
<% session.setAttribute("username","rajesh");%>
<%-- session.setAttribute("username",session.getAttribute("username"));--%>
</body>
</html>


