
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
</head>
<body background="SellerProduct/jsps/images/bgnoise_lg.png">

<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductArray"%>
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray"%>
<div class="container">
			<header>
				<h1> Update SellerProduct Details Here</h1>
            </header>       
 <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            SellerProduct sellerProduct = (SellerProduct)request.getAttribute("SellerProductObj");
            session.setAttribute("SellerProductObj", sellerProduct);
           %>            
              <%--session.setAttribute("toPage", "insertsellerproduct"); --%>
      <div  class="form" >
    		<form id="contactform" method="post" action="UpdateProductSellerServlet">
    		<input type="hidden" name="hid" value="insertsellerproduct"> 
     	<form id="contactform" action="ProductID" method="post"> 
    		
    		
    		
    		
                <p class="contact"><label for="email">Product_Name</label> <br><br>
    			 <input id="email" name="Product_Name" placeholder="Enter Product_Name" required="" type="text" value="<%=sellerProduct.getPid() %>">  
 				    			
 	 							</select><br><br>
				</p>
    			
    			<%-- <input id="email" name="productid" placeholder="Enter productid" required="" type="text" value= 
    			"<%=sellerProduct.getPid() %>"> --%>
		
            	<p class="contact"><label for="phone">Seller_Name</label><br><br>
            <input id="phone" name="Seller_Name" placeholder="Enter sellerid" required="" type="text" value="<%=sellerProduct.getSid()%>"> 
            <!-- 	<select class="txtfield" name="Seller_Name"> -->
 	 							</select><br><br>
				</p> 
				
				
				
				<p class="contact"><label for="email">PRODUCT_SELLER_PRICE</label><br><br>
				
    			 <input id="email" name="PRODUCT_SELLER_PRICE" placeholder="Enter PRODUCT_SELLER_PRICE " required="" type="text" value=<%=sellerProduct.getPsprice()%>><br> 
    			 </p> 
                
   				             
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
