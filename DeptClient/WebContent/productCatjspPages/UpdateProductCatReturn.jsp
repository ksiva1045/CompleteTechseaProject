<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="productCatjspPages/images/bgnoise_lg.png">
<%@ page import = "java.util.ResourceBundle" %>
<%

String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
		 ResourceBundle resource = ResourceBundle.getBundle("error");
		String result = resource.getString("successUpdate");
		
%>
<h2 style="color: red">
<center>
 <%=result%>
 </center>
</h2>		
<div align="center">
<form action="SelectAllServlet"> 
<input type="submit" value="CheckNow">
<input type="button" value="Cancel" id="cancel">

</form>
</div>
<%}} %>


<script type="text/javascript" src="productCatjspPages/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/productCatjspPages/AddOrSearch.jsp");
		
	});
		
});

</script>
</body>
</html>