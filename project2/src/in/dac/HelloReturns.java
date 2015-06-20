package in.dac;

import java.util.ArrayList;
import java.util.List;

public class HelloReturns {
	
	private User user;
	private List<User> userlist;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// ACTION BEGINS HERE
	public String createUser() {
		if(user == null) {
			user = new User();
		}
		
		
		user.setMsg("CREATE USER!!");
		
		return "SUCCESS";
	}
	
	public String selectAllUser() {
		userlist = new ArrayList<User>();
		for(int i=0; i<10; i++) {
			User user = new User();
			user.setUsername("ABCD " + i);
			user.setEmail("ABCD@ABCD.in " + i);
			
			userlist.add(user);
		}
		
		return "SUCCESS";
	}
	

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	

}
