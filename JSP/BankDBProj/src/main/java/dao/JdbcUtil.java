package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/kosta");
			conn = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
