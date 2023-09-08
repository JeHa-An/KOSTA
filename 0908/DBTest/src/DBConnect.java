import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class DBConnect {
	public static Connection getConnection() { // DB연결
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // driver 설정
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "1234"); // DB 연결
			System.out.println("Success db connection");
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
	
	public static void insertUser(String id, String name) {
		Connection conn = getConnection();
		String sql = String.format("insert into user (id,name) values ('%s','%s')", id, name); // ; X
		Statement stmt = null;
		try {
			stmt = conn.createStatement(); // query 작업을 실행하기 위한 객체
			int cnt = stmt.executeUpdate(sql); // 변경된 데이터의 개수
			System.out.println(cnt+"개 데이터 삽입");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}
	
	public static void updateUserName(String id, String name) {
		Connection conn = getConnection();
		String sql = String.format("update user set name='%s' where id='%s'", name, id); // ; X
		Statement stmt = null;
		try {
			stmt = conn.createStatement(); // query 작업을 실행하기 위한 객체
			int cnt = stmt.executeUpdate(sql); // 변경된 데이터의 개수
			System.out.println(cnt+"개 수정");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}
	
	public static void deleteUser(String id) {
		Connection conn = getConnection();
		String sql = String.format("delete from user where id='%s'", id);
		Statement stmt = null;
		try {
			stmt = conn.createStatement(); // query 작업을 실행하기 위한 객체
			int cnt = stmt.executeUpdate(sql); // 변경된 데이터의 개수
			System.out.println(cnt+"개 삭제");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}
	
	
	public static void userInfo(String id) {
		Connection conn = getConnection();
		String sql = String.format("select * from user where id='%s'", id);
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement(); // query 작업을 실행하기 위한 객체
			rs = stmt.executeQuery(sql);
			if(rs!=null && rs.next()) {
				String rid = rs.getString("id");
				String rname = rs.getString("name");
				System.out.println(rid+","+rname);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}

	public static void allUserInfo() {
		Connection conn = getConnection();
		String sql = String.format("select * from user");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					String rid=rs.getString(1); // = "id"
					String rname = rs.getString(2); // = "name"
					System.out.println(rid+","+rname);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
	}
	public static void main(String[] args) {
//		 insertUser("hong", "홍길동");
		//updateUserName("song", "송송이");
//		deleteUser("song");	
//		userInfo("jang");
		allUserInfo();
	}

}