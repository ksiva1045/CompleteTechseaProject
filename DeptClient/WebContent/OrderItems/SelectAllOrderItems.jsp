<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="OrderItems/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/OrderItems/SearchOrderItems.jsp");
		
	});
		
});

</script>
<body background="OrderItems/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.OrderItemsArray"%>
<%@ page import="com.table.operations.TableOperationsStub.OrderItems"%>
<%
OrderItemsArray  orderItemsArray =( OrderItemsArray)request.getAttribute("orderItemsArray");
OrderItems orderItems[]=orderItemsArray.getOrderItems();
if(orderItems.length>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteOrderItems" >
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of OrderItems Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
                <th>Order Item Id</th>
                <th>Product ID</th>
                <th>Order Item StatusCode</th>
                <th>Order Item Quantity</th>
                <th>Order Item Price</th>
				<th>Merchant Auth Number</th>
				<th>Merchant Issued By</th>
				<th>Other Order Items Details</th>
				<th>Seller Id</th>
				<th>Merchant Auth Date</th>
				<th>Order Id</th>
            <% 

	
	for(int i=0;i<orderItems.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=orderItems[i].getOrderItemId()%>" /></td>  
                <%--<td><a href="SelectDealServlet?id=<%=deal[i].getDealId()%>&hidd=get"><%=deal[i].getDealId()%> --%>
                    <td><a href="SelectOrderItemsById?ById=<%=orderItems[i].getOrderItemId() %>&hidd=get"><%=orderItems[i].getOrderItemId() %></td>
                    <td><%=orderItems[i].getProductId()%></td>
                    <td><%=orderItems[i].getOrderItemStatusCode()%></td>
					<td><%=orderItems[i].getOrderItemQuantity() %></td>
					<td><%=orderItems[i].getOrderItemPrice() %></td>
					<td><%=orderItems[i].getMerchantAuthNbr() %></td>
					<td><%=orderItems[i].getMerchantIssuedBy() %></td>
					<td><%=orderItems[i].getOtherOrderItemsDetails()%></td>
					<td><%=orderItems[i].getSellerId() %></td>
					<td><%=orderItems[i].getMerchantAuthDate()%></td>
					<td><%=orderItems[i].getOrderId() %>
                   </a></td>
                </tr>
                <% 
	
}
            %>
            </div>
            </table>
            <div align="center">
            <br>
                <input type="submit" class="styled-button" value="Delete" onClick="autoRefresh()">&nbsp&nbsp&nbsp&nbsp&nbsp
         
    <input type="button" value="Cancel" id="cancel">
            </div>
            </form>
            </body>
          
         <% session.setAttribute("toPage","update"); %>
         <% session.setAttribute("username",session.getAttribute("username")); %>
         
            <%
            
            if(request.getParameter("hid")!=null){
            
            %>
         <!-- 
           	<script type="text/javascript">
			$(document).ready(function(){
				
				if($('#hid').val()=="hidden1"){
					$('#hid').val(null);
					//window.location.replace("/DeptClient/SelectAllDeptServlet");
					
				}
					
			});

            </script>
               -->
    
       <!-- 
            <script type="text/javascript">
		$(document).ready(function(){
				
				if($('#hid').val()=="hidden1"){
					//alert("hai");
					//window.location.replace("http://www.google.com");
					
					window.location.replace("/DeptClient/SelectAllDeptServlet");
					
				}
			
             			
			});
		</script>
		 -->
		<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/OrderItems/AddOrSearchOrderItems.jsp");
		
	});
		
});

</script>
          
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