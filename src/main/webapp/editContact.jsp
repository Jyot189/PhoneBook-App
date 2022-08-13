<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.ac.adit.dao.UserDao" %>
<%@page import="in.ac.adit.model.UserContact" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editContact</title>
<%@include file="component/allCss.jsp" %>
</head>
<body>
	<%@include file="component/navbar.jsp" %>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Add Contact Page</h4>
						<form action="update" method="post">
						
							<%
							int cid_e=Integer.parseInt(request.getParameter("cid_e"));
							UserDao userDetail=new UserDao();
							UserContact userdeatil=userDetail.getDeatilById(cid_e);
							//out.println(cid_e);
							%>
							<input type="hidden" value="<%=cid_e%>" name="cid_e">
									<div class="form-group">
											<label for="exampleInputEmail1">Enter Name</label>
											<input value="<%=userdeatil.getName() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" required>
									</div>
									<div class="form-group">
											<label for="exampleInputEmail1">Email address</label>
											<input value="<%=userdeatil.getEmail() %>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required>
									</div>
									<div class="form-group">
											<label for="exampleInputEmail1">Enter Phone No</label>
											<input value="<%=userdeatil.getPhoneno() %>" type="tel" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="phoneno" required>
									</div>
									<div class="form-group">
											<input value="<%=userdeatil.getComments() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter about" name="comments">
									</div>
									<div class="text-center mt-2">
										<button type="submit" class="btn btn-primary ">Update Contact</button>
									</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>