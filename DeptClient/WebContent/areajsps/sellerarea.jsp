<%@page import="com.table.operations.TableOperationsStub.SellerArray"%>
<%@ page import="java.util.*" %>
<%@page import="javax.management.modelmbean.RequiredModelMBean"%>		
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>

	<body background="areajsps/images/bgnoise_lg.png">
		<%
		SellerArray sellerArray =(SellerArray) request.getAttribute("sellerArray1");
		Seller[] seller = sellerArray.getSeller();
		
		session.setAttribute("username",session.getAttribute("username"));
		session.setAttribute("callerMobileNo", session.getAttribute("callerMobileNo"));
		session.setAttribute("productId", session.getAttribute("productId"));
		
		Date date=new Date();
		long endTime = date.getTime();
		session.setAttribute("endTime",endTime); 
		session.setAttribute("startTime",session.getAttribute("startTime"));
		%>
	 	<form method="post" action="InsertCustomerCallServlet">
	    	<div align="center">
	    		<br><br><br><br>
	        	<table border="2" cellpadding="5" bordercolor="ff00ff">
		        	<input type="hidden" name="hid" id="hid" value="hidden1"/>
		            <caption ><h1>List of seller Address</h1></caption>
		            <%
		            if(seller!=null){
		            %>
		            <tr bgcolor="33ccff"> 	
		             	<th>SellerName</th>
		                <th>SellerAddress</th>
		                <th>SellerId</th>
		            <%
					for(int i=0;i<seller.length;i++)
					{
						   %>
					
					<tr bgcolor="ccff33">
						<td><%= seller[i].getSName()%></td>
						<td><%= seller[i].getSellerAddress()%></td> 
						<td><%= seller[i].getSid()%></td>        
				  	</tr>
				  	<% }}
		            else{%>
		            <center><h1>No Product Found</h1></center>
		            <%} %>
	            </table>
	            <center><input type="submit" name="next" id="next" value="Next"></center>
	     	</div>
	 	</form>
	 </body>
</html>