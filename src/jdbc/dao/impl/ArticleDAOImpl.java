package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.dao.ArticleDAO;
import jdbc.pojo.Article;
import jdbc.util.JdbcUtils;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public int insert(Article article) {
		String sql = "insert into article (title, author, category, content, img, time) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getAuthor());
			ps.setString(3, article.getCategory());
			ps.setString(4, article.getContent());
			ps.setString(5, article.getImg());
			ps.setString(6, article.getTime());
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
	public int delete(int id) {
		String sql = "delete from article where id = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
	public int update(Article article) {
		String sql = "update article set title = ?, author = ?, category = ?, content = ?, img = ?, time = ?, status = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getAuthor());
			ps.setString(3, article.getCategory());
			ps.setString(4, article.getContent());
			ps.setString(5, article.getImg());
			ps.setString(6, article.getTime());
			ps.setString(7, article.getStatus());
			ps.setInt(8, article.getId());
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
	public Article listById(int id) {
		String sql = "select * from article where id = ?";
		Article article = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String time = rs.getString("time");
				String status = rs.getString("status");
				article = new Article(id, title, author, category, content, img, time, status);
			}
			return article;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Article> list() {
		String sql = "select * from article order by time desc";
		List<Article> articles = new ArrayList<Article>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String time = rs.getString("time");
				String status = rs.getString("status");
				articles.add(new Article(id, title, author, category, content, img, time, status));
			}
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Article> search(String sign) {
		String sql = "select * from article where title like ? order by time desc";
		List<Article> articles = new ArrayList<Article>();
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
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String time = rs.getString("time");
				String status = rs.getString("status");
				articles.add(new Article(id, title, author, category, content, img, time, status));
			}
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Article> top(int index) {
		String sql = "select * from article order by time desc limit 0 , ?";
		List<Article> articles = new ArrayList<Article>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String time = rs.getString("time");
				String status = rs.getString("status");
				articles.add(new Article(id, title, author, category, content, img, time, status));
			}
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}
	
	@Override
	public List<Article> listCategory(String type) {
		String sql = "select * from article where category = ? order by time desc";
		List<Article> articles = new ArrayList<Article>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String content = rs.getString("content");
				String img = rs.getString("img");
				String time = rs.getString("time");
				String status = rs.getString("status");
				articles.add(new Article(id, title, author, category, content, img, time, status));
			}
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, ps, rs);
		}
		return null;
	}
}
