package jdbc.pojo;

public class Relation {
	private String member;
	private String friends;
	private String request;
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getFriends() {
		return friends;
	}
	public void setFriends(String friends) {
		this.friends = friends;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Relation(String member, String friends, String request) {
		super();
		this.member = member;
		this.friends = friends;
		this.request = request;
	}
	public Relation() {
		super();
	}
	
	
}
