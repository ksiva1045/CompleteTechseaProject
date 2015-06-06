
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Dept" %>
<!DOCTYPE html>
<html>
<head>
<title>UpdateCustomerPaymentMethod</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="deptjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="deptjsps/demo.css" media="all" />
</head>
<body>
<%@ page import="com.table.operations.TableOperationsStub.Order" %>

<%@ page import="com.table.operations.TableOperationsStub.CustomerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.Customer" %>
<%@ page import="com.clientsupport.SelectAllData" %>
<%@ page import="com.deal.GetDate" %>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
			<center>
				<h1> Update Order Details Here</h1>
				</center>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
          	
            Order order=(Order)request.getAttribute("order");
            String date=GetDate.getReqFormat(order.getOrderPlaceDate());
            CustomerArray customerArray=SelectAllData.customerSellectAll();
            Customer customer[]=customerArray.getCustomer();
    			
            session.setAttribute("order", order);
            
            
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateOrderServlet" method="post"> 
    				<p class="contact"><label for="email">CustomerId</label></p> 
    			<%-- <input id="email" name="deptName" placeholder="Enter P" required="" type="text" value="<%=paymentmethod.getPaymentMethodCode() %>">--%> 
                 <select name="cid">
  	 			<%  	
    			for(int i=0;i<customer.length;i++)
    			{
    				if(customer[i].getCustomerid().equalsIgnoreCase(order.getCustomerId()))
    				{
    					%>
        				<option value="<%=customer[i].getCustomerid() %>" selected="selected"><%=customer[i].getFirstname() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=customer[i].getCustomerid() %>"><%=customer[i].getFirstname() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
		
            <p class="contact"><label for="phone">OrderStatusCodeCode</label></p> 
            <input id="phone" name="satusCode" placeholder="Enter Method Code" required="" type="text" value="<%=order.getOrderStatusCode()%>"> <br>

              <p class="contact"><label for="phone">OrderDetails<Details1/label></p> 
            <input id="phone" name="details1" placeholder="Enter Detail1" required="" type="text" value="<%=order.getOrderDetails()%>"> <br>
              
              <p class="contact"><label for="phone">OrderPlaceDate<Details1/label></p> 
            <input id="phone" name="placeDate" placeholder="Enter Details2" required="" type="date" value="<%=date%>"> <br>
              
              
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form> 
   
</div>

       
</div>

</body>
</html>
