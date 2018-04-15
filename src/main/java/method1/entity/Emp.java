package method1.entity;

public class Emp {
	private String id;
	private String name;
	private String password;
	public String getId() {
		System.out.println("getId()");
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", password=" + password + "]";
	}
	
}
