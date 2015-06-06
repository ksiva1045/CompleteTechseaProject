<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>seller</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
	<% session.setAttribute("username",session.getAttribute("username"));%>
			<header>
				<h1> Enter Seller Details to Insert</h1>
            </header>       
      <div  class="form" >
    		<form id="contactform" method="post" action="../InsertSeller">
    		<input type="hidden" name="hid" value="insertSeller"> 
    			<p class="contact"><label for="name">Seller Name</label></p> 
    			<input id="name" name="SellerName" placeholder="Enter Seller name" required=""  type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Address</label></p> 
    			<input id="email" name="SellerAddress" placeholder="Enter SellerAddress" required="" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Type</label></p> 
            <input id="phone" name="SellerType" placeholder="Enter Seller Type" required="" type="text"> <br>

 	<p class="contact"><label for="name">Seller Pincode</label></p> 
    			<input id="name" name="SellerPincode" placeholder="Enter Seller Pincode" required=""  type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Employee Contact No</label></p> 
    			<input id="email" name="SellerEmpContactNo" placeholder="Enter Seller Employee Contact No" required="" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Marketing No</label></p> 
            <input id="phone" name="SellerMarketingNo" placeholder="Enter Seller Marketing No" required="" type="text"> <br>
            	<p class="contact"><label for="name">Seller Manager No</label></p> 
    			<input id="name" name="SellerManagerNo" placeholder="Enter Seller Manager No" required=""  type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Marketing Mailid</label></p> 
    			<input id="email" name="SellerMarketingMailid" placeholder="Enter Seller Marketing Mailid " required="" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Business Mailid</label></p> 
            <input id="phone" name="SellerBusinessMailid" placeholder="Enter Seller Business Mailid" required="" type="text"> <br>
            	<p class="contact"><label for="name">Best Time To Contact</label></p> 
    			<input id="name" name="BestTimeToContact" placeholder="Enter  Best Time To Contact" required=""  type="text"> 
    			 
    			<p class="contact"><label for="email">Contact Frequency</label></p> 
    			<input id="email" name="ContactFrequency" placeholder="Enter Contact Frequency" required="" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller CatId</label></p> 
            <input id="phone" name="SellerCatId" placeholder="Enter Seller CatId" required="" type="text"> <br>
               
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	
            <input class="buttom" name="submit" id="cancel" tabindex="5" value="Cancel" type="button"> 	 
             
   </form> 
</div>   
 </div>
 <%= request.getAttribute("sucessFlag") 
%>

<script type="text/javascript" src="jquery.js"></script>

<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/sellerjsps/sellerAddOrSearch.jsp");
		
	});
		
});


</script>
</body>
</html>
