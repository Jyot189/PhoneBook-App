<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.ac.adit.dao.UserDao" %>
<%@page import="in.ac.adit.model.UserContact" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<%
		if(checkValidUser==null)
		{
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container mt-2">
		<div class="row p-2">
			
				<%
					UserDao viewContact=new UserDao();
					List<UserContact> contact=viewContact.getAllContact();
					
					for(UserContact c:contact ){									
				%>	
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<h5>Name:<%= c.getName()%></h5>
						<h5>Ph no:<%= c.getPhoneno()%></h5>
						<h5>Email:<%= c.getEmail()%></h5>
						<h5>About:<%= c.getComments()%></h5>
						<div>
							<a class="btn btn-success">Edit</a>
							<a class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>
				</div>
				<%} %>
			</div>
	
  </div>
</body>
</html>