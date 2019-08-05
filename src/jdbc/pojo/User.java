package jdbc.pojo;

public class User {
	private String username;
	private String password;
	private String phone;
	private String gender;
	private String permission;
	private String userimg;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
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
	
	public User(String username, String password, String phone, String gender, String permission, String userimg,
			Integer id) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.permission = permission;
		this.userimg = userimg;
		this.id = id;
	}
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", gender=" + gender
				+ ", permission=" + permission + ", userimg=" + userimg + "]";
	}	
}
