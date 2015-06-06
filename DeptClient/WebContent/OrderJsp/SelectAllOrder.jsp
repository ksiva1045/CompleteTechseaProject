<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="OrderJsp/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/OrderJsp/SearchOrder.jsp");
		
	});
		
});

</script>
<body background="OrderJsp/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.Order"%>
<%@ page import=" com.table.operations.TableOperationsStub.OrderArray" %>

<%
OrderArray orderArray=
(OrderArray)request.getAttribute("orderArray");
Order order[]=orderArray.getOrder();
if(order.length >0)
{
%>
<body bgcolor="33ff99">

 <form  action="DeleteOrder" method="post">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of Order Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
                <th>CutomerId</th>
                <th>OrderStatusCode</th>
              	<th>OrderDetails</th>
              	<th>OrderPlaceDate</th>
               
                            <% 

	
	for(int i=0;i<order.length;i++)
	{
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=order[i].getOrderId()%>" /></td>  
                <!--  <td><a href="SelectCustomerServlet?id=<%=order[i].getOrderId()%>&hidd=get"><%=order[i].getOrderId() %>    -->
                    <td><a href="SelectByIdOrder?id=<%=order[i].getOrderId()%>&hidd=get"><%= order[i].getCustomerId()%></td>
                    <td><%= order[i].getOrderStatusCode()%></td>
                    <td><%= order[i].getOrderDetails()%></td>
                     <td><%= order[i].getOrderPlaceDate()%></td>

                         	
                    </a></td>
                </tr>
                <% 
	
}
            %>
            </div>
            </table>
            <div align="center">
            <br>
                <input type="submit" class="styled-button" value="Delete">&nbsp&nbsp&nbsp&nbsp&nbsp
         
    <input type="button" value="Cancel" id="cancel">
            </div>
            </form>
            </body>
          
         
         <% session.setAttribute("username",session.getAttribute("username")); %>
        
          
            <%
         

}
else{
%>
<br>
<br>
<center><h1> NO RECORDS WERE FOUND </h1></center>

<%} %>

</body>
</html>