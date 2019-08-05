package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.CommentDAO;
import jdbc.pojo.Comment;
import jdbc.util.JdbcUtils;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public int insert(Comment comment) {
		String sql = "insert into comment (username, content, time, userimg, articleid) values (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, comment.getUsername());
			ps.setString(2, comment.getContent());
			ps.setString(3, comment.getTime());
			ps.setString(4, comment.getUserimg());
			ps.setInt(5, comment.getArticleid());
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
	public List<Comment> list(Integer articleid) {
		String sql = "select * from comment where articleid = ?";  
		
		List<Comment> moments = new ArrayList<Comment>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, articleid);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				String username = rs.getString("username");
				String content = rs.getString("content");
				String time = rs.getString("time");
				String userimg = rs.getString("userimg");
				Integer id = rs.getInt("articleid");
				moments.add(new Comment(username, content, id, userimg, time));
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
