<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import= "com.table.operations.TableOperationsStub"%>
<%@page import=" com.table.operations.TableOperationsStub.OrderItems"%>
<%@page import=" com.table.operations.TableOperationsStub.OrderItemsArray"%>
<%@page import="com.table.operations.TableOperationsStub.OrderItemsOperations"%>
 <%@page import="com.orderitems.GetDate" %>
<%OrderItems obj=(OrderItems)request.getAttribute("oredritems");%>
<%session.setAttribute("OrderItemId",obj);
String authDate=GetDate.getReqFormat(obj.getMerchantAuthDate());
%>
<form action="UpdateOrderItems" method="post">
<% %>
PRODUCT ID    :<input type="text" name="PRODUCT_ID" value=<%=obj.getProductId() %>><br><br>
ORDER ID	  :<input type="text" name="ORDER_ID" value=<%=obj.getOrderId() %>><br><br>
ORDER ITEM STATUS CODE:<input type="text" name="ORDER_ITEM_STATUS_CODE" value=<%=obj.getOrderItemStatusCode() %>><br><br>
ORDER ITEM QUANTITY:<input type="text" name="ORDER_ITEM_QUANTITY" value=<%=obj.getOrderItemQuantity() %>><br><br>
MERCHANT AUTH DATE:<input type="date" name="MERCHANT_AUTH_DATE" value=<%=authDate %>><br><br>
ORDER ITEM PRICE :<input type="text" name="ORDER_ITEM_PRICE" value=<%=obj.getOrderItemPrice() %>><br><br>
MERCHANT AUTH NBR :<input type="text" name="MERCHANT_AUTH_NBR" value=<%=obj.getMerchantAuthNbr() %>><br><br>
MERCHANT ISSUED BY :<input type="text" name="MERCHANT_ISSUED_BY" value=<%=obj.getMerchantIssuedBy() %>><br><br>
OTHER ORDER ITEM DETAILS :<input type="text" name="OTHER_ORDER_ITEM_DETAILS" value=<%=obj.getOtherOrderItemsDetails() %>><br><br>
SELLER ID :<input type="text" name="SELLER_ID" value=<%=obj.getSellerId() %>><br><br>

<input type="submit" value="Update"><br><br>
</form>
</body>
</html>