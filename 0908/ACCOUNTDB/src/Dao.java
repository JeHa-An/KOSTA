import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dao {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"), db.getProperty("password"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Account selectAccount(Connection conn, String id) {
		Account acc = null;
		String sql = "select * from account where id=?"; // 가변하는 데이터 ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // ?의 순서
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				String rid = rs.getString("id"); // DB column_name
				String rname = rs.getString("name");
				Integer rbalance = rs.getInt("balance");
				String rgrade = rs.getString("grade");
				acc = new Account(rid, rname, rbalance, rgrade);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int insertAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into account values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  acc.getId());
			pstmt.setString(2,  acc.getName());
			pstmt.setInt(3,  acc.getBalance());
			pstmt.setString(4,  acc.getGrade());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public static int updateAccount(Connection conn, Account acc) {
		int cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update account set balance=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public static List<Account> selectAccountList(Connection conn){
		List<Account> accList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					Integer balance = rs.getInt(3);
					String grade = rs.getString(4);
					accList.add(new Account(id,name,balance, grade));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return accList;
	}
}
