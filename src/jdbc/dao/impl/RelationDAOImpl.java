package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.dao.RelationDAO;
import jdbc.pojo.Relation;
import jdbc.util.JdbcUtils;

public class RelationDAOImpl implements RelationDAO {

	@Override
	public int insert(Relation relation) {
		String sql = "insert into relation (memberName) values(?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, relation.getMember());
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
	public int update(Relation relation) {
		String sql = "update relation set friend = ?, request = ? where memberName = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, relation.getFriends());
			ps.setString(2, relation.getRequest());
			ps.setString(3, relation.getMember());
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
	public Relation listByMember(String memberName) {
		String sql = "select * from relation where memberName = ?";
		Relation relation = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberName);
			rs = ps.executeQuery();
			if(rs.next()) {
				String friends = rs.getString("friend");
				String request = rs.getString("request");
				relation = new Relation(memberName, friends, request);
			}
			return relation;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

}
