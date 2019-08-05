package jdbc.dao;

import java.util.List;

import jdbc.pojo.Member;

public interface MemberDAO {
	int insert(Member member);
	
	int signUp(Member member);
	
	int delete(String username);
	
	int update(Member member);
	
	Member listByUsername(String username);
	
	List<Member> list();
	
	List<Member> search(String sign);
}
