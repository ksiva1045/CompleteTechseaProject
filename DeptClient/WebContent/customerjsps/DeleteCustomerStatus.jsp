<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="customerjsps/images/bgnoise_lg.png">
<%@ page import = "java.util.ResourceBundle" %>
<%


		 ResourceBundle resource = ResourceBundle.getBundle("error");
         String result = resource.getString("successDelete");
	
%>
<h2 style="color: red">
<center>
<%=request.getAttribute("count") %>
 <%=result%>
 </center>
</h2>		
<div align="center">
<form action="SelectAllCustomerServlet"> 
<input type="submit" value="Check Reamianing Records">
<input type="button" value="Cancel" id="cancel">

</form>
</div>



<script type="text/javascript" src="customerjsps/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/customerjsps/Search.jsp");
		
	});
		
});

</script>
</body>
</html>