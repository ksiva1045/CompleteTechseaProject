<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="sellerjsps/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/ClientProductSelectID");
		
	});
		
});

</script>
<body background="sellerjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>

<%

session.setAttribute("product", session.getAttribute("product"));
Seller[] seller =(Seller[]) request.getAttribute("sellerAll");
if(seller.length>0){
%>
<body bgcolor="33ff99">
<% session.setAttribute("username",session.getAttribute("username")); %>

 <form method="post" action="DeleteSellerServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of seller Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
             <th>SellerName</th>
            <% 

	
	for(int i=0;i<seller.length;i++){
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=seller[i].getSid()%>" /></td>  
                    <td><%= seller[i].getSName()%></td>

                    </a></td>
                </tr>
                <% 
	
}
            %>
            </div>
            </table>
            <div align="center">
            <br>
                <!-- <input type="submit" class="styled-button" value="Delete" onClick="autoRefresh()"> -->&nbsp&nbsp&nbsp&nbsp&nbsp
         
    <input type="button" value="Cancel" id="cancel">
            </div>
            </form>
            </body>
          
         
          
            <%
            
            if(request.getParameter("hid")!=null){
            
            %>
  
            <%
            
            
            }
           

}
else{
%>
<br>
<br>
<center><h1> NO RECORDS WERE FOUND </h1></center>

<%} %>





</body>
</html>