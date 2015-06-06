<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%@page import="com.table.operations.TableOperationsStub.ProductCatStatic"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCat"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCatArray"%>

<!DOCTYPE html>
<html>
	<head>
<script type="text/javascript" src="Validations.js">
</script>


<%-- ProductCatStatic prod =  (ProductCatStatic)request.getAttribute("productCatStatic");
if(prod!=null){
	
	System.out.println(prod.getProductquality1());
	System.out.println(prod.getProductquality2());
	System.out.println(prod.getProductquality3());
	
}
--%>

		<title>products</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
		<link rel="stylesheet" type="text/css" href="productjsps/style.css" media="all" />
		<link rel="stylesheet" type="text/css" href="productjsps/demo.css" media="all" />
		<link rel="stylesheet" type="text/css" href="style.css" media="all" />
		<link rel="stylesheet" type="text/css" href="demo.css" media="all" />		    
	</head>
<body>
<div class="container">
             <%-- 
             ProductCatStatic productCatStatic=(ProductCatStatic)request.getAttribute("productCatStatic"); 
             --%>    
			<header>			
				<h1> Enter Products Details to Insert</h1>
            </header> 
                  
      <div  class="form">
    		<form id="contactform" method="get" action="ProductCatStaticServlet">
    		<input type="hidden" name="hid" value="insertproduct"> 
    		<%--	<p class="contact"><label for="name">Depar ment Number</label></p> 
    			<input id="name" name="deptNo" placeholder="Enter Deparment number" required=""  type="text"> --%> 
    			 
    			<p class="contact"><label for="email">ProductTypeCode</label></p> 
    			<input id="email" name="ptcode" placeholder="Enter ProductTypeCode" required="" type="text"> 
         
                
	            <p class="contact"><label for="phone">ProductName</label></p> 
                <input id="phone" name="pname" placeholder="Enter ProductName" required="" type="text" > <br>
			
				
                <p class="contact"><label for="phone">ProductPrice</label></p> 
                <input id="phone" name="pprice" placeholder="Enter ProductPrice" required="" type="text"  onfocusout="isNumber(this,1)"> <br>
              <span style="color:red;" id="error1" > </span>
              
                <p class="contact"><label for="phone">Product Service Code</label></p> 
                <input id="phone" name="pscode" placeholder="Enter Product Service Code" required="" type="text"> <br>
			
                <p class="contact"><label for="phone">prod_cat_id</label> 
              
               <select class="txtfield" id="prod_cat_id" name="prod_cat_id" onchange="changelables()"  onfocusout="isNumber(this,2)">
               		
               
               <% 

                		
 	 				ProductCatArray productCatArray =(ProductCatArray) request.getAttribute("productCatArray");
					ProductCat[] productCat=null;
					if(productCatArray!=null){
						productCat = productCatArray.getProductCat();%>
					
					<option value="-" selected="selected">-</option>	
					<% for(int i=0;i<productCat.length;i++){
					%>
					<option value="<%=productCat[i].getId()%>"><%=productCat[i].getPname() %></option>
			
					<% }} %>
					</select>
					<span style="color:red;" id="error2"> </span>
				</p>

		
                
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit" >
            <input class="buttom" name="cancel" id="cancel" value="Cancel" type="button">  	 
   </form> 
</div>   

<% session.setAttribute("username",session.getAttribute("username")); %>
<script type="text/javascript" src="productjsps/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		
		window.location.replace("/DeptClient/productjsps/AddOrSearch.jsp");
		
	});
		
});

</script>

<!-- 
<%
String obj =(String) request.getAttribute("sucessFlag");
if(obj!=null){
	if(obj.equals("success")){
%>

<%}}%>
 -->   
</div>
</body>
</html>
