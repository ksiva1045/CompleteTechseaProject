<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


#navigationdiv {
    
    color:white;
    text-align:center;
    border-color:red;
    border:2px;
	width:15%;
	height:650px;
	float:left;
}


#contentdiv {
    
    color:white;
    text-align:center;
   
	width:85%;
	height:650px;
	float:left;
}

.styled-button {
	width:180px;
	 text-align:center;
	-webkit-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	-moz-box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	box-shadow:rgba(0,0,0,0.2) 0 1px 0 0;
	color:#333;
	background-color:#ccccff;
	border-radius:5px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	border:none;
	font-family:'Helvetica Neue',Arial,sans-serif;
	font-size:16px;
	font-weight:700;
	height:32px;
	padding:4px 16px;
	text-shadow:#FE6 0 1px 0
	
}

</style>

<%

String username =(String) session.getAttribute("userName");
System.out.print(username);
session.setAttribute("username", username);
%>


<script type="text/javascript" src="/DeptClient/deptjsps/jquery.js" ></script>
<script type="text/javascript">

$(document).ready(function(){
	$('#seller').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href = '/DeptClient/sellerjsps/sellerAddOrSearch.jsp';
		

	
	});
	
	
	
});
$(document).ready(function(){
	$('#department').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href = '/DeptClient/deptjsps/AddOrSearch.jsp';

	
	});
	
	
	
});

$(document).ready(function(){
	$('#deals').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/dealjsps/AddOrSearchDeal.jsp" ;

	
	});
	
	
	
});

$(document).ready(function(){
	$('#product_cat').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/productCatjspPages/AddOrSearch.jsp" ;

	
	});
	
	
	
});


$(document).ready(function(){
	$('#employee').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/empjsps/AddOrSearchEmp.jsp" ;

	
	});
	
	
	
});


$(document).ready(function(){
	$('#products').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/productjsps/AddOrSearch.jsp" ;

	
	});
	
	
	
});


$(document).ready(function(){
	$('#customer').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/customerjsps/AddOrSearch.jsp" ;

	
	});
	
	
	
});



$(document).ready(function(){
	$('#coupons').click(function(){
		//alert('ok');
		$("#content").get(0).contentWindow.location.href ="/DeptClient/Couponjsps/AddOrSearchCoupon.jsp" ;

	
	});
	
	
	
});
</script>


</head>


<body bgcolor="#E0F8F1">


<iframe src="/DeptClient/deptjsps/header.html" id="header" width="100%" height="80"  scrolling="no"></iframe>

<div id="navigationdiv">
<ul>
<li><input type="button" id="employee" class="styled-button" value="Employee"/></li><br>
<li><input type="button" id="seller" class="styled-button" value="Seller"/></li><br>
<li><input type="button" id="department" class="styled-button" value="Departments"/></li><br>
<li><input type="button" id="products" class="styled-button" value="Products"/></li><br>
<li><input type="button" id="product_cat" class="styled-button" value="ProductsCategories"/></li><br>
<li><input type="button" id="deals" class="styled-button" value="Deals"/></li><br>
<li><input type="button" id="customer" class="styled-button" value="Customer"/></li><br>
<li><input type="button" id="coupons" class="styled-button" value="Coupons"/></li><br>

</ul>
</div>

<div id="contentdiv">
<iframe id ="content" width="100%" height="650">
</iframe>

</div>






<iframe id="header" width="100%" height="40" src="/DeptClient/deptjsps/footer.html" scrolling="no"></iframe>



</body>
</html>