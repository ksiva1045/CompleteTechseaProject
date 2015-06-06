<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="Couponjsps/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/Couponjsps/SearchCoupon.jsp");
		
	});
		
});

</script>
<body background="Couponjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.Coupon"%>

<%
Coupon[] coupon =(Coupon[]) request.getAttribute("couponAll");
if(coupon.length>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteCouponServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of Coupon Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
                 
                <th>Coupon Name</th>
                <th>Coupon Code</th>
                <th> Coupon Details</th>
                <th>Seller ID</th>
                <th>Issue Date</th>
                <th>Expire Date</th>
            <% 

	
	for(int i=0;i<coupon.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=coupon[i].getCouponId()%>" /></td>  
                <%--<td><a href="SelectDealServlet?id=<%=deal[i].getDealId()%>&hidd=get"><%=deal[i].getDealId()%> --%>
                    <td><a href="SelectCouponServlet?id=<%=coupon[i].getCouponId()%>&hidd=get"><%= coupon[i].getCouponName()%></td>
                    <td><%= coupon[i].getCouponCode()%></td>
                    <td><%= coupon[i].getCouponDetails()%></td>
                    <td><%= coupon[i].getSellerId()%></td>
                    <td><%= coupon[i].getIssueDate()%></td>
                    <td><%= coupon[i].getExpireDate()%></td>
                    </a></td>
                </tr>
                <% 
	
}
            %>
            </div>
            </table>
            <div align="center">
            <br>
                <input type="submit" class="styled-button" value="Delete" onClick="autoRefresh()">&nbsp&nbsp&nbsp&nbsp&nbsp
         
    <input type="button" value="Cancel" id="cancel">
            </div>
            </form>
            </body>
          
         
         <% session.setAttribute("username",session.getAttribute("username")); %>
         
            <%
            
            if(request.getParameter("hid")!=null){
            
            %>
         <!-- 
           	<script type="text/javascript">
			$(document).ready(function(){
				
				if($('#hid').val()=="hidden1"){
					$('#hid').val(null);
					//window.location.replace("/DeptClient/SelectAllDeptServlet");
					
				}
					
			});

            </script>
               -->
    
       <!-- 
            <script type="text/javascript">
		$(document).ready(function(){
				
				if($('#hid').val()=="hidden1"){
					//alert("hai");
					//window.location.replace("http://www.google.com");
					
					window.location.replace("/DeptClient/SelectAllDeptServlet");
					
				}
			
             			
			});
		</script>
		 -->
		<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/Couponjsps/AddOrSearchCoupon.jsp");
		
	});
		
});

</script>
          
            <%
            
            
            }
           

}
else{
%>
<br>
<br>
<center><h1> NO RECORDS WERE FOUND </h1></center>

<%} %>





</body>
</html>