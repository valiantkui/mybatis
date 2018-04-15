package method1.entity;

/**
 * 加入实体类属性名和表的字段名不一样
 * @author KUIKUI
 *
 */
public class Emp2 {
	private String id2;
	private String name2;
	private String password2;
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	@Override
	public String toString() {
		return "Emp2 [id2=" + id2 + ", name2=" + name2 + ", password2=" + password2 + "]";
	}
	
	
}
