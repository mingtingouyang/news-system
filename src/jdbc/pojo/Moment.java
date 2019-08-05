package jdbc.pojo;

public class Moment {
	private String author;
	private String content;
	private String time;
	private String authorimg;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Moment(String author, String content, String time, String authorimg) {
		super();
		this.author = author;
		this.content = content;
		this.time = time;
		this.authorimg = authorimg;
	}
	public String getAuthorimg() {
		return authorimg;
	}
	public void setAuthorimg(String authorimg) {
		this.authorimg = authorimg;
	}
	public Moment() {
		super();
	}
	
}
