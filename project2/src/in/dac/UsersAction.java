package in.dac;

import java.util.List;

import in.dac.database.UsersDbController;

import com.opensymphony.xwork2.ActionSupport;

/**
 * DO STUDY!@!!
 * https://struts.apache.org/docs/tag-reference.html
 * @author santoshm
 *
 */
public class UsersAction extends ActionSupport{
	
	private User user;
	private List<User> usersList;
	
	// to generate form
	public String createUserPage() {
		return SUCCESS;
	}
	
	// to create user
	public String createUser() {
		String sReturn = SUCCESS;
		if(user != null) {
			
			// time for db operation
			if(user.getOpr().equalsIgnoreCase("UPDATE")) {
				// UsersDbController.updateUser(user);
			} else {
				UsersDbController.createUser(user);
			}
			
			// after insert read users
			usersList = UsersDbController.readAllUser();
			
		} else {
			sReturn = "failure";
		}
		
		return sReturn;
	}
	
	public String editUser() {
		return SUCCESS;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

}
