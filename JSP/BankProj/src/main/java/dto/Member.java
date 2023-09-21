package dto;

public class Member {
	private String id;
	private String name;
	private String password;
	private String email;
	private String address;
	
	
	public Member() {}
	public Member(String id, String name, String password, String email, String address) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
