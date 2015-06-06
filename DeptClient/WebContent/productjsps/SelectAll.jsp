<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="productjsps/jquery.js"></script>

<script type="text/javascript">


</script>


<body background="productjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.ProductBean"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductSpecification"%>


<%
ProductBean[] product =(ProductBean[]) request.getAttribute("productAll");

ProductSpecification[] productspec =(ProductSpecification[]) request.getAttribute("productspecAll");


if(product.length>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="ClientServletDelete">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of Product Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
               
                <th>ProductName</th>
                 <th>TypeCode</th>
                 <th>Price</th>
                 <th>ServiceCode</th>
                 <th>CategoryType</th>
                 
             <%--   
                 <th>ProductColour</th>
                 <th>ProductSize</th>
                 <th>ProductFeatures</th>         
                 <th>ProductQuality4</th>
                 <th>ProductQuality5</th>
                 <th>ProductQuality6</th>
                 <th>ProductQuality7</th>
                 <th>ProductQuality8</th>
                 <th>ProductQuality9</th>
                 <th>ProductQuality10</th>
       
 --%>
            <% 

	
	for(int i=0;i<productspec.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=product[i].getProductId()%>" /></td>  
                <!--  <td><a href="SelectDeptServlet?id=<%=product[i].getProductId()%>&hidd=get"><%=product[i].getProductId() %>    -->
                    <td><a href="ClientProductSelectID?id=<%=product[i].getProductId()%>&hidd=get"><%= product[i].getProductName()%></td>
                      <td><%= product[i].getProductCode()%></td>
                      <td><%= product[i].getPrice()%></td>
                      <td><%= product[i].getServiceCode()%></td>
                      <td><%= product[i].getProductName()%></td>
              <%--
                      <td><%= productspec[i].getProduct_colour()%></td>
                      <td><%= productspec[i].getProduct_size()%></td>
                      <td><%= productspec[i].getProduct_features()%></td>
                      <td><%= productspec[i].getProduct_quality4()%></td>
                      <td><%= productspec[i].getProduct_quality5()%></td>
                      <td><%= productspec[i].getProduct_quality6()%></td>
                      <td><%= productspec[i].getProduct_quality7()%></td>
                      <td><%= productspec[i].getProduct_quality8()%></td>
                      <td><%= productspec[i].getProduct_quality9()%></td>
                      <td><%= productspec[i].getProduct_quality10()%></td>
                                
                         --%>    

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
            
     
   
       <%
            }
            %>
		 
		<script type="text/javascript">


$(document).ready(function()
		{
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/productjsps/AddOrSearch.jsp");
	});
		
});

</script>
          
           
   <%        

}
else{
%>
<br>
<br>
<center><h1> NO RECORDS WERE FOUND </h1></center>

<%} %>





</body>
</html>