<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="CustomerJsp/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/CustomerJsp/searchCustomerPaymentMethod.jsp");
		
	});
		
});

</script>
<body background="CustomerJsp/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import ="com.table.operations.TableOperationsStub.CustomerPaymentMethodArray"%>
<%@ page import=" com.table.operations.TableOperationsStub.CustomerPaymentMethod" %>

<%
CustomerPaymentMethodArray paymentMethodArray=
(CustomerPaymentMethodArray)request.getAttribute("paymentMethodArray");
CustomerPaymentMethod customerPaymentMethod[]=paymentMethodArray.getCustomerPaymentMethod();
if(customerPaymentMethod.length >0)
{
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteCustomerPaymentMethodServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of CustomerPaymentMethod Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
                <th>PaymentMethodCode</th>
                <th>PaymentMethodDetails1</th>
              	<th>PaymentMethodDetails2</th>
               
                            <% 

	
	for(int i=0;i<customerPaymentMethod.length;i++)
	{
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=customerPaymentMethod[i].getCustomerPaymentId()%>" /></td>  
                <!--  <td><a href="SelectCustomerServlet?id=<%=customerPaymentMethod[i].getCustomerPaymentId()%>&hidd=get"><%=customerPaymentMethod[i].getCustomerPaymentId() %>    -->
                    <td><a href="SelectCustomerPaymentServlet?id=<%=customerPaymentMethod[i].getCustomerPaymentId()%>&hidd=get"><%= customerPaymentMethod[i].getPaymentMethodCode()%></td>
                    <td><%= customerPaymentMethod[i].getPaymentMethodDetails1()%></td>
                    <td><%= customerPaymentMethod[i].getPaymentMethodDetails2()%></td>
                   	
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
         
           

		
		<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/CustomerJsp/searchCustomerPaymentMethod.jsp");
		
	});
		
});

</script>
          
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