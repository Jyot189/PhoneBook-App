package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.adit.dao.UserDao;
import in.ac.adit.model.User;

public class LoginValidation extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		User userLogin=new User();
		userLogin.setEmail(request.getParameter("email"));
		userLogin.setPassword(request.getParameter("password"));
		UserDao userDaoLogin=new UserDao();
		
		boolean isValidateUser=userDaoLogin.login(userLogin);
		String fullname=userDaoLogin.loginUser(userLogin);
		int id=userDaoLogin.userId(userLogin);
		//System.out.println(id);
		if(isValidateUser) {
			HttpSession sessionLogin=request.getSession();
			sessionLogin.setAttribute("checkValidUser","valid");
			sessionLogin.setAttribute("fullname", fullname);
			sessionLogin.setAttribute("id", id);
			RequestDispatcher rd=request.getRequestDispatcher("addContact.jsp");
			System.out.println("valid");
			
			//user
			
			
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("error","invalid email | password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			System.out.println("invalid");
			try {
				rd.forward(request, response);
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
