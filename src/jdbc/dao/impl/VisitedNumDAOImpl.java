package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.VisitedNumDAO;
import jdbc.pojo.VisitedNum;
import jdbc.util.JdbcUtils;

public class VisitedNumDAOImpl implements VisitedNumDAO {

	@Override
	public int insert(VisitedNum obj) {
		String sql = "insert into visitednum (category) values(?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, obj.getCategory());
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
	public int update(VisitedNum obj) {
		String sql = "update visitednum set num = ? where category = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getNum());
			ps.setString(2, obj.getCategory());
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
	public VisitedNum listByCategory(String category) {
		String sql = "select * from visitednum where category = ?";
		VisitedNum obj = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			rs = ps.executeQuery();
			if(rs.next()) {
				String category_tmp = rs.getString("category");
				int num = rs.getInt("num");
				obj = new VisitedNum(category_tmp, num);
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<VisitedNum> list() {
		String sql = "select * from visitednum";
		List<VisitedNum> objs = new ArrayList<VisitedNum>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer num = rs.getInt("num");
				String category = rs.getString("category");
				objs.add(new VisitedNum(category, num));
			}
			return objs;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

}
