<%@ page import="java.util.*" %>
<%@page import="javax.management.modelmbean.RequiredModelMBean"%>		
<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Related Products</title>
	</head>

	<body background="areajsps/images/bgnoise_lg.png">
		<%
		ProductArray productArray =(ProductArray) request.getAttribute("productArray");
		ProductBean[] product=productArray.getProduct();
		%>
	 	<form method="post" action="">
	    	<div align="center">
	    		<br><br><br><br>
	        	<table border="2" cellpadding="5" bordercolor="ff00ff">
		        	<input type="hidden" name="hid" id="hid" value="hidden1"/>
		            <caption ><h1>Related Products</h1></caption>
		            <%
		            if(product!=null){
		            %>
		            <tr bgcolor="33ccff"> 	
		             	<th>ProductName</th>
		                <th>ProductPrice</th>
		            <%
					for(int i=0;i<product.length;i++)
					{
						   %>
					
					<tr bgcolor="ccff33">
						<td><%= product[i].getProductName()%></td>
						<td><%= product[i].getPrice()%></td>     
				  	</tr>
				  	<% }}
		            else{%>
		            <center><h1>No Product Found</h1></center>
		            <%} %>
	            </table>
	            
	     	</div>
	 	</form>
	 </body>
</html>