package jdbc.dao;

import java.util.List;

import jdbc.pojo.Comment;

public interface CommentDAO {
	int insert (Comment comment);
	
	List<Comment> list(Integer id);
}
