
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Customer" %>
<!DOCTYPE html>
<html>
<head>
<title>customer</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="customerjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="customerjsps/demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Update Customer Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Customer customer = (Customer)request.getAttribute("customerObj");
            session.setAttribute("customer", customer);
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateCustomerServlet" method="post"> 
    				<p class="contact"><label for="email">Gender</label></p> 
    			<input id="email" name="gender" placeholder="Enter Gender" required="" type="text" value="<%=customer.getGender() %>"> 
    			
    			<p class="contact"><label for="email">Firstname</label></p> 
    			<input id="email" name="firstname" placeholder="Enter Firstname" required="" type="text" value="<%=customer.getFirstname() %>"> 
                
                
                <p class="contact"><label for="email">Middlename</label></p> 
    			<input id="email" name="middlename" placeholder="Enter Middlename" required="" type="text" value="<%=customer.getMiddlename() %>"> 
                
                
                <p class="contact"><label for="email">Lastname</label></p> 
    			<input id="email" name="lastname" placeholder="Enter Lastname" required="" type="text" value="<%=customer.getLastname() %>"> 
    			
    			 <p class="contact"><label for="email">EmailAddress</label></p> 
    			<input id="email" name="email" placeholder="Enter EmailAddress" required="" type="text" value="<%=customer.getEmail() %>"> 
                
                
                 <p class="contact"><label for="email">Loginname</label></p> 
    			<input id="email" name="loginname" placeholder="Enter Loginname" required="" type="text" value="<%=customer.getLoginname() %>"> 
                
                
                 <p class="contact"><label for="email">LoginPassword</label></p> 
    			<input id="email" name="loginpassword" placeholder="Enter LoginPassword" required="" type="password" value="<%=customer.getLoginpassword() %>"> 
                
                
                
                <p class="contact"><label for="email">PhoneNumber</label></p> 
    			<input id="email" name="phonenumber" placeholder="Enter PhoneNumber" required="" type="text" value="<%=customer.getPhonenumber() %>"> 
                
                
                <p class="contact"><label for="email">Address1</label></p> 
    			<input id="email" name="add1" placeholder="Enter Address1" required="" type="text" value="<%=customer.getAdd1() %>"> 
                
                
                <p class="contact"><label for="email">Address2</label></p> 
    			<input id="email" name="add2" placeholder="Enter Address2" required="" type="text" value="<%=customer.getAdd2() %>"> 
                
                
                <p class="contact"><label for="email">Address3</label></p> 
    			<input id="email" name="add3" placeholder="Enter Address3" required="" type="text" value="<%=customer.getAdd3() %>"> 
                
                <p class="contact"><label for="email">Address4</label></p> 
    			<input id="email" name="add4" placeholder="Enter Address4" required="" type="text" value="<%=customer.getAdd4() %>"> 
                
               <%--  <p class="contact"><label for="email">City</label></p> 
    			<input id="email" name="city" placeholder="Enter Address2" required="" type="text" value="<%=customer.getCity() %>"> 
                
                
                <p class="contact"><label for="email">State</label></p> 
    			<input id="email" name="state" placeholder="Enter Address3" required="" type="text" value="<%=customer.getState() %>"> 
                
                <p class="contact"><label for="email">Country</label></p> 
    			<input id="email" name="country" placeholder="Enter Address4" required="" type="text" value="<%=customer.getCountry() %>"> 
    			   --%>
    			
               <p class="contact"><label for="email">City</label></p> 
    			<input id="email" name="city" placeholder="Enter City" required="" type="text" value="<%=customer.getCity() %>"> 
                
                
                <p class="contact"><label for="email">State</label></p> 
    			<input id="email" name="state" placeholder="Enter State" required="" type="text" value="<%=customer.getState() %>"> 
                
                
                <p class="contact"><label for="email">Country</label></p> 
    			<input id="email" name="country" placeholder="Enter Country" required="" type="text" value="<%=customer.getCountry() %>"> 
                
              
		
            <p class="contact"><label for="phone">ZipCode</label></p> 
            <input id="phone" name="zipcode" placeholder="Enter ZipCode" required="" type="text" value="<%=customer.getZipcode() %>"> <br>

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
