<%@page import="com.table.operations.TableOperationsStub.ProductCatStatic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>products</title>
<script type="text/javascript" src="Validations.js">
</script>

	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="productjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="productjsps/demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
	<%@ page import="com.table.operations.TableOperationsStub.ProductCatStatic"%>
	<%@ page import="com.table.operations.TableOperationsStub.ProductCatStaticArray"%>
	<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>

	
	        <%
            ProductCatStatic productCatStatic = (ProductCatStatic)request.getAttribute("productCatStatic");            
            session.setAttribute("productCatStatic", productCatStatic);  

            session.setAttribute("product", session.getAttribute("product"));
            
            session.setAttribute("toPage", "update");
            %>

			<header>
			
				<h1> Enter Products Details to Insert</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" method="get" action="ClientServlet" >
    		<input type="hidden" name="hid" value="insertproduct"> 
    		 
					
              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality1() %></label></p> 
              <input id="phone" name="product_typecode" placeholder="Enter product_typecode" required="" type="text" <%--  value=<%=productCatStatic.getProductquality1() --%>> <br>
           
           
              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality1() %></label></p> 
              <input id="phone" name="product_colour" placeholder="Enter ProductColour" required="" type="text"<%--value=<%=productCatStatic.getProductquality1() --%>> <br>
			
			  
              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality2() %></label></p> 
              <input id="phone" name="product_size" placeholder="Enter Product Size" required="" type="text"<%--value=<%=productCatStatic.getProductquality2() --%>> <br>
			
	
    	      <p class="contact"><label for="email"><%=productCatStatic.getProductquality3() %></label></p> 
    		  <input id="product_features" name="product_features" placeholder="Enter product features " required="" type="text"<%--value=<%=productCatStatic.getProductquality3() --%>> 
               <span style="color:red;" id="error4" > </span>
                		
              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality4() %></label></p> 
              <input id="productquality4" name="productquality4" placeholder="Enter product quality4" required="" type="text"<%--value=<%=productCatStatic.getProductquality4() --%>> <br>
   			
   			  
    		  <p class="contact"><label for="username"><%=productCatStatic.getProductquality5() %></label></p> 
    		  <input id="productquality5" name="productquality5" placeholder="Enter  product quality5" required=""  type="text"<%--value=<%=productCatStatic.getProductquality5() --%>> 
    		 
    		  	
    		  <p class="contact"><label for="email"><%=productCatStatic.getProductquality6() %></label></p> 
           	  <input id="productquality6" name="productquality6" placeholder="Enter product quality6" required="" type="text"<%--value=<%=productCatStatic.getProductquality6() --%>> 
			  
              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality7() %></label></p> 
              <input id="productquality7" name="productquality7" placeholder="Enter product quality7" required="" type="text"<%--value=<%=productCatStatic.getProductquality7() --%>> <br>
		
    		  <p class="contact"><label for="username"><%=productCatStatic.getProductquality8() %></label></p> 
    		  <input id="productqualit8" name="productquality8" placeholder="Enter product quality8" required=""  type="text" <%--value=<%=productCatStatic.getProductquality8() --%>> 
    		
    		
    		  <p class="contact"><label for="email"><%=productCatStatic.getProductquality9() %></label></p> 
    		  <input id="productquality9" name="productquality9" placeholder="Enter product quality9" required="" type="text" <%--value=<%=productCatStatic.getProductquality9() --%>> 
			

              <p class="contact"><label for="phone"><%=productCatStatic.getProductquality10() %></label></p> 
              <input id="productquality10" name="productquality10" placeholder="Enter product quality10" required="" type="text"<%--value=<%=productCatStatic.getProductquality10() --%>> <br>
  		
  
              <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
              <input class="buttom" name="back" id="back" value="Back" type="button"> 
              <input class="buttom" name="cancel" id="cancel" value="Cancel" type="button">  	 
   </form>
  <script type="text/javascript" src="productjsps/jquery.js"></script>
   
   <script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		
		window.location.replace("/DeptClient/productjsps/AddOrSearch.jsp");
		
	});
		
});


$(document).ready(function(){
	
	$('#back').click(function(){
		
		window.location.replace("/DeptClient/ClientProductSelectID");
		
	});
		
});

</script> 
</div>   


<% session.setAttribute("username",session.getAttribute("username")); %>

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
