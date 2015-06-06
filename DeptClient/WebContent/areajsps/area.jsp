
<%@page import="org.hibernate.dialect.Sybase11Dialect"%>
<%@page import="com.table.operations.TableOperationsStub.ProductCat"%>
<%@page import="com.table.operations.TableOperationsStub.ProductCatArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Area</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	    <link rel="stylesheet" type="text/css" href="areajsps/style.css" media="all" />
	    <link rel="stylesheet" type="text/css" href="areajsps/demo.css" media="all" /> 
	    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<script src="areajsps/autocompleter.js"></script>
    <script type="text/javascript">
   
   
        function GetLocation() {      
            var geocoder = new google.maps.Geocoder();
            var address = document.getElementById("location").value;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    var latitude = results[0].geometry.location.lat();
                    var longitude = results[0].geometry.location.lng();
                   	document.getElementById("latitude").value=latitude;
                   	document.getElementById("longitude").value=longitude;
                    alert(productid);
                    
                
                    
                    
                } else {
                    alert("Request failed.");
                }
            });
        };
        
    </script>
	</head>

	<body>
		`<div class="container">	
			<header>
				<h1> Enter Details to Search Products</h1>
            </header> 
            <%
            String productcatid=(String)session.getAttribute("productcatid");
            String productcatid1=(String)session.getAttribute("productcatid1");
            System.out.print("inside jsp"+productcatid);
            
            session.setAttribute("username",session.getAttribute("username"));
			session.setAttribute("callerMobileNo", session.getAttribute("callerMobileNo"));
			session.setAttribute("startTime",session.getAttribute("startTime"));
			%>      
      		<div  class="form" >
    			<form id="contactform" method="post" action="ProductCatIDProductIDSevlet" name="form1">
    			
    				<p class="contact"><label for="email">ProductCategory</label></p>
    				<select class="txtfield" name="productcatid" onchange="document.form1.submit();">
	 	 			<% 
	 	 				ProductCatArray productCatArray =(ProductCatArray) request.getAttribute("productCatArray");
						ProductCat[] productCats=null;
						if(productCatArray!=null){
							productCats = productCatArray.getProductCat();
	
						for(int i=0;i<productCats.length;i++){
							if((productcatid!=null)&&(productCats[i].getId().equalsIgnoreCase(productcatid)))
							{
								   System.out.print("inside jsp"+productcatid);
							%>
							
								<option value="<%=productCats[i].getId() %>" selected="selected"><%=productCats[i].getPname() %></option>
								<% 	}
							else
							{
								
						
					%>
					<option value="<%=productCats[i].getId() %>"><%=productCats[i].getPname() %></option>
					<%}}} %>
					</select>
					
					<select class="txtfield" id="productcatid1" name="productcatid1" onchange="document.form1.submit();">
	 	 			<% 
	 	 				ProductCatArray productCatArray1 =(ProductCatArray) request.getAttribute("productCatArray1");
						ProductCat[] productCats1=null;
						if(productCatArray1!=null){
							productCats1 = productCatArray1.getProductCat();
	
						for(int i=0;i<productCats1.length;i++){
							if((productcatid1!=null)&&(productCats1[i].getId().equalsIgnoreCase(productcatid1)))
							{
								   System.out.print("inside jsp"+productcatid);
							%>
							
								<option value="<%=productCats1[i].getId() %>" selected="selected"><%=productCats1[i].getPname() %></option>
								<% 	}
							else
							{
								
						
					%>
					<option value="<%=productCats1[i].getId() %>"><%=productCats1[i].getPname() %></option>
					<%}}} %>
					</select>
					
    			</form>
    				
    			<form action="AreaSearchServlet" method="post">
    				<p class="contact"><label for="email">ProductName</label></p>
    				<input class="search" id="productid" name="productid" placeholder="Enter Product Name" type="text">
    				
					<%--<select class="txtfield" name="productid" id="productid">
	 	 			<% 
	 	 				ProductArray productArray =(ProductArray) request.getAttribute("productArray");
    					session.setAttribute("productArray", productArray);
						ProductBean[] productBean=null;
						if(productArray!=null){
						productBean = productArray.getProduct();
	
						for(int i=0;i<productBean.length;i++){
					%>
					<option value="<%=productBean[i].getProductId() %>"><%=productBean[i].getProductName() %></option>
					<%}} %>
					
					</select><br> --%>
					<!-- search by price here -->
					<br>
				<p class="contact"><label for="email">Price Range</label></p>
				<select class="txtfield" name="price" id="price">
				<option value="1">select price range here</option>
				<option value="0">Rs 5000 and Below</option>
				<option value="5000">Rs 5000 - Rs 10,000</option>
				<option value="10000">Rs 10,000 - Rs 15,000</option>
				<option value="15000">Rs 15,000 - Rs 20,000</option>
				<option value="20000">Rs 20,000 - Rs 25,000</option>
				<option value="25000">Rs 25,000 - Rs 30,000</option>
				<option value="30000">Rs 30,000 - Rs 35,000</option>
				<option value="35000">Rs 35,000 - Rs 40,000</option>
				<option value="40000">Rs 40,000 - Rs 45,000</option>
				<option value="45000">Rs 45,000 - Rs 50,000</option>
				
				</select><br>
					<br>
					
					<p class="contact"><label for="email">Discount</label></p>
					<select class="txtfield" name="discount" >
						<%
						for(int i=0;i<100;i=i+10){%>
							<option value="<%=i%>">above <%=i %>%</option>
						<%} %>
					</select>
					
					<p class="contact"><label for="email">Location</label></p>
					<input class="search" id="location" name="location" placeholder="Enter Location" type="text" onfocusout="GetLocation();">
					
					<p class="contact"><label for="email">Distance</label></p>
					<input id="dist" name="distance" placeholder="Enter Distance" type="text">
					
					
					<%--<p class="contact"><select class="txtfield" name="distance" id="dist" >
						<%
						for(int i=0;i<=10;i++){%>
							<option value="<%=i%>"><%=i %></option>
						<%} %>
					</select>
					</p> --%>
					<input type="hidden" id="latitude" name="latitude">
					<input type="hidden" id="longitude" name="longitude">
					<input class="buttom" name="cancel" id="cancel" value="GetProducts" type="submit">  	 
					<input class="buttom" name="compare" id="compare" value="Compare" type="button"> 
				
<script type="text/javascript" src="areajsps/jquery.js"></script>			
<script type="text/javascript">
$(document).ready(function()
		{
	$('#compare').click(function(){
		window.location.replace("/DeptClient/RelatedProductsServlet");
	});
		
});

</script>
				
				</form>
			</div>
		</div>
	</body>
</html>
