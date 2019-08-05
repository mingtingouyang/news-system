package jdbc.dao;

import java.util.List;

import jdbc.pojo.User;

public interface UserDAO {
	int insert(User user);
	
	int signUp(User user);
	
	int delete(String username);
	
	int update(User user);
	
	User listByUsername(String username);
	
	List<User> list();
	
	List<User> search(String sign);
}
