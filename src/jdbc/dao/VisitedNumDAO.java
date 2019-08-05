package jdbc.dao;

import java.util.List;

import jdbc.pojo.VisitedNum;

public interface VisitedNumDAO {
	int insert(VisitedNum obj);
	
	int update(VisitedNum obj);
	
	VisitedNum listByCategory(String category);
	
	List<VisitedNum> list();
}
