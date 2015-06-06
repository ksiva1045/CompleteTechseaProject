<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="SellerProductJsps/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/SellerProductJsps/AddOrSearchDeal.jsp");
		
	});
		
});

</script>
<body background="dealjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.SellerProduct"%>

<%
SellerProduct[] sellerProduct =(SellerProduct[]) request.getAttribute("sellerProductAll");
if(sellerProduct.length>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteProductSellerServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of SellerProduct Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
                <th>Product Name</th>
                <th>Seller Name</th>
                <th>Product_Seller Price </th>

            <% 

	
	for(int i=0;i<sellerProduct.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=sellerProduct[i].getPsid() %>" /></td>  
                <%--<td><a href="SelectDealServlet?id=<%=deal[i].getDealId()%>&hidd=get"><%=deal[i].getDealId()%> 
                    <td><a href="SelectDealServlet?id=<%=deal[i].getDealId()%>&hidd=get"><%= sellerProduct[i].getDealName()%></td>--%>
                    <td><a href="SearchSellerProductServlet?id=<%=sellerProduct[i].getPsid()%>&hidd=get"><%= sellerProduct[i].getPid() %></td>
                    <td><%= sellerProduct[i].getSid() %></td>
                    <td><%= sellerProduct[i].getPsprice() %></td>
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
          
         <% session.setAttribute("toPage","update"); %>
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
		window.location.replace("/Seller_Product_Client/SellerProductJsps/SearchSellerProduct.jsp");
		
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