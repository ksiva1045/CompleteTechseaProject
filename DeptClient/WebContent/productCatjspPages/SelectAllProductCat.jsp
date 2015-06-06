<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="productCatjspPages/jquery.js"></script>

<script type="text/javascript">


</script>


<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/ProductCatClient/productCatjspPages/Select.jsp");
		
	});
		
});

</script>
<body background="productCatjspPages/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import="com.table.operations.TableOperationsStub.ProductCat"%>
<%@ page import="com.table.operations.TableOperationsStub.ProductCatStatic"%>


<%
ProductCat[] productCat =(ProductCat[]) request.getAttribute("productCatAll");
ProductCatStatic[] productcatstatic =(ProductCatStatic[]) request.getAttribute("productCatStaticAll");

if((productCat.length+productcatstatic.length)>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteProductCatServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of ProductCat Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <%--   <th>DeptNo</th>   --%>
                <th>PROD_CATAGORY_NAME</th>
                <th>PROD_CATAGORY_DETAILS</th>
                <th>PRODUCT_PARENT_NAME</th>
                
                				<%-- <th>PRODUCT_QUALITY1</th>
                                  <th>PRODUCT_QUALITY2</th>
                                  <th>PRODUCT_QUALITY3</th>
                                  <th>PRODUCT_QUALITY4</th>
                                  <th>PRODUCT_QUALITY5</th>
                                  <th>PRODUCT_QUALITY6</th>
                                  <th>PRODUCT_QUALITY7</th>
                                  <th>PRODUCT_QUALITY8</th>
                                  <th>PRODUCT_QUALITY9</th>
                                  <th>PRODUCT_QUALITY10</th>
                                 --%>
        
            <% 

	
	for(int i=0;i<productcatstatic.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=productCat[i].getId()%>" /></td>  
                <!--  <td><a href="SelectServlet?id=<%=productCat[i].getId()%>&hidd=get"><%=productCat[i].getId() %>    -->
                    <td><a href="SelectServlet?id=<%=productCat[i].getId()%>&hidd=get"><%= productCat[i].getPname()%></td>
                    <td><%= productCat[i].getPdetails()%></td>
						<% 
						
						if(productCat[i].getProd_parent_id().equals("NULL")){ %>
							<td>---</td> 
					 <% } 
						else{ 
						
							for(int j=0;j<productcatstatic.length;j++){  
						
								if(productCat[i].getProd_parent_id().equalsIgnoreCase(productCat[j].getId())){ %>
									<td><%= productCat[j].getPname()%></td>  
							  <% }
							}
						}	%>
 					  <%--	<td><%= productCat[i].getProd_parent_id()%></td>                    
                  
                    
                    <td><%= productcatstatic[i].getProductquality1()%></td>
                    <td><%= productcatstatic[i].getProductquality2()%></td>
                    <td><%= productcatstatic[i].getProductquality3()%></td>
                    <td><%= productcatstatic[i].getProductquality4()%></td>
                    <td><%= productcatstatic[i].getProductquality5()%></td>
                    <td><%= productcatstatic[i].getProductquality6()%></td>
                    <td><%= productcatstatic[i].getProductquality7()%></td>
                    <td><%= productcatstatic[i].getProductquality8()%></td>
                    <td><%= productcatstatic[i].getProductquality9()%></td>
                    <td><%= productcatstatic[i].getProductquality10()%></td>
                    
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
 


       
            <%}%>
            
            
            
           
		 <script type="text/javascript">
$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/productCatjspPages/AddOrSearch.jsp");
		<%--window.location.replace("/ProductCatWebClient/SelectAllProduct_Catagiries.jsp");
		--%>
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