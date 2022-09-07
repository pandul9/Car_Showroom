package application;

public class Employee {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Employee(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
