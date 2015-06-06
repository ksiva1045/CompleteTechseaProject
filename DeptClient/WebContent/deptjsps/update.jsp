
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Dept" %>
<!DOCTYPE html>
<html>
<head>
<title>dept</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="deptjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="deptjsps/demo.css" media="all" />
</head>
<body>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Update Dept Details Here</h1>
            </header>       
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Dept dept = (Dept)request.getAttribute("deptObj");
            session.setAttribute("dept", dept);
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateDeptServlet" method="post"> 
    				<p class="contact"><label for="email">Department Name</label></p> 
    			<input id="email" name="deptName" placeholder="Enter department name" required="" type="text" value="<%=dept.getDeptName() %>"> 
                
		
            <p class="contact"><label for="phone">Location</label></p> 
            <input id="phone" name="location" placeholder="Enter Location" required="" type="text" value="<%=dept.getLocation()%>"> <br>

              
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
