<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<title>SellerProduct</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="SellerProductJsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="SellerProductJsps/demo.css" media="all" />
    
    <!-- <script language="javascript" type="text/javascript" src="dealjsps/datetimepicker.js">
</script> -->
</head>
<body>

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%> 
<% session.setAttribute("username",session.getAttribute("username")); %>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Enter ProductSeller Details to Insert</h1>
            </header>  
            
            <%
            ProductBean product=(ProductBean)session.getAttribute("product");
            session.setAttribute("product", product);
            session.setAttribute("toPage", "insertsellerproduct"); %>
      <div  class="form" >
    		<form id="contactform" action="ProductID" >
    		<input type="hidden" name="hid" value="insertsellerproduct"> 
     			 
    			<p class="contact"><label for="email">Product_Name</label> <br><br>
    			 <input id="email" name="Product_Name" placeholder="Enter Product_Name" required="" type="text" value="<%=product.getProductName()%>" > 
 				
  				<%-- <select class="txtfield" name="productid"> 
  				 <% 
 	 				ProductArray productArray =(ProductArray) request.getAttribute("productArray");
					ProductBean[] productBean=null;
					if(productArray!=null){
					productBean = productArray.getProduct();

					for(int i=0;i<productBean.length;i++){
				%>
				<option value="<%=productBean[i].getProductId() %>"><%=productBean[i].getProductName() %></option>
				<%}} %> 
				</select> --%> </p><br>
  				
 	 							
     			<p class="contact"><label for="name">Seller_Name</label> 
    	<%--		<input id="name" name="SELLER_ID" placeholder="Enter SELLER_ID" required=""  type="text">  --%>
		
            	<!-- <p class="contact"><label for="phone">Product ID</label></p> 
            	<input id="phone" name="productid" placeholder="Enter Product ID" required="" type="text"> <br>  -->


				
				
				
				<%--<p class="contact"><label for="phone">Seller ID</label></p> 
            	<input id="phone" name="productid" placeholder="Enter Product ID" required="" type="text"> <br> --%>

  				<select class="txtfield" name="sellerid">
 	 			<% 
 	 				SellerArray sellerArray =(SellerArray) request.getAttribute("sellerArray");
					Seller[] seller=null;
					if(sellerArray!=null){
					seller = sellerArray.getSeller();

					for(int i=0;i<seller.length;i++){
				%>
				<option value="<%=seller[i].getSid() %>"><%=seller[i].getSName() %></option>
				<%}} %>
				</select></p>  <br>

				<%--<p class="contact"><label for="email">Start Date</label></p> 
    			<input id="email" name="startdate"  required="" type="date"> 
 
     			<p class="contact"><label for="name">End Date</label></p> 
    			<input id="name" name="enddate"  required=""  type="date"><br> --%>
    			
    				<p class="contact"><label for="name">PRODUCT_SELLER_PRICE</label> <br><br>
    			<input id="name" name="PRODUCT_SELLER_PRICE" placeholder="Enter PRODUCT_SELLER_PRICE" required=""  type="text">
    			 </p>              
		
    			
    			
    			
    			
    			
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
            <input class="buttom" name="submit" id="cancel" tabindex="5" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="SellerProductJsps/jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		
		window.location.replace("/DeptClient/ClientProductSelectID");
		
	});
		
});

</script>

<!-- 
<%
String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
%>
<center>
<h2 style="color: red;font: 50">Record Sucessfully Inserted</h2>
</center>
<%}}%>
 -->   
</div>
</body>
</html>
