package jdbc.pojo;

public class Article {
	private Integer id;
	private String title;
	private String author;
	private String content;
	private String img;
	private String time;
	private String status;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static Article newArticle() {
		Article article = new Article();
		article.setAuthor("");
		article.setContent("");
		article.setImg("default.png");
		article.setTitle("");
		article.setCategory("");
		return article;
	}
	public Article(Integer id, String title, String author, String category, String content, String img, String time, String status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.content = content;
		this.img = img;
		this.time = time;
		this.status = status;
	}
	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [title=" + title + "]";
	}
	
	
}
