<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./../header.jsp" %>
<%@ include file="./../footer.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="com.supinfo.supcommerce.entity.Product" %>
<%@ page import="com.supinfo.supcommerce.entity.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Product Page</title>
	</head>
	
	<body>
		<form action="/SupCommerce1/auth/addProduct" method="post">
		
		   Name:<input type="text" name="username"/>
		   Content:<input type="text" name="content"/>
		   Price:<input type="text" name="price"/>
		   Category Id: 
		   <select name="ctgid">
		 		<% List <Category> ctgList = (List <Category>) request.getAttribute("categoriesList");
		 		  for(Category ctg : ctgList){
		 		%>
		 		<option ><%= ctg.getId() %></option>
		 		<%} %>
		   </select>
		   <input type="submit" value="submit">
		   
		</form>
	</body>
</html>