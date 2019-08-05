package jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcUtils {
	
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/dataBaseName?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static String username = "???";
	private static String password = "???";
	private static DruidDataSource druidDataSource = null;
	
	static {
		try {
			druidDataSource = new DruidDataSource();
			druidDataSource.setUsername(username);
			druidDataSource.setDriverClassName(driverClassName);
			druidDataSource.setPassword(password);
			druidDataSource.setUrl(url);
			druidDataSource.setMaxActive(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = druidDataSource.getConnection();
		return conn;
	}
	
	public static void close(Connection conn, Statement s, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(s != null) {
					s.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
