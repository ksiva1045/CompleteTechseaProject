<%@page import="javax.management.modelmbean.RequiredModelMBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="customerjsps/jquery.js"></script>

<script type="text/javascript">


</script>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/CustomerWebClient/customerjsps/Search.jsp");
		
	});
		
});

</script>
<body background="customerjsps/images/bgnoise_lg.png">



	<%@ page import="java.util.*" %>
	
<%@ page import ="com.table.operations.TableOperationsStub.Customer"%>

<%
Customer[] customer =(Customer[]) request.getAttribute("customerAll");
if(customer.length>0){
%>
<body bgcolor="33ff99">

 <form method="post" action="DeleteCustomerServlet">
    <div align="center">
    <br><br><br><br>
        <table border="2" cellpadding="5" bordercolor="ff00ff">
        <input type="hidden" name="hid" id="hid" value="hidden1"/>
            <caption ><h1>List of Customer Records</h1></caption>
            <tr bgcolor="33ccff">
           
	           <th height="2px"></th>
              <!--   <th>DeptNo</th>   -->
                <th>Gender</th>
                <th>Firstname</th>
                <th>Middlename</th>
              	<th>Lastname</th>
                <th>EmailAddress</th>
                <th>Loginname</th>
               <th>LoginPassword</th>
                <th>Phonenumber</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>Address3</th>
                <th>Address4</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>
            <% 

	
	for(int i=0;i<customer.length;i++){
		//String id=s.getPid();
		//request.setAttribute("id",id);
		%>
		<tr bgcolor="ccff33">
                
	              <td><input type="checkbox" name="checkval" id="ck" value="<%=customer[i].getCustomerid()%>" /></td>  
                <!--  <td><a href="SelectCustomerServlet?id=<%=customer[i].getCustomerid()%>&hidd=get"><%=customer[i].getCustomerid() %>    -->
                    <td><a href="SelectCustomerServlet?id=<%=customer[i].getCustomerid()%>&hidd=get"><%= customer[i].getGender()%></td>
                    <td><%= customer[i].getFirstname()%></td>
                    <td><%= customer[i].getMiddlename()%></td>
                    <td><%= customer[i].getLastname()%></td>
                   	<td><%= customer[i].getEmail()%></td>
                 	<td><%= customer[i].getLoginname()%></td>
                 	<td><%= customer[i].getLoginpassword()%></td>
                    <td><%= customer[i].getPhonenumber()%></td>
                    <td><%= customer[i].getAdd1()%></td>
                    <td><%= customer[i].getAdd2()%></td>
                    <td><%= customer[i].getAdd3()%></td>              
                    <td><%= customer[i].getAdd4()%></td>
                    <td><%= customer[i].getCity()%></td>
                    <td><%=customer[i].getState() %></td>
                    <td><%= customer[i].getCountry()%></td>
                    <td><%= customer[i].getZipcode()%></td>
                    </a></td>
                </tr>
                <% 
	
}
            %>
            </div>
            </table>
            <div align="center">
            <br>
                <input type="submit" class="styled-button" value="Delete">&nbsp&nbsp&nbsp&nbsp&nbsp
         
    <input type="button" value="Cancel" id="cancel">
            </div>
            </form>
            </body>
          
         
         <% session.setAttribute("username",session.getAttribute("username")); %>
         
           

		
		<script type="text/javascript">


$(document).ready(function(){
	
	$('#cancel').click(function(){
		window.location.replace("/DeptClient/customerjsps/AddOrSearch.jsp");
		
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