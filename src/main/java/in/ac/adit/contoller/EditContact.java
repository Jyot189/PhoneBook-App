package in.ac.adit.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.dao.UserDao;
import in.ac.adit.model.UserContact;

public class EditContact extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) {
		long e_id = Long.parseLong(request.getParameter("cid_e"));		
		UserContact updateContact=new UserContact();
		updateContact.setId(e_id);
		updateContact.setName(request.getParameter("name"));
		updateContact.setEmail(request.getParameter("email"));
		updateContact.setPhoneno(request.getParameter("phoneno"));
		updateContact.setComments(request.getParameter("comments"));
		
		UserDao useupdate=new UserDao();
		boolean isUpdate=useupdate.updateContact(updateContact);
		if(isUpdate) {
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
		}
	}

}
