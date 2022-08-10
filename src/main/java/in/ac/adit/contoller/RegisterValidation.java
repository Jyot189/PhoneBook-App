package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.dao.UserDao;
import in.ac.adit.model.User;

public class RegisterValidation extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		User userRegister=new User();
		userRegister.setFullname(request.getParameter("fullname"));
		userRegister.setEmail(request.getParameter("email"));
		userRegister.setPassword(request.getParameter("password"));
		userRegister.setCpassword(request.getParameter("cpassword"));
		
		
		if(userRegister.getPassword().equals(userRegister.getCpassword())) {
			UserDao userDaoRegister=new UserDao();
			boolean isValidateUser=userDaoRegister.register(userRegister);
			if(isValidateUser) {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				try {
					rd.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				try {
					rd.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			request.setAttribute("error","invalid name | password");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			try {
				rd.forward(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
