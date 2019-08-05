package jdbc.dao;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

import jdbc.pojo.Moment;

public interface MomentDAO {
	int insert (Moment moment);
	
	List<Moment> listByAuthor (JSONArray members);
}
