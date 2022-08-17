package in.ac.adit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ac.adit.dao.UserDao;

public class UpdatePassword extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		String password=new String(request.getParameter("password"));
		String newPassword=new String(request.getParameter("newpassword"));
		String confirmpassword=request.getParameter("confirmpassword");
		HttpSession session=request.getSession();
		int id=(int)session.getAttribute("id");
		UserDao userdao=new UserDao();
		if(userdao.isPassword(password, id)) {
			if(newPassword.equals(confirmpassword)) {
				if(userdao.UpdatePassword(newPassword, id)) 
				{
					try {
						session.setAttribute("errorMessage1", "successful update password");
						response.sendRedirect("index.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else 
				{
					try {
						session.setAttribute("errorMessage2", "not update your password");
						response.sendRedirect("updatePassword.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else 
			{
				try {
					session.setAttribute("errorMessage2", "your newpassword and confirm password is not match");
					response.sendRedirect("updatePassword.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				session.setAttribute("errorMessage2", "your password is not exit");
				response.sendRedirect("updatePassword.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
