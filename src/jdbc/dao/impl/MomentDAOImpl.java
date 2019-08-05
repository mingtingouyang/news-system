package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

import jdbc.dao.MomentDAO;
import jdbc.pojo.Moment;
import jdbc.util.JdbcUtils;

public class MomentDAOImpl implements MomentDAO {

	@Override
	public int insert(Moment moment) {
		String sql = "insert into moment (author, content, time, authorimg) values(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, moment.getAuthor());
			ps.setString(2, moment.getContent());
			ps.setString(3, moment.getTime());
			ps.setString(4, moment.getAuthorimg());
			int row = ps.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, null);
		}
		return 0;
	}

	@Override
	public List<Moment> listByAuthor(JSONArray members) {
		String sql = "select * from moment where";  
		for(int i = 0; i < members.size(); i++) {
			if(i == 0) {
				sql += " author = '" + members.get(i) + "'";
			}else {
				sql += " or author = '" + members.get(i) + "'";
			}
		}
		sql += " order by time";
		
		List<Moment> moments = new ArrayList<Moment>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				String author = rs.getString("author");
				String content = rs.getString("content");
				String time = rs.getString("time");
				String authorimg = rs.getString("authorimg");
				moments.add(new Moment(author, content, time, authorimg));
			}
			return moments;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

}
