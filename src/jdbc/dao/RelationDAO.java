package jdbc.dao;

import jdbc.pojo.Relation;

public interface RelationDAO {
	int insert(Relation relation);
	
	int update(Relation relation);
	
	Relation listByMember(String memberName);
}
