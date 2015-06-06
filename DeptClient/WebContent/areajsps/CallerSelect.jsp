<%@page import="com.table.operations.TableOperationsStub.CallerArray"%>
<%@ page import="java.util.*" %>
<%@page import="javax.management.modelmbean.RequiredModelMBean"%>		
<%@ page import="com.table.operations.TableOperationsStub.Caller"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>

	<body background="areajsps/images/bgnoise_lg.png">
		<%
		CallerArray callerArray =(CallerArray) request.getAttribute("callerArray");
		Caller[] caller = callerArray.getCaller();
		
		
		%>
	 	<form method="post" action="InsertCustomerCallServlet">
	    	<div align="center">
	    		<br><br><br><br>
	        	<table border="2" cellpadding="5" bordercolor="ff00ff">
		        	<input type="hidden" name="hid" id="hid" value="hidden1"/>
		            <caption ><h1>List of seller Address</h1></caption>
		            <%
		            if(caller!=null){
		            %>
		            <tr bgcolor="33ccff"> 	
		             	<th>Caller Id</th>
		                <th>CustomerId</th>
		                <th>CallerSearchInfo</th>
		                <th>CallerSentInfo</th>
		                <th>CallerSentInfoUserId</th>
		            <%
		            int l=5;
		            if(caller.length<5){
		            	l=caller.length;
		            }
					for(int i=0;i<l;i++)
					{
						   %>
					
					<tr bgcolor="ccff33">
						<td><%= caller[i].getCallerId()%></td>
						<td><%= caller[i].getCostomerID()%></td> 
						<td><%= caller[i].getCallerSearchInfo()%></td>
						<td><%= caller[i].getCallerSentInfo()%></td>
						<td><%= caller[i].getSentInfoUserId()%></td>        
				  	</tr>
				  	<% }}
		            else{%>
		            <center><h1>No Data Found For That Customer</h1></center>
		            <%} %>
	            </table>
	            <center><input type="submit" name="next" id="next" value="Next"></center>
	     	</div>
	 	</form>
	 </body>
</html>