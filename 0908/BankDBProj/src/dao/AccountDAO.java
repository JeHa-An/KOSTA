package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import acc.Account;
import acc.SpecialAccount;

public class AccountDAO {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn=DriverManager.getConnection(db.getProperty("url"),
					db.getProperty("user"), db.getProperty("password"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Account selectAccount(Connection conn,String id) {
		Account acc = null;
		String sql = "select * from account where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				String rid=rs.getString("id");
				String rname=rs.getString("name");
				Integer rbalance=rs.getInt("balance");
				String rgrade=rs.getString("grade");
				if(rgrade==null) { 
					acc = new Account(rid,rname,rbalance);
				} else {
					acc = new SpecialAccount(rid,rname,rbalance,rgrade);					
				}
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
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			if(acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade());
			} else {
				pstmt.setString(4, null);
			}
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch (Exception e) {
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
		} catch (Exception e) {
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
	
	public static List<Account> selectAccountList(Connection conn) {
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
					if(grade == null) {
						accList.add(new Account(id,name,balance));						
					} else {
						accList.add(new SpecialAccount(id,name,balance,grade));
					}
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