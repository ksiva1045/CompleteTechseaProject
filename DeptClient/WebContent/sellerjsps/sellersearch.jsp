<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
</head>

<body background="sellerjsps/images/bgnoise_lg.png">
<% session.setAttribute("username",session.getAttribute("username")); %>
<center>
<div align="right">
<a href="sellerAddOrSearch.jsp">HOME</a>
</div>
<div class="container">
	<!--/ freshdesignweb top bar -->
			<header>
				<h1> Search Records</h1>
            </header>      
            </div>

<script type="text/javascript" src="sellerjsps/jquery.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
$('#form1').hide();
});

$(document).ready(function(){
$('#sel').click(function(){
var value = $('#sel').val();
if(value=="selectById"){
$('#form1').show();
$('#button1').hide();	

}
else{
$('#form1').hide();
	
}
//alert(value);

	
});

});


</script>
<div class="from">
<div  class="form" id="form2" >
<center>
<form style="float: center;">
 <table border="0" cellpadding="5" bordercolor="ff00ff">
 <tr>
 <td>
<select id="sel" class="select">
<option value="selectAll" onChange="Refresh(this.value)">SelectAll</option>
<option value="selectById">SelectByName</option>
</select>
</td>
<td>
<input class="buttom" name="search" id="button1" value="Search" type="submit">
<%--<input id="button1" type="submit" value="search"> --%>
</td>
<td>
<input type="hidden" value="1" name="hid1">
</td>

</tr>
</table>
</center>
</form>
</div>
 	 


<div class="form" id="form1">
<form >
<table>
<tr>
<td>
<input type="text" name="id">
</td>
<td>
<td align="center" colspan="2">
<input class="buttom" name="search" id="button2" value="Search" type="submit">
<%--<input type="submit" value="search"> --%>
</td>
</tr >
<input type="hidden" name="hid1" value="2">
</table>

</form>

</div> 
</div>
<br>
<br>
<%
if(request.getParameter("hid1")!=null)
{
	 %>
 <jsp:include page="/SelectAllSellerServlet"></jsp:include>
<%} %>
</center>           
</body>

</html>