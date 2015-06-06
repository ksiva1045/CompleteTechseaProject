
<%@page import="com.deal.GetDate"%>
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Deal" %>
<!DOCTYPE html>
<html>
<head>
<title>Payment  </title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="paymentsjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="paymentsjsps/demo.css" media="all" />
</head>
<body background="paymentsjsps/images/bgnoise_lg.png">

<%@ page import="com.table.operations.TableOperationsStub.Payment"%>
<%@ page import="com.table.operations.TableOperationsStub.PaymentArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%>
<%@ page import="com.deal.GetDate" %>
<%@ page import="com.table.operations.TableOperationsStub.Invoices"%>
<%@ page import="com.table.operations.TableOperationsStub.InvoicesArray"%>
<%@ page import="com.clientsupport.SelectAllData" %>
<%@ page  %>
<div class="container">
			<header>
				<h1> Update Payment Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Payment payment = (Payment)request.getAttribute("paymentObj");
            String date=GetDate.getReqFormat(payment.getPAYMENT_DATE());

            session.setAttribute("payment", payment);
            InvoicesArray invoicesArray=SelectAllData.invoiceSellectAll();
            Invoices invoices[]=invoicesArray.getInvoice();
           
            %>
      <div  class="form" >
       
                 
    		<form id="contactform" action="PaymentUpdate" method="post"> 
    	<%--		<p class="contact"><label for="email">Payment Id</label></p> 
    			<input id="email" name="paymentid" placeholder="Enter payment Id" required="" type="text" value="<%=payment.getPAYMENT_ID() %>">   --%>              
		
            	<p class="contact"><label for="phone">Payment Details </label></p> 
            	<input id="phone" name="paymentdetails" placeholder="Enter Payment Details" required="" type="text" value="<%=payment.getPAYMENT_DETAILS()%>"> <br>
               
               <p class="contact"><label for="phone">Invoice ID </label></p> 
            <!--  	<input id="phone" name="invoiceid" placeholder="Enter Invoice ID" required="" type="text" value="<%=payment.getINVOICE_ID()%>"> --><br>
                  
                   <select name="invoiceid">
  	 			<%  	
    			for(int i=0;i<invoices.length;i++)
    			{
    				if(invoices[i].getINVOICE_ID().equalsIgnoreCase(payment.getINVOICE_ID()))
    				{
    					%>
        				<option value="<%=invoices[i].getINVOICE_ID() %>" selected="selected"><%=invoices[i].getINVOICE_ID() %></option>   	  	

    			<%	}
    				else{
    					%>
    				
    			
    				<option value="<%=invoices[i].getINVOICE_ID() %>"><%=invoices[i].getORDER_ID() %></option>   	  	
    			<%
    				}
    			}
    			%>
    			</select>
               
               
               
               <p class="contact"><label for="phone">Payment Status </label></p> 
            	<input id="phone" name="paymentstatus" placeholder="Enter Payment Status" required="" type="text" value="<%=payment.getPAYMENT_STATUS()%>"> <br>
               
				<p class="contact"><label for="email">Payment Date</label></p> 
				<input id="phone" name="paymentdate" placeholder="Enter Payment Date" required="" type="date" value="<%=date%>"> <br>
				
				<p class="contact"><label for="email">Payment Amount</label></p> 
				<input id="phone" name="paymentamount" placeholder="Enter Payment Amount" required="" type="text" value="<%=payment.getPAYMENT_AMOUNT()%>"> <br>
				
				
    			<!-- <input id="email" name="productId" placeholder="Enter Product ID" required="" type="text" value="<%=payment.getPAYMENT_ID() %>"> --> 
                		
                		
   				             
            

            	<input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   			</form> 
   
	</div>

     <%
     /*
         dept.setDeptNo(request.getParameter("deptNo"));
          dept.setDeptNo(request.getParameter("deptName"));
          dept.setDeptNo(request.getParameter("location"));
           dept.setDeptNo(request.getParameter("username"));
           request.setAttribute("reqDeptObj", dept);
       */     
            %>      
</div>

</body>
</html>
