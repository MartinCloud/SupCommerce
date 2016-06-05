<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.supinfo.sun.supcommerce.bo.SupProduct" %>
<%@ page import="com.supinfo.sun.supcommerce.doa.SupProductDao" %>
<%@ page import="java.util.List" %>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show All Products</title>
	</head>
	
	<body>
	    
		<c:forEach items="${productList}" var="item">
		
			   <c:out value="${item.name}"/>
			  	
			   <a href="./auth/removeProduct?id=${item.id}">remove</a> <br />
			   
		</c:forEach>
	</body>
</html>