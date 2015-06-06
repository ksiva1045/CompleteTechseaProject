
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
				<h1> Update Deal Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Deal deal = (Deal)request.getAttribute("dealObj");
            session.setAttribute("deal", deal);
            String startDate=GetDate.getReqFormat(deal.getStartDate());
            String endDate=GetDate.getReqFormat(deal.getEndDate());
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateDealServlet" method="post"> 
    			<p class="contact"><label for="email">Deal Name</label></p> 
    			<input id="email" name="dealName" placeholder="Enter Deal Name" required="" type="text" value="<%=deal.getDealName() %>">                
		
            	<p class="contact"><label for="phone">Deal Details</label></p> 
            	<input id="phone" name="dealDetails" placeholder="Enter Deal Details" required="" type="text" value="<%=deal.getDealDetails()%>"> <br>

				<p class="contact"><label for="email">Product ID</label></p> 
    			<!-- <input id="email" name="productId" placeholder="Enter Product ID" required="" type="text" value="<%=deal.getProductId() %>"> --> 
                		
                		
   				<select class="txtfield" name="productId">
 	 			<% 
 	 				ProductArray productArray =(ProductArray) request.getAttribute("productArray");
					ProductBean[] productBean=null;
					if(productArray!=null){
					productBean = productArray.getProduct();

					for(int i=0;i<productBean.length;i++){
						if(productBean[i].getProductCode().equals(deal.getProductId())){
				%>
			
				<option value="<%=productBean[i].getProductId() %>" selected="selected"><%=productBean[i].getProductName() %></option>
				<%}
						else
					%>
					<option value="<%=productBean[i].getProductId() %>" ><%=productBean[i].getProductName() %></option>
			
					<%	
					
					
					}} %>
				</select>
				
				
				<p class="contact"><label for="email">Seller ID</label></p>                		
                		
            	<select class="txtfield" name="sellerid">
 	 			<% 
 	 				SellerArray sellerArray =(SellerArray) request.getAttribute("sellerArray");
					Seller[] seller=null;
					if(sellerArray!=null){
					seller = sellerArray.getSeller();

					for(int i=0;i<seller.length;i++){
						if(seller[i].getSName().equals(deal.getSellerId())){
				%>
			
				<option value="<%=seller[i].getSid() %>" selected="selected"><%=seller[i].getSName() %></option>
				<%}
						else
					%>
					<option value="<%=seller[i].getSid() %>" ><%=seller[i].getSName() %></option>
			
					<%	
					
					
					}} %>
				</select>
   				             
                
                <p class="contact"><label for="email">Start Date</label></p> 
    			<input id="email" name="startdate"  required="" type="date" value="<%=startDate %>"> 
 
     			<p class="contact"><label for="name">End Date</label></p> 
    			<input id="name" name="enddate"  required=""  type="date" value="<%=endDate %>"><br>
                 
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
