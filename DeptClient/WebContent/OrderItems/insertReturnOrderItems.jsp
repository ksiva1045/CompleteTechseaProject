<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="OrderItems/images/bgnoise_lg.png">
<%@ page import = "java.util.ResourceBundle" %>
<%

String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
		 ResourceBundle resource = ResourceBundle.getBundle("error");
		String result = resource.getString("successInsert");
%>
<h2 style="color: red">
<center>
 <%=result%>
 </center>
</h2>		
<div align="center">
<form action="SelectAllOrderItems" method="post"> 
<input type="submit" value="CheckNow">
<input type="button" value="Cancel" id="cancel">
</form>
</div>
<%}} %>

<script type="text/javascript" src="OrderItems/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		alert("message");
		window.location.replace("/DeptClient/OrderItems/AddOrSearchOrderItems.jsp");
		
	});
		
});

</script>
</body>
</html>