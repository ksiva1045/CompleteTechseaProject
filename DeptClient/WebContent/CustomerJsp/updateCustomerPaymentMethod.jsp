
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
<%@ page import=" com.table.operations.TableOperationsStub.CustomerPaymentMethod" %>

<%@ page import="com.table.operations.TableOperationsStub.CustomerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.Customer" %>
<%@ page import="com.clientsupport.SelectAllData" %>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
			<center>
				<h1> Update CustomerPaymentMethod Details Here</h1>
				</center>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
          
            CustomerPaymentMethod paymentmethod=(CustomerPaymentMethod)request.getAttribute("paymentmethod");
    		
            CustomerArray customerArray=SelectAllData.customerSellectAll();
            Customer customer[]=customerArray.getCustomer();
    			
            session.setAttribute("paymentmethod", paymentmethod);
            System.out.println(paymentmethod.getPaymentMethodDetails1());
            System.out.println(paymentmethod.getPaymentMethodCode());
            
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateCustomerPaymentServlet" method="post"> 
    				<p class="contact"><label for="email">CustomerPaymethodMethodCode</label></p> 
    			<%-- <input id="email" name="deptName" placeholder="Enter P" required="" type="text" value="<%=paymentmethod.getPaymentMethodCode() %>">--%> 
                
                 <select name="cid">
  	 			<%  	
    			for(int i=0;i<customer.length;i++)
    			{
    				if(Integer.parseInt(customer[i].getCustomerid())==paymentmethod.getCustomerId())
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
    			
		
            <p class="contact"><label for="phone">CustomerPaymentMethodCode</label></p> 
            <input id="phone" name="paymentCode" placeholder="Enter Method Code" required="" type="text" value="<%=paymentmethod.getPaymentMethodCode()%>"> <br>

              <p class="contact"><label for="phone">CustomerPaymentDetails1<Details1/label></p> 
            <input id="phone" name="details1" placeholder="Enter Detail1" required="" type="text" value="<%=paymentmethod.getPaymentMethodDetails1()%>"> <br>
              
              <p class="contact"><label for="phone">CustomerPaymentDetails2<Details1/label></p> 
            <input id="phone" name="details2" placeholder="Enter Details2" required="" type="text" value="<%=paymentmethod.getPaymentMethodDetails2()%>"> <br>
              
              
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
   </form> 
   
</div>

       
</div>

</body>
</html>
