package in.dac;

public class HelloSturts {
	private String username;
	private String password;
	private String msg;

	public String sayHi() {
		msg = "Hello Struts";
		
		
		return "SUCCESS";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
