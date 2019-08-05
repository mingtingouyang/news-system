package jdbc.dao;

import java.util.List;

import jdbc.pojo.Article;

public interface ArticleDAO {
	int insert(Article article);
	
	int delete(int id);
	
	int update(Article article);
	
	Article listById(int id);
	
	List<Article> list();
	
	List<Article> search(String sign);
	
	List<Article> top(int index);
	
	List<Article> listCategory(String type);
}
