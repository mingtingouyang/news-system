package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtils;
import jdbc.dao.UserDAO;
import jdbc.pojo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public int insert(User user) {
		String sql = "insert into user (username, password, phone, gender, permission, userimg) values(?, ?, ?, ?, ?, ?)";
	
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getPermission());
			ps.setString(6, user.getUserimg());
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
	public int signUp(User user) {
		String sql = "insert into user (username, password) values(?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
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
		String sql = "delete from user where username = ?";
		
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
	public int update(User user) {
		String sql = "update user set password = ?, phone = ?, gender = ?, permission = ?, userimg= ? where username = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getPermission());
			ps.setString(5, user.getUserimg());
			ps.setString(6, user.getUsername());
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
	public User listByUsername(String username) {
		String sql = "select * from user where username = ?";
		User user = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String permission = rs.getString("permission");
				String userimg = rs.getString("userimg");
				Integer id = rs.getInt("id");
				user = new User(username, password, phone, gender, permission, userimg, id);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<User> list() {
		String sql = "select * from user";
		List<User> users = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String permission = rs.getString("permission");
				String userimg = rs.getString("userimg");
				Integer id = rs.getInt("id");
				users.add(new User(username, password, phone, gender, permission, userimg, id));
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}
	
	@Override
	public List<User> search(String sign) {
		String sql = "select * from user where username like ?";
		List<User> users = new ArrayList<User>();
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
				String username = rs.getString("username");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String permission = rs.getString("permission");
				String userimg = rs.getString("userimg");
				Integer id = rs.getInt("id");
				users.add(new User(username, password, phone, gender, permission, userimg, id));
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

}
