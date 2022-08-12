<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editContact</title>
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<h1>edit</h1>
	<%
	int cid_e=Integer.parseInt(request.getParameter("cid_e"));
	out.println(cid_e);
	%>
</body>
</html>