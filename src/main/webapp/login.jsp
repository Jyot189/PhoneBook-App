<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="component/allCss.jsp" %>
</head>
<body style="background-color: #f7faf8;">
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Login Page</h4>
						<form action="login" method="post">
						<%
							String error=(String)request.getAttribute("error");
							if(error!=null){
								%>
								<p class="text-center text-danger"><%= error %></p>
							<%}
						%>
						<%
							String errormsg=(String)request.getAttribute("errormsg");
							if(errormsg!=null){
								%>
								<p class="text-center text-success"><%= errormsg %></p>
							<%}
						%>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Email address</label>
							    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">Password</label>
							    <input type="password" class="form-control" id="exampleInputPassword1" name="password" required>
							  </div>
							  <div class="text-center mt-2">
								  <button type="submit" class="btn btn-primary">Login</button>
							  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<div style="margin-top: 300px;">
<%@include file="component/footer.jsp" %>
</div>
</body>
</html>