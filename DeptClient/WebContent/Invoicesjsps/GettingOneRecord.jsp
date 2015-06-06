
<%@page import="com.table.operations.TableOperationsStub.Order"%>
<%@page import="com.clientsupport.SelectAllData"%>
<%@page import="com.table.operations.TableOperationsStub.OrderArray"%>
<%@page import="com.table.operations.TableOperationsStub.InvoicesArray"%>
<%@page import="com.table.operations.TableOperationsStub.Invoices"%>
<%@page import="com.deal.GetDate"%>
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Deal" %>
<!DOCTYPE html>
<html>
<head>
<title>Deal</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="dealjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="dealjsps/demo.css" media="all" />
</head>
<body background="dealjsps/images/bgnoise_lg.png">

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%>
<%@ page import="com.deal.GetDate" %>
<div class="container">
			<header>
				<h1> Update Invoices Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Invoices invoices = (Invoices)request.getAttribute("invoiceID");
            session.setAttribute("invoices1", invoices);
            
            String startDate=GetDate.getReqFormat(invoices.getINVOICE_DATE());
            OrderArray orderarray=SelectAllData.orderSellectAll();
            Order order[]=orderarray.getOrder();
            
            %>
      <div  class="form" >
    		<form id="contactform" action="InvoiceUpdateServlet" method="get"> 
    			<p class="contact"><label for="email">ORDER_ID</label></p> 
    			<%-- <input id="email" name="ORDER_ID" placeholder="ORDER_ID" required="" type="text" value="<%=invoices.getORDER_ID() %>"> --%>    
    			<select name="ORDER_ID">
  	 			<%  	
    			for(int i=0;i<order.length;i++)
    			{
    				if(order[i].getOrderId()==(invoices.getORDER_ID()))
    				{
    					%>
        				<option value="<%=order[i].getOrderId() %>" selected="selected"><%=order[i].getOrderId() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=order[i].getOrderId() %>"><%=order[i].getOrderDetails() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>            
		
            	<p class="contact"><label for="phone">INVOICE_STATUS_CODE</label></p> 
            	<input id="phone" name="INVOICE_STATUS_CODE" placeholder="INVOICE_STATUS_CODE" required="" type="text" value="<%=invoices.getINVOICE_STATUS_CODE()%>"> <br>

				<p class="contact"><label for="email">INVOICE_DATE</label></p> 
				<input id="phone" name="INVOICE_DATE" placeholder="INVOICE_DATE" required="" type="date" value="<%=startDate%>"> <br>
				
				<p class="contact"><label for="phone">INVOICE_DETAILS</label></p> 
            	<input id="phone" name="INVOICE_DETAILS" placeholder="INVOICE_DETAILS" required="" type="text" value="<%=invoices.getINVOICE_DETAILS()%>"> <br>
    			<%-- <!-- <input id="email" name="productId" placeholder="Enter Product ID" required="" type="text" value="<%=deal.getProductId() %>"> --> --%> 
                		
                		<input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
   </div>

</body>
</html>
