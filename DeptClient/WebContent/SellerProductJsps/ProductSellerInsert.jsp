<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.table.operations.TableOperationsStub.SellerProduct" %>
    


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
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            SellerProduct sellerProduct = (SellerProduct)request.getAttribute("SellerProductObj");
            session.setAttribute("SellerProductObj", sellerProduct);
            Seller seller=(Seller)session.getAttribute("seller");
           %>            
 		
            <%session.setAttribute("toPage", "insertseller");
            session.setAttribute("fromPage", "SellerUpdate");%>
      <div  class="form" >
    		<form id="contactform" action="SellerID">
    		<input type="hidden" name="hid" value="insertsellerproduct"> 
     			 
    			<p class="contact"><label for="email">Product_Name</label> <br><br>
 				
  				<select class="txtfield" name="productid"> 
  				 <% 
 	 				ProductArray productArray =(ProductArray) request.getAttribute("productArray");
					ProductBean[] productBean=null;
					if(productArray!=null){
					productBean = productArray.getProduct();

					for(int i=0;i<productBean.length;i++){
				%>
				<option value="<%=productBean[i].getProductId() %>"><%=productBean[i].getProductName() %></option>
				<%}} %> 
				</select></p><br>
  				
 	 							
     			<p class="contact"><label for="name">Seller_Name</label> <br><br>
    			<input id="name" name="Seller_Name" placeholder="Enter SELLER_ID" required=""  type="text" value="<%=seller.getSName()%>">
		

    			
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
		
		window.location.replace("/DeptClient/SellerProductJsps/AddOrSearchDeal.jsp");
		
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
