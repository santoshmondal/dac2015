package in.dac;

public class Employee {

	private String name;
	private String empid;
	private String companyname;
	private String city;
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String username;
	private String password;
	
	
	
	
	
	
	public Employee(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Employee(String name, String empid, String companyname, String city,
			int id, String fname, String lname, String email) {
		super();
		this.name = name;
		this.empid = empid;
		this.companyname = companyname;
		this.city = city;
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	
	
}
