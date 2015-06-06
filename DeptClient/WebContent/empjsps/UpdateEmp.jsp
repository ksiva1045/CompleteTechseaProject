
<%@ page import="java.util.List" %>
<%@ page import="com.table.operations.TableOperationsStub.Emp" %>
<%@ page import="com.coupon.GetDate" %>
<%@ page import="com.table.operations.TableOperationsStub.Dept"%>
<%@ page import="com.table.operations.TableOperationsStub.DeptArray"%>
<%@ page import="com.clientsupport.SelectAllData" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="empjsps/style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="empjsps/demo.css" media="all" />
</head>
<body>
<div class="container">
			<header>
				<h1> Update Employee Details Here</h1>
            </header> 
             <%
               DeptArray deptArray=SelectAllData.deptSellectAll();
               Dept dept[]=deptArray.getDept();
               %>        
            
            <% session.setAttribute("username",session.getAttribute("username")); %>
            <%
            Emp emp = (Emp)request.getAttribute("empObj");
            session.setAttribute("emp", emp);
            String hireDate=GetDate.getReqFormat(emp.getHiredate());
            %>
      <div  class="form" >
    		<form id="contactform" action="UpdateEmpServlet" method="post"> 
    			<p class="contact"><label for="email">Employee Name</label></p> 
    			<input id="email" name="Empname" placeholder="Enter Employee Name" required="" type="text" value="<%=emp.getEname() %>">                
		
            	<p class="contact"><label for="phone">Employee skill</label></p> 
            	<input id="phone" name="Empskill" placeholder="Enter Employee skill" required="" type="text" value="<%=emp.getEskill()%>"> <br>

				<p class="contact"><label for="email">Employee Designation</label></p> 
    			<input id="email" name="Empprojectdesc" placeholder="Enter Employee Designation" required="" type="text" value="<%=emp.getEpdesc() %>"> 
                		
            	<p class="contact"><label for="phone">Joindate</label></p> 
            	<input id="phone" name="hiredate" placeholder="Enter JoinDate" required="" type="date" value="<%=hireDate%>"> <br>
                
                <p class="contact"><label for="email">Manager Name</label></p> 
    			<input id="email" name="Managername" placeholder="Enter Manager Name" required="" type="text" value="<%=emp.getMname() %>"> 
                		
            	 <p class="contact"><label for="phone">Dept No</label></p> 
            	<!--<input id="phone" name="Deptno" placeholder="Enter Dept No" required="" type="text" value="<%=emp.getDno()%>"> <br>-->
            	
            	<select name="Deptno">
  	 			<%
  	 				for(int i=0;i<dept.length;i++) {
  	 					
  	 					if(dept[i].getDeptNo().equalsIgnoreCase(emp.getDno()))
  	    				{
  	    					%>
  	        				<option value="<%=dept[i].getDeptNo() %>" selected="selected"><%=dept[i].getDeptName() %></option>   	  	

  	    			<%	}
  	 			%>
    				<option value="<%=dept[i].getDeptNo()%>"><%=dept[i].getDeptName()%></option>   	  	
    			<%
    				}
    			%>
            	</select>
            	<p class="contact"><label for="phone">UserId</label></p> 
            	<input id="phone" name="UserId" placeholder="Enter UserId" required="" type="text" value="<%=emp.getUid()%>"> <br>
                
                
                <p class="contact"><label for="phone">Password</label></p> 
            	<input id="phone" name="Password" placeholder="Enter Password" required="" type="text" value="<%=emp.getPswd()%>"> <br>
                
                
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
