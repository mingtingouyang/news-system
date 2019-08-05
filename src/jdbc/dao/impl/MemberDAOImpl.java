package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.MemberDAO;
import jdbc.pojo.Member;
import jdbc.util.JdbcUtils;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insert(Member member) {
		String sql = "insert into `member` (username, password, gender, phone, email, address, time, userimg, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getGender());
			ps.setString(4, member.getPhone());
			ps.setString(5, member.getEmail());
			ps.setString(6, member.getAddress());
			ps.setString(7, member.getTime());
			ps.setString(8, member.getUserimg());
			ps.setString(9, member.getStatus());
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
	public int signUp(Member member) {
		String sql = "insert into `member` (username, password, time) values(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getTime());
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
	public int delete(String username) {
		String sql = "delete from `member` where username = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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
	public int update(Member member) {
		String sql = "update `member` set password = ?, gender = ?, phone = ?, email = ?, address = ?, userimg = ?, status = ? where username = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPassword());
			ps.setString(2, member.getGender());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getAddress());
			ps.setString(6, member.getUserimg());
			ps.setString(7, member.getStatus());
			ps.setString(8, member.getUsername());
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
	public Member listByUsername(String username) {
		String sql = "select * from `member` where username = ?";
		Member member = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				Integer id = rs.getInt("id");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String time = rs.getString("time");
				String userimg = rs.getString("userimg");
				String status = rs.getString("status");
				member = new Member(id, username, password, gender, phone, email, address, time, userimg, status);
			}
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Member> list() {
		String sql = "select * from `member`";
		List<Member> members = new ArrayList<Member>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String time = rs.getString("time");
				String userimg = rs.getString("userimg");
				String status = rs.getString("status");
				members.add(new Member(id, username, password, gender, phone, email, address, time, userimg, status));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return members;
	}

	@Override
	public List<Member> search(String sign) {
		String sql = "select * from `member` where username like ?";
		List<Member> members = new ArrayList<Member>();
		String keyWord = "%" + sign + "%";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyWord);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String time = rs.getString("time");
				String userimg = rs.getString("userimg");
				String status = rs.getString("status");
				members.add(new Member(id, username, password, gender, phone, email, address, time, userimg, status));
			}
			return members;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}
}
