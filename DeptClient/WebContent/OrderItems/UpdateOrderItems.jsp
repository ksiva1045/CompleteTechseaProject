
<%@ page import="com.clientsupport.SelectAllData" %>
<%@page import="com.table.operations.TableOperationsStub.Order"%>
<%@page import="com.table.operations.TableOperationsStub.OrderArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller" %>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductBean" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray" %>
<%@ page import="com.table.operations.TableOperationsStub.OrderItems"%>
<%@ page import="com.table.operations.TableOperationsStub.OrderItemsArray"%>
<%@ page import="com.deal.GetDate" %>
<!DOCTYPE html>
<html>
<head>
<title>OrderItems</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="dealjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="dealjsps/demo.css" media="all" />
</head>
<body background="dealjsps/images/bgnoise_lg.png">

<div class="container">
			<header>
				<h1> Update OrderItems Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            OrderArray orderarray= SelectAllData.orderSellectAll();
        	Order orders[]= orderarray.getOrder();
        	
        	SellerArray sellerArray= SelectAllData.sellerSellectAll();
    		Seller sellers[] = sellerArray.getSeller();
    		
    		ProductArray productArray=SelectAllData.productSellectAll();
    		ProductBean[] product=productArray.getProduct();
            
            OrderItems orderItems = (OrderItems)request.getAttribute("oredritems");
            session.setAttribute("OrderItems", orderItems);
            String authDate=GetDate.getReqFormat(orderItems.getMerchantAuthDate());
            %>
            
       <div  class="form" >
    		<form id="contactform" method="post" action="UpdateOrderItems">
    		<input type="hidden" name="hid" value="insertDept">
    		 
    			<p class="contact"><label for="name">ProductId </label></p> 
    			<%-- <input id="name" name="PRODUCT_ID" placeholder="Enter Product Id " required=""  type="text" value="<%=orderItems.getProductId()%>"> --%> 
    			
    			
    			<select name="PRODUCT_ID">
  	 			<%  	
    			for(int i=0;i<product.length;i++)
    			{
    				if(product[i].getProductId().equalsIgnoreCase(orderItems.getProductId()))
    				{
    					%>
        				<option value="<%=product[i].getProductId()%>" selected="selected"><%=product[i].getProductName()%></option>   	  	

    			<%	}
    				else{
    					%>
		
    				<option value="<%=product[i].getProductId()%>"><%=product[i].getProductName()%></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
    			
    			<p class="contact"><label for="email">OrderItemStatusCode </label></p> 
    			<input id="email" name="ORDER_ITEM_STATUS_CODE" placeholder="Enter OrderItem Status Code " required="" type="text" value="<%=orderItems.getProductId()%>"> 
                
		
          		<p class="contact"><label for="phone">OrderItemQuantity </label></p> 
            	<input id="phone" name="ORDER_ITEM_QUANTITY" placeholder="Enter OrderItem Quantity " required="" type="text" value="<%=orderItems.getProductId()%>"> <br>

                <p class="contact"><label for="username">OrderItemPrice </label></p> 
    			<input id="username" name="ORDER_ITEM_PRICE" placeholder="OrderItemPrice " required=""  type="text" value="<%=orderItems.getProductId()%>"> 
    			
               <p class="contact"><label for="name">MerchantAuthNbr </label></p> 
    			<input id="name" name="MERCHANT_AUTH_NBR" placeholder="Enter Merchant Auth Number  " required=""  type="text" value="<%=orderItems.getProductId()%>"> 
    			 
    			<p class="contact"><label for="email">MerchantIssuedBy </label></p> 
    			<input id="email" name="MERCHANT_ISSUED_BY" placeholder="Enter Merchant Issued By " required="" type="text" value="<%=orderItems.getProductId()%>"> 
                
		
          		<p class="contact"><label for="phone">OtherOrderItemsDetails </label></p> 
            	<input id="phone" name="OTHER_ORDER_ITEM_DETAILS" placeholder="Enter Other Order Items Details " required="" type="text" value="<%=orderItems.getProductId()%>"> <br>

                <p class="contact"><label for="username">SellerId </label></p> 
    			<%--<input id="username" name="SELLER_ID" placeholder="Enter SellerId " required=""  type="text"value="<%=orderItems.getProductId()%>"> --%> 
                 
                <select name="SELLER_ID">
  	 			<%  	
    			for(int i=0;i<sellers.length;i++)
    			{
    				if(sellers[i].getSid().equalsIgnoreCase(orderItems.getSellerId()))
    				{
    					%>
        				<option value="<%=sellers[i].getSid() %>" selected="selected"><%=sellers[i].getSName() %></option>   	  	

    			<%	}
    				else{
    					%>		
    				<option value="<%=sellers[i].getSid() %>"><%=sellers[i].getSName() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
                                    
                <p class="contact"><label for="email">MERCHANT AUTH DATE</label></p> 
    			<input id="email" name="MERCHANT_AUTH_DATE"  required="" type="date" value="<%=authDate %>"> 
    			 
    			<p class="contact"><label for="email">OrderId </label></p> 
    			<%--<input id="email" name="ORDER_ID" placeholder="Enter OrderId " required="" type="text"> --%> 
    			
    			<select name="ORDER_ID">
  	 			<%  	
    			for(int i=0;i<orders.length;i++)
    			{
    				if(orders[i].getOrderId()==orderItems.getOrderId())
    				{
    					%>
        				<option value="<%=orders[i].getOrderId() %>" selected="selected"><%=orders[i].getOrderId() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=orders[i].getOrderId() %>"><%=orders[i].getOrderStatusCode() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>		
               
            	<input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   			</form> 
   
	</div> 
</div>

</body>
</html>
