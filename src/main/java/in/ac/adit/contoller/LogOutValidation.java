package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutValidation extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("checkValidUser");
		session.removeAttribute("fullname");
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
