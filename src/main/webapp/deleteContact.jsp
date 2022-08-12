<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.ac.adit.dao.UserDao" %>
<%
	int cid_d=Integer.parseInt(request.getParameter("cid_d"));
	UserDao userDelete=new UserDao();
	boolean isDelete=userDelete.deleteContact(cid_d);
	if(isDelete){
		response.sendRedirect("viewContact.jsp");
	}else{
		response.sendRedirect("view.jsp");
	}
	//out.println(cid_d);
%>