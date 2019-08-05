package jdbc.pojo;

public class VisitedNum {
	private String category;
	private Integer num;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public VisitedNum(String category, Integer num) {
		super();
		this.category = category;
		this.num = num;
	}
	public VisitedNum() {
		super();
	}
	
	
}
