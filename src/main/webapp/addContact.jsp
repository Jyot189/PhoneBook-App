<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addContact</title>
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
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Add Contact Page</h4>
						<form action="addConatct" method="post">
						<% 
							String error=(String)request.getAttribute("error");
							if(error!=null){
								%>
								<p class="text-center text-danger"><%= error %></p>
							<%}
						%>
						
							  <div class="form-group">
							    <label for="exampleInputEmail1">Enter Name</label>
							    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" required>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Email address</label>
							    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Enter Phone No</label>
							    <input type="tel" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="phoneno" required>
							  </div>
							  <div class="form-group">
							    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter about" name="comments">
							  </div>
							  <div class="text-center mt-2">
								  <button type="submit" class="btn btn-primary ">Save Contact</button>
							  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>