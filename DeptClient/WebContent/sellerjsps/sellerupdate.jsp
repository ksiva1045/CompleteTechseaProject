
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Seller" %>
<!DOCTYPE html>
<html>
<head>
<title>seller</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="sellerjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="sellerjsps/demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Update Seller Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
           
            <%
            Seller seller = (Seller)request.getAttribute("sellerObj");
            session.setAttribute("seller", seller);
            session.setAttribute("toPage", "insertseller");
            %>
            
      <div  class="form" >
    		<form id="contactform" action="UpdateSellerServlet" method="post"> 
    					<p class="contact"><label for="name">Seller Name</label></p> 
    			<input id="name" name="SellerName" placeholder="Enter Seller name" required="" value="<%=seller.getSName() %>" type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Address</label></p> 
    			<input id="email" name="SellerAddress" placeholder="Enter SellerAddress" required="" value="<%=seller.getSellerAddress()%>" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Type</label></p> 
            <input id="phone" name="SellerType" placeholder="Enter Seller Type" required="" value="<%=seller.getSellerType() %>" type="text"> <br>

 	<p class="contact"><label for="name">Seller Pincode</label></p> 
    			<input id="name" name="SellerPincode" placeholder="Enter Seller Pincode" required="" value="<%=seller.getSPincode() %>" type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Employee Contact No</label></p> 
    			<input id="email" name="SellerEmpContactNo" placeholder="Enter Seller Employee Contact No" required="" value="<%=seller.getSellerEmpContactNo() %>" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Marketing No</label></p> 
            <input id="phone" name="SellerMarketingNo" placeholder="Enter Seller Marketing No" required="" value="<%=seller.getSMarketingNo() %>" type="text"> <br>
            	<p class="contact"><label for="name">Seller Manager No</label></p> 
    			<input id="name" name="SellerManagerNo" placeholder="Enter Seller Manager No" required="" value="<%=seller.getSManagerNo() %>"  type="text"> 
    			 
    			<p class="contact"><label for="email">Seller Marketing Mailid</label></p> 
    			<input id="email" name="SellerMarketingMailid" placeholder="Enter Seller Marketing Mailid " required="" value="<%=seller.getSMarketingMailId() %>" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller Business Mailid</label></p> 
            <input id="phone" name="SellerBusinessMailid" placeholder="Enter Seller Business Mailid" required="" value="<%=seller.getSBusinessMailId() %>" type="text"> <br>
            	<p class="contact"><label for="name">Best Time To Contact</label></p> 
    			<input id="name" name="BestTimeToContact" placeholder="Enter  Best Time To Contact" required="" value="<%=seller.getBestTimeToContact() %>"  type="text"> 
    			 
    			<p class="contact"><label for="email">Contact Frequency</label></p> 
    			<input id="email" name="ContactFrequency" placeholder="Enter Contact Frequency" required="" value="<%=seller.getContactFrequency() %>" type="text"> 
                
		
            <p class="contact"><label for="phone">Seller CatId</label></p> 
            <input id="phone" name="SellerCatId" placeholder="Enter Seller CatId" required="" value="<%=seller.getSellerCatId() %>" type="text"> <br>
               
		
            <!-- <p class="contact"><label for="phone">LastModifiedUserId</label></p> 
            <input id="phone" name="LastModifiedUserId" placeholder="Enter LastModifiedUserId " required="" type="text" value="<%--<%=seller.getLastModifiedUserId()%>">--%> <br> -->

              
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	
             <input class="buttom" name="AddProduct" id="AddProduct" tabindex="5" value="AddProduct" type="button">	 
            <input class="buttom" name="ShowProducts" id="ShowProducts" tabindex="5" value="ShowProducts" type="button">	 
            
   </form> 
   
</div>

 <script type="text/javascript" src="SellerProductJsps/jquery.js"></script> 
    		<script type="text/javascript">
    
 $(document).ready(function()
		{ 
	$('#AddProduct').click(function(){
		
		window.location.replace("/DeptClient/ProductID");
	});
		
});
 
 
 $(document).ready(function()
			{ 
		$('#ShowProducts').click(function(){
			
			window.location.replace("/DeptClient/ShowProductServlet");
		});
			
	});

 </script>
     <%
        
            %>      
</div>

</body>
</html>
