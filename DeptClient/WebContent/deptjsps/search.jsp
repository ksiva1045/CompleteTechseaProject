<!DOCTYPE html>
<html>
<head>
<title>dept</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" conte
	nt="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="search1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
    <link rel="stylesheet" type="text/css" media="all" href="deptjsps/searchstyle.css">
    
    
 

    
   
</head>
<body>




<%@ page import="com.table.operations.TableOperationsStub.Dept"%>
<%@ page import ="com.table.operations.TableOperationsStub.DeptArray"%>
<div align="right" style="margin-top: 20px;margin-right: 40px;">

<a style="color:purple; font-family: fantasy;font-size: 25px;font-style: normal;font-weight:100;" href="AddOrSearch.jsp">HOME</a>

</div>
<div >
	<!--/ freshdesignweb top bar -->
			       
		<div  class="form" >
    		<form id="add" action="../SelectAllDeptServlet"> 			
				<input class="add" name="add"id="dialog_trigger" value="SearchAll" type="submit"> 	 	 
			</form> 
			<form id="search"  method="post" > 			
				<input class="search" name="search" id="search" value="Search by Name" type="submit"> 	 
			<input type="hidden" value="searchbyname" name="searchVal">
			</form> 
		</div>      
</div>











<% session.setAttribute("username",session.getAttribute("username")); %>

<%

if(request.getParameter("searchVal")!=null){
	%>
<script type="text/javascript">
$(document).ready(function(){
	
	
	
	
});

</script> 
	<jsp:include page="/SelectDeptNamesServlet"></jsp:include>
	
	<%
}

%>


</script>














</body>
</html>
