package in.ac.adit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ac.adit.model.User;
import in.ac.adit.model.UserContact;

public class UserDao {
		final static String URL="jdbc:mysql://localhost:3306/phonebook_db";
		final static String USERNAME="root";
		final static String PASSWORD="";
		private Connection connection=null;
		private PreparedStatement pstmt=null;
		public UserDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public boolean register(User userRegister) {
			try {
				pstmt=connection.prepareStatement("insert into register (fullname,email,password,cpassword) values(?,?,?,?)");
				pstmt.setString(1,userRegister.getFullname());
				pstmt.setString(2,userRegister.getEmail());
				pstmt.setString(3,userRegister.getPassword());
				pstmt.setString(4,userRegister.getCpassword());
				pstmt.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		
		public boolean login(User userLogin) {
				try {
					pstmt=connection.prepareStatement("select email,password from register where email=? AND password=?");
					pstmt.setString(1,userLogin.getEmail());
					pstmt.setString(2,userLogin.getPassword());
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						return true;
					}
					return false;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			
		}
		
		public boolean saveContact(UserContact userContact) {
			try {
				pstmt=connection.prepareStatement("insert into addcontact (name,email,phoneno,comments) values(?,?,?,?)");
				pstmt.setString(1,userContact.getName());
				pstmt.setString(2,userContact.getEmail());
				pstmt.setString(3,userContact.getPhoneno());
				pstmt.setString(4,userContact.getComments());
				pstmt.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public String loginUser(User userloginuser) {
			try {
				pstmt=connection.prepareStatement("select fullname from register where email=? AND password=?");
				pstmt.setString(1,userloginuser.getEmail());
				pstmt.setString(2,userloginuser.getPassword());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		}
				
		public List<UserContact> getAllContact(){
			List<UserContact> list=new ArrayList<UserContact>();
			UserContact contact=null;
			
			try {
				pstmt=connection.prepareStatement("select name,email,phoneno,comments from addcontact");
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					contact=new UserContact();
					contact.setName(rs.getString(1));
					contact.setEmail(rs.getString(2));
					contact.setPhoneno(rs.getString(3));
					contact.setComments(rs.getString(4));
					list.add(contact);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		
	}


