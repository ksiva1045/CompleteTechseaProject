<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="../InvoiceUpdateServlet" method="get">
  Enter InvoiceId:<input type="text" name="INVOICE_ID">
  Enter OrderId:<input type="text" name="ORDER_ID">
  Enter InvoiceStatusCode:<input type="text" name="INVOICE_STATUS_CODE">
  Enter InvoiceDate:<input type="date" name="INVOICE_DATE">
  Enter InvoiceDetails:<input type="text" name="INVOICE_DETAILS">
  <input type="submit" value="update">
</form>
</body>
</html>