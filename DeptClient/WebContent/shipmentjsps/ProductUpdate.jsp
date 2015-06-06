
<%@page import="com.table.operations.TableOperationsStub.ProductSpecification"%>
<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
 
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="productjsps/style.css" media="all" />    
    <link rel="stylesheet" type="text/css" href="productjsps/demo.css" media="all" />
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
   
   
    <script type="text/javascript" src="Validations.js">
</script>
    
</head>
<body>
<%@ page import="com.table.operations.TableOperationsStub.ProductCat"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCatArray"%>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1>Update Product Details Here</h1>
             </header>   
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
           
             

            <%
            ProductBean product = (ProductBean)session.getAttribute("product");
            ProductSpecification productSpecification=(ProductSpecification)request.getAttribute("productSpecification");
            session.setAttribute("product", product);
            session.setAttribute("productSpecification", productSpecification);
            session.setAttribute("ToPage",session.getAttribute("toPage"));
            %>
      <div  class="form" >
    		<form id="contactform" action="" method="post"> 
    		
    		
    		  <p class="contact"><label for="email">ProductTypeCode </label></p> 
    		  <input id="ptcode" name="ptcode" placeholder="Enter ProductTypeCode" required="" type="text"  value="<%=product.getProductCode() %>"> 
            
              <p class="contact"><label for="email">ProductName</label></p> 
    		  <input id="pname" name="pname" placeholder="Enter ProductName" required="" type="text"  value="<%=product.getProductName() %>"> 
             
		
              <p class="contact"><label for="phone">ProductPrice</label></p> 
              <input id="pprice" name="pprice" placeholder="Enter ProductPrice" required="" type="text"  onfocusout="isNumber(this,1)" value="<%=product.getPrice()%>"> <br>
              	<span style="color:red;" id="error1" > </span>
            
              <p class="contact"><label for="email">Product Service Code</label></p> 
    		  <input id="pscode" name="pscode" placeholder="Enter Product Service Code" required="" type="text" value="<%=product.getServiceCode() %>"> 
               
                 
              <p class="contact"><label for="phone">PRODUCT_CAT_ID</label> </p>
             
             	<p class="contact">
                <select class="txtfield" name="prod_cat_id" onchange="isChanged()">
				<% 
 	 				ProductCatArray productCatArray =(ProductCatArray) request.getAttribute("productCatArray");
					ProductCat[] productCat=null;
					if(productCatArray!=null){
						productCat = productCatArray.getProductCat();
						
					for(int i=0;i<productCat.length;i++){
					
						if(productCat[i].getId().equals(product.getProuduct_cat_id())){
				%>
			
				<option value="<%=productCat[i].getId() %>" selected="selected"><%=productCat[i].getPname() %></option>
				<%}
						else{
					%>
					<option value="<%=productCat[i].getId() %>" ><%=productCat[i].getPname() %></option>
			
					<%	
					
					
					}}} %>
				</select>  
                 
                </p>
                 
        
              
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit" onclick="save()"> 
             <input class="buttom" name="AddSeller" id="AddSeller" tabindex="5" value="AddSeller" type="button">	 
            <input class="buttom" name="ShowSellers" id="ShowSellers" tabindex="5" value="ShowSellers" type="button">	 
            
            <input class="buttom" name="cancel" id="cancel" tabindex="5" value="Cancel" type="button">	 
            <input type="hidden" id="hidToPage" name="hidToPage"/>
   </form> 
   
</div>
<script type="text/javascript" src="productjsps/jquery.js"></script>
<script type="text/javascript">

function isChanged(){
	//alert("inside isChnage()");
	document.getElementById("submit").value="Next";
}



function save()
{	
	if(document.getElementById("submit").value==="Next"){
		
		document.getElementById("contactform").action = "ProductCatStaticServlet";
		
		document.getElementById("contactform").submit();
	}
	else{
		
		document.getElementById("contactform").action = "ClientServletUpdate";
		
		document.getElementById("contactform").submit();
	}
}


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/ClientServletSelectAll");
	});
	
});

$(document).ready(function()
		{ 
	$('#AddSeller').click(function(){
		$("#hidToPage").val("insert");	
		alert($("#hidToPage").val());
		window.location.replace("/DeptClient/SellerID");
	});
		
});
 
 $(document).ready(function()
		{ 
	$('#ShowSellers').click(function(){
		
		window.location.replace("/DeptClient/ShowSellerServlet");
	});
		
});

</script>
 
</div>

</body>
</html>