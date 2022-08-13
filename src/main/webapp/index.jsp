<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook-App</title>
<%@include file="component/allCss.jsp" %>
<style type="text/css">
.back-img{
	background: url("img/phonebook.jpg");
	width:100%;
	height:80vh;
	background-repeat: no-repeat;
	background-position: fix;
	background-size: cover;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid back-img text-center text-success">
	<h1 class="mt-2">Welcome to PhoneBook-App</h1>
	</div>
	<%@include file="component/footer.jsp" %>
</body>
</html>