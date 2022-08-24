package in.ac.adit.dao;

import java.util.List;

import in.ac.adit.model.User;
import in.ac.adit.model.UserContact;

public interface UserDaoInterface {
	public boolean register(User userRegister);
	public boolean login(User userLogin);
	public boolean saveContact(UserContact userContact,int id);
	public String loginUser(User userloginuser);
	public int userId(User userid);
	public List<UserContact> getAllContact(int id);
	public UserContact getDeatilById(int get_id);
	public boolean updateContact(UserContact updateContact);
	public boolean deleteContact(int cid_d);
	public boolean isPassword(String password,int id);
	public boolean UpdatePassword(String newpassword,int id);
}
