<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<link rel="stylesheet" type="text/css" media="all" href="searchstyle.css">
<%--<title>dept</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" /> --%>
</head>

<body background="images/bgnoise_lg.png">

<%@ page import="com.table.operations.TableOperationsStub.Dept"%>
<%@ page import="com.table.operations.TableOperationsStub.DeptArray"%>
<% session.setAttribute("username",session.getAttribute("username")); %>

<center>

<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				
            </header>      
            </div>

<script type="text/javascript" src="jquery.js" ></script>
<script type="text/javascript">


</script>







<center>

<form action="../SelectByNameServlet" method="post">
  <select class="txtfield" name="select">
	
	 <% 
DeptArray dArray =(DeptArray) request.getAttribute("deptArray");
Dept[] dept=null;
if(dArray!=null){
 dept = dArray.getDept();


	
	for(int i=0;i<dept.length;i++){
	%>
	<option value="<%=dept[i].getDeptName() %>"><%=dept[i].getDeptName() %></option>
	<%}} %>
	</select>
	<input type="submit">
</form>	






</center>
</div>
</div>
<br>
<br>


</center>           
</body>

</html>