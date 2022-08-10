package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.dao.UserDao;
import in.ac.adit.model.UserContact;

public class AddContactValidation extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		UserContact userContact=new UserContact();
		userContact.setName(request.getParameter("name"));
		userContact.setEmail(request.getParameter("email"));
		userContact.setPhoneno(request.getParameter("phoneno"));
		userContact.setComments(request.getParameter("comments"));
		
		UserDao userDaoSaveContact=new UserDao();
		boolean isValidateUserContact=userDaoSaveContact.saveContact(userContact);
		if(isValidateUserContact) {
			RequestDispatcher rd=request.getRequestDispatcher("viewContact.jsp");
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
			request.setAttribute("error","invalid name | email | phoneno");
			RequestDispatcher rd=request.getRequestDispatcher("addContact.jsp");
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
