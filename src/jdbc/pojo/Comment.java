package jdbc.pojo;

public class Comment {
	private String username;
	private String content;
	private Integer articleid;
	private String userimg;
	private String time;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Comment(String username, String content, Integer articleid, String userimg, String time) {
		super();
		this.username = username;
		this.content = content;
		this.articleid = articleid;
		this.userimg = userimg;
		this.time = time;
	}
	public Comment() {
		super();
	}
	
	
}
