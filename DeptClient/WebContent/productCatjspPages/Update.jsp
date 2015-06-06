
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductCat" %>
<%@ page import="com.table.operations.TableOperationsStub.ProductCatStatic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Validations.js">
</script>
<title>productCat</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="productCatjspPages/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="productCatjspPages/demo.css" media="all" />
</head>
<body>
<%@ page import="com.table.operations.TableOperationsStub.ProductCat"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCatArray"%>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Update ProductCat Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            ProductCat productCat = (ProductCat)request.getAttribute("productCatObj");
            ProductCatStatic productcatstatic=(ProductCatStatic)request.getAttribute("productcatstaticObj");

            session.setAttribute("productCat", productCat);
            session.setAttribute("productcatstatic", productcatstatic);
            
                       

            %>
          
      <div  class="form" >
    		<form id="contactform" action="UpdateServlet" method="post"> 
    		
    		<p class="contact"><label for="email">PROD_CATAGORY_NAME </label></p> 
    		<!-- <input id="PROD_CATAGORY_NAME" name="PROD_CATAGORY_NAME" placeholder="Enter Prod catagory name" required="" type="text" value="<%=productCat.getPname()%>" onfocusout="isNull(this,1)"> --> 
    		<input id="PROD_CATAGORY_NAME" name="PROD_CATAGORY_NAME" placeholder="Enter Prod catagory name" required="" type="text" value="<%=productCat.getPname() %>" onfocusout="isNull(this,1)">
             <span style="color:red;" id="error1" > </span>   
		
            <p class="contact"><label for="phone">PROD_CATAGORY_DETAILS</label></p> 
            <input id="PROD_CATAGORY_DETAILS" name="PROD_CATAGORY_DETAILS" placeholder="Enter Prod catagory Details" required="" type="text" value="<%=productCat.getPdetails()%>" onfocusout="isNull(this,2)"> <br>
            <span style="color:red;" id="error2" > </span>
       
             <p class="contact"><label for="phone">PRODUCT_PARENT_ID</label></p> 
             
             
                <select class="txtfield" name="PRODUCT_PARENT_ID" onfocusout="isNumber(this,3)">
				<% 
 	 				ProductCatArray productCatArray =(ProductCatArray) request.getAttribute("productCatArray");
					ProductCat[] productCat1=null;
					if(productCatArray!=null){
						productCat1 = productCatArray.getProductCat();
						
					for(int i=0;i<productCat1.length;i++){
					
						if(productCat1[i].getId().equals(productCat.getProd_parent_id())){
				%>
			
				<option value="<%=productCat1[1].getId() %>" selected="selected"><%=productCat1[i].getPname() %></option>
				<%}
						else{
					%>
					<option value="<%=productCat1[i].getId() %>" ><%=productCat1[i].getPname() %></option>
			
					<%	
					
					
					}}} %>
				</select>
             <span style="color:red;" id="error3" > </span>
             

    			<p class="contact"><label for="email">productquality1 </label></p> 
    			<input id="productquality1" name="PRODUCT_QUALITY_1" placeholder="Enter product quality1" required="" type="text" value="<%=productcatstatic.getProductquality1() %>" onfocusout="isNull(this,4)"> 
                <span style="color:red;" id="error4" > </span>
		
              <p class="contact"><label for="phone">productquality2</label></p> 
              <input id="productquality2" name="PRODUCT_QUALITY_2" placeholder="Enter product quality2" required="" type="text" value="<%=productcatstatic.getProductquality2()%>" onfocusout="isNull(this,5)"> <br>
			<span style="color:red;" id="error5" > </span>
             
    			  
    			  
    		 <p class="contact"><label for="username">productquality3</label></p> 
    		 <input id="productquality3" name="PRODUCT_QUALITY_3" placeholder="Enter  product quality3" required=""  type="text" value="<%=productcatstatic.getProductquality3() %>" onfocusout="isNull(this,6)">
    			<span style="color:red;" id="error6" > </span>
    			
    		 <p class="contact"><label for="email">productquality4 </label></p> 
           	 <input id="productquality4" name="PRODUCT_QUALITY_4" placeholder="Enter product quality4" required="" type="text" value="<%=productcatstatic.getProductquality4() %>" onfocusout="isNull(this,7)"> 
            	<span style="color:red;" id="error7" > </span>
		
            <p class="contact"><label for="phone">productquality5</label></p> 
            <input id="productquality5" name="PRODUCT_QUALITY_5" placeholder="Enter product quality5" required="" type="text" value="<%=productcatstatic.getProductquality5() %>" onfocusout="isNull(this,8)"><br>
				<span style="color:red;" id="error8" > </span>
             
    		 <p class="contact"><label for="username">productquality6</label></p> 
    		 <input id="productquality6" name="PRODUCT_QUALITY_6" placeholder="Enter product quality6" required=""  type="text" value="<%=productcatstatic.getProductquality6()%>" onfocusout="isNull(this,9)"> 
    			<span style="color:red;" id="error9" > </span>
    			
    		 <p class="contact"><label for="email">productquality7 </label></p> 
    		 <input id="productquality7" name="PRODUCT_QUALITY_7" placeholder="Enter product quality7" required="" type="text" value="<%=productcatstatic.getProductquality7() %>" onfocusout="isNull(this,10)"> 
                <span style="color:red;" id="error10" > </span>
		
            <p class="contact"><label for="phone">productquality8</label></p> 
            <input id="productquality8" name="PRODUCT_QUALITY_8" placeholder="Enter product quality8" required="" type="text" value="<%=productcatstatic.getProductquality8() %>" onfocusout="isNull(this,11)"> <br>
				<span style="color:red;" id="error11" > </span>
          
    			  
    		<p class="contact"><label for="username">productquality9</label></p> 
    		<input id="productquality9" name="PRODUCT_QUALITY_9" placeholder="Enter  product quality9" required=""  type="text" value="<%=productcatstatic.getProductquality9() %>" onfocusout="isNull(this,12)"> 
    			<span style="color:red;" id="error12" > </span>
    			
    		<p class="contact"><label for="username">productquality10</label></p> 
    		<input id="productquality10" name="PRODUCT_QUALITY_10" placeholder="Enter  product quality10" required=""  type="text"value="<%=productcatstatic.getProductquality10() %>" onfocusout="isNull(this,13)"> 	  
    			<span style="color:red;" id="error13" > </span> 
    			  
    		
    				              
            <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
			</form>   			
   			
</div>
    
</div>

</body>
</html>
