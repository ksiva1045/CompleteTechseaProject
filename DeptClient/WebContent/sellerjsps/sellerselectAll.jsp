<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="sellerjsps/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/sellerjsps/sellerAddOrSearch.jsp");
		
	});
		
});

</script>
<body background="sellerjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.Seller"%>

<%
Seller[] seller =(Seller[]) request.getAttribute("sellerAll");
if(seller.length>0){
%>
<body bgcolor="33ff99">
<% session.setAttribute("username",session.getAttribute("username")); %>

 <form method="post" action="DeleteSellerServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of seller Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
             <th>SellerName</th>
                <th>SellerAddress</th>
                <th>SellerType</th>
               <th>SellerPincode</th>
                  <th>SellerEmpContactNo</th>
                <th>SMarketingNo</th>
                <th>SManagerNo</th>
                  <th>SMarketingMailId</th>
                    <th>SBusinessMailId</th>
                <th>BestTimeToContact</th>
                <th>ContactFrequency</th>
              <th>SellerCatId</th>
            <% 

	
	for(int i=0;i<seller.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=seller[i].getSid()%>" /></td>  
                    <td><a href="SelectSellerServlet?id=<%=seller[i].getSid()%>&hidd=get"><%= seller[i].getSName()%></td>
                   <td><%= seller[i].getSellerAddress()%></td>
                     <td><%= seller[i].getSellerType()%></td>
                       <td><%= seller[i].getSPincode()%></td>
                     <td><%= seller[i].getSellerEmpContactNo()%></td>
                       <td><%= seller[i].getSMarketingNo()%></td>
                     <td><%= seller[i].getSManagerNo()%></td>
                       <td><%= seller[i].getSMarketingMailId()%></td>
                     <td><%= seller[i].getSBusinessMailId()%></td>
                       <td><%= seller[i].getBestTimeToContact()%></td>
                     <td><%= seller[i].getContactFrequency()%></td>
                       <td><%= seller[i].getSellerCatId()%></td>
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
		alert("ok");
		window.location.replace("/DeptClient/sellerjsps/sellerAddOrSearch.jsp");
		
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