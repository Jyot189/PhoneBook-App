package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;

import in.ac.adit.dao.UserDao;
import in.ac.adit.model.UserContact;

public class AddContactValidation extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		String phoneno=request.getParameter("phoneno");
		boolean isValidateUserContact=false;
		
		UserContact userContact=new UserContact();
		userContact.setName(request.getParameter("name"));
		userContact.setEmail(request.getParameter("email"));
		userContact.setPhoneno(phoneno);
		userContact.setComments(request.getParameter("comments"));
		
		
		//userid
		HttpSession session = request.getSession();
		int id=(int)session.getAttribute("id");
		//int id=Integer.parseInt(sid);
		UserDao userDaoSaveContact=new UserDao();
		boolean isExit=userDaoSaveContact.isOneIdContact(id,phoneno);
		if((phoneno.length()==10)&& (isExit)) {
			isValidateUserContact=userDaoSaveContact.saveContact(userContact,id);
			
		}else {
			request.setAttribute("error","Phone no is not valid");
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
		if(isValidateUserContact){
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
