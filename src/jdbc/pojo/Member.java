package jdbc.pojo;

public class Member {
	private Integer id;
	private String username;
	private String password;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private String time;
	private String userimg;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Member(Integer id, String username, String password, String gender, String phone, String email,
			String address, String time, String userimg, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.time = time;
		this.userimg = userimg;
		this.status = status;
	}
	public Member() {
		super();
	}
	public Member(String username, String password, String time) {
		super();
		this.username = username;
		this.password = password;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + "]";
	}
	
	
}
