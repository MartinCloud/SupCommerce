<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<%@ page import="com.supinfo.supcommerce.entity.Product" %>
<%@ page import="com.supinfo.supcommerce.entity.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Products</title>
	</head>
	
	<body>
	  <% 
		  String pName = (String) request.getAttribute("productName");
	      String cName = (String) request.getAttribute("categoryName");
	      
	  %>
	  <%= "Product Name: " + pName %><br />
	  <%= "Category Name: " + cName %><br />
	</body>
</html>