
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Coupon" %>
<%@ page import="com.coupon.GetDate" %>
<%@ page import="com.clientsupport.*" %>
<%@ page import="com.table.operations.TableOperationsStub.SellerArray" %>
<%@ page import="com.table.operations.TableOperationsStub.Seller" %>

<!DOCTYPE html>
<html>
<head>
<title>Deal</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="Couponjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="Couponjsps/demo.css" media="all" />
</head>
<body background="dealjsps/images/bgnoise_lg.png">
<div class="container">
			<header>
				<h1> Update Deal Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Coupon coupon = (Coupon)request.getAttribute("couponAll");
            session.setAttribute("coupon", coupon);
            String issuedate=GetDate.getReqFormat(coupon.getIssueDate());
            String expiredate=GetDate.getReqFormat(coupon.getExpireDate());
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateCouponServlet" method="post"> 
    				 
    			<p class="contact"><label for="email">Coupon Name</label></p> 
    			<input id="email" name="couponName" placeholder="Enter Coupon Name" required="" type="text" value="<%=coupon.getCouponName()%>"> 
 				
 				<p class="contact"><label for="name">Coupon code</label></p> 
    			<input id="name" name="couponCode" placeholder="Enter Coupon code" required=""  type="text" value="<%=coupon.getCouponCode()%>">                
     			
     			<p class="contact"><label for="name">Coupon Details</label></p> 
    			<input id="name" name="couponDetails" placeholder="Enter Coupon Details" required=""  type="text" value="<%=coupon.getCouponDetails()%>">                
		
            	

                <p class="contact"><label for="username">Seller ID</label></p> 
    			
<select class="txtfield" name="sellerId">
 	 			
<% 
 	 				SellerArray sellerArray =SelectAllData.sellerSellectAll();
					Seller[] seller=null;
					if(sellerArray!=null){
					seller = sellerArray.getSeller();
					
					
					System.out.println("Inside Scriptlet");
					
					for(int i=0;i<seller.length;i++){
					System.out.println(seller[i].getSid());
					System.out.println("Coupon CLass    ::::::"+coupon.getSellerId());
						if(seller[i].getSid().equals(coupon.getSellerId())){
				%>
			
				<option value="<%=seller[i].getSid() %>" selected="selected"><%=seller[i].getSName() %></option>
				<%}
						else
					%>
					<option value="<%=seller[i].getSid() %>" ><%=seller[i].getSName() %></option>
			
					<%	
					
					
					}} %>
				</select>





				<p class="contact"><label for="phone">issue Date</label></p> 
            	
            	<input type="date"  class="issueDate"   placeholder="Enter issue Date" min="2014-09-08" name="issueDate" value="<%=issuedate %>">
            	

                <p class="contact"><label for="username">Expiry Date</label></p> 
                <input type="date"  class="expireDate"   placeholder="Enter EXpiry Date" min="2014-09-08" name="expireDate" value="<%=expiredate%>">

                
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
