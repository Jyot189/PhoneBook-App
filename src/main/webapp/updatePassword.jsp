<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updatePassword</title>
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">UpdatePassword Page</h4>
					<form action="updatePassword" method="post">					
						<% String errormessage=(String)session.getAttribute("errorMessage2"); %>
						<%
							if(errormessage!=null){%>
								<p class="text-center text-danger"><%= errormessage %></p>
							<%}
						%>
						
							  <div class="form-group">
							    <label for="exampleInputPassword1">Password</label>
							    <input type="password" class="form-control" id="exampleInputPassword1" name="password" required>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">New Password</label>
							    <input type="password" class="form-control" id="exampleInputPassword1" name="newpassword" required>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">Confirm Password</label>
							    <input type="password" class="form-control" id="exampleInputPassword1" name="confirmpassword" required>
							  </div>
							  <div class="text-center mt-2">
								  <button type="submit" class="btn btn-primary">ResetPassword</button>
							  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>