<%@ page import="com.clientsupport.SelectAllData" %>
<%@page import="com.table.operations.TableOperationsStub.Order"%>
<%@page import="com.table.operations.TableOperationsStub.OrderArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller" %>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductBean" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>OrderItems</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Enter Order Item Details to Insert</h1>
            </header> 
             <% 
             	OrderArray orderarray= SelectAllData.orderSellectAll();
            	Order order[]= orderarray.getOrder();
            	
            	SellerArray sellerArray= SelectAllData.sellerSellectAll();
        		Seller sellers[]= sellerArray.getSeller();
        		
        		ProductArray productArray=SelectAllData.productSellectAll();
        		ProductBean[] product=productArray.getProduct();
            %>         
      <div  class="form" >
    		<form id="contactform" method="post" action="../InsertOrderItems">
    		<input type="hidden" name="hid" value="insertDept">
    		 
    			<p class="contact"><label for="name">ProductId </label></p> 
    			<!-- <input id="name" name="productId" placeholder="Enter Product Id " required=""  type="text"> --> 
    			
    			<select name="productId">
  	 			<%
  	 				for(int i=0;i<product.length;i++) {
  	 			%>
    				<option value="<%=product[i].getProductId()%>"><%=product[i].getProductName()%></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			<br/>
    			
    			<p class="contact"><label for="email">OrderItemStatusCode </label></p> 
    			<input id="email" name="orderItemStatusCode" placeholder="Enter OrderItem Status Code " required="" type="text"> 
                
		
          		<p class="contact"><label for="phone">OrderItemQuantity </label></p> 
            	<input id="phone" name="orderItemQuantity" placeholder="Enter OrderItem Quantity " required="" type="text"> <br>

                <p class="contact"><label for="username">OrderItemPrice </label></p> 
    			<input id="username" name="orderItemPrice" placeholder="OrderItemPrice " required=""  type="text"> 
    			
               <p class="contact"><label for="name">MerchantAuthNbr </label></p> 
    			<input id="name" name="merchantAuthNbr" placeholder="Enter Merchant Auth Number  " required=""  type="text"> 
    			 
    			<p class="contact"><label for="email">MerchantIssuedBy </label></p> 
    			<input id="email" name="merchantIssuedBy" placeholder="Enter Merchant Issued By " required="" type="text"> 
                
		
          		<p class="contact"><label for="phone">OtherOrderItemsDetails </label></p> 
            	<input id="phone" name="otherOrderItemsDetails" placeholder="Enter Other Order Items Details " required="" type="text"> <br>

                <p class="contact"><label for="username">SellerId </label></p> 
    			<!-- <input id="username" name="sellerId" placeholder="SellerId " required=""  type="text"> --> 
    			
    			<select class="txtfield" name="sellerId">
    			<%
        			for(int i=0;i<sellers.length;i++){
        		%>
        				<option value="<%=sellers[i].getSid() %>"><%=sellers[i].getSName() %></option>
        			<%} %>
        		</select>
               <br/>
               <p class="contact"><label for="name">MerchantAuthDate  </label></p> 
    			<input id="name" name="merchantAuthDate" placeholder="Enter Merchant Auth Date  " required=""  type="date"> 
    			 
    			<p class="contact"><label for="email">OrderId </label></p> 
    			<%--<input id="email" name="orderId" placeholder="Enter OrderId " required="" type="text"> --%> 
    			<select name="orderId">
  	 			<%
  	 				for(int i=0;i<order.length;i++) {
  	 			%>
    				<option value="<%=order[i].getOrderId() %>"><%=order[i].getOrderStatusCode() %></option>   	  	
    			<%
    				}
    			%>
    			</select>
    			<br/>
                
		
         
                
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form> 
</div>   
<%
String req=(String)request.getAttribute("sucessFlag");
if(req=="success"){
%>
<center>
<h3 style="color: red">Record Sucessfully Inserted</h3>
</center>
<%}%>   
</div>

</body>
</html>
