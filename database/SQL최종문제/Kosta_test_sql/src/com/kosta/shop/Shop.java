package com.kosta.shop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kosta.order.Order;
import com.kosta.product.Goods;

public class Shop {


	//구현해야 하는 부분: ApplicationMain.java 오류 없이 작동하도록 필요한 모든 메서드를 구현한다.

	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn=DriverManager.getConnection(db.getProperty("url"), db.getProperty("user"), db.getProperty("password"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addProduct(Goods good) {
		int cnt = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, good.getCode());
			pstmt.setString(2, good.getName());
			pstmt.setInt(3, good.getPrice());
			pstmt.setInt(4, good.getStock());
			pstmt.setString(5, good.getCategory());
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
		close(conn);
	}
	public int order(Order order) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into `order` values(?,?,?,?,?)";
		updateProduct(conn, order);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getNo());
			pstmt.setString(2, order.getCustomer());
			pstmt.setString(3, order.getProductCode());
			pstmt.setInt(4, order.getAmount());
			pstmt.setBoolean(5, order.isCanceled());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return order.getNo();
	}

	public Goods findProductByCode(String code) {
		Goods good = null;
		Connection conn = getConnection();
		String sql = "select * from goods where code=?"; // 가변하는 데이터 ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code); // ?의 순서
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				String c = rs.getString("code");
				String name = rs.getString("name");
				Integer price= rs.getInt("price");
				Integer stock= rs.getInt("stock");
				String category = rs.getString("category");
				good = new Goods(c, name, price, stock, category);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		close(conn);
		return good;
	}
	
	public void updateProduct(Connection conn, Order order) {
		PreparedStatement pstmt = null;
		String sql = "update goods set stock=stock+? where code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			if(order.isCanceled() == true) {
				pstmt.setInt(1, order.getAmount()*-1);
			}else {
				pstmt.setInt(1, order.getAmount());
			}
			pstmt.setString(2, order.getProductCode());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void printAllProductInfo() {
		List<Goods> goodList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from goods";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					String code = rs.getString(1);
					String name = rs.getString(2);
					Integer price  = rs.getInt(3);
					Integer stock = rs.getInt(4);
					String category= rs.getString(5);
					if(category == "1") 
						goodList.add(new Goods(code, name, price, stock, "정상"));
					else
						goodList.add(new Goods(code, name, price, stock, "취소"));
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
		for(Goods good : goodList) {
			System.out.println(good);
		}
		close(conn);
	}
	
	public void printAllOrderInfo() {
		List<Order> orderList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from `order`";
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs!=null) {
				while(rs.next()) {
					Integer no = rs.getInt(1);
					String customer = rs.getString(2);
					String productcode = rs.getString(3);
					Integer amount  = rs.getInt(4);
					boolean iscanceled = rs.getBoolean(5);
					orderList.add(new Order(no, customer, productcode, amount, iscanceled));
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
		for(Order order : orderList) {
			System.out.println(order);
		}
		close(conn);
	}
	
	public Order findOrderByNo(int row) {
		Connection conn = getConnection();
		String sql = "select * from `order` where no=?"; // 가변하는 데이터 ?
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, row); // ?의 순서
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				Integer no = rs.getInt(1);
				String customer = rs.getString(2);
				String productcode = rs.getString(3);
				Integer amount = rs.getInt(4);
				Boolean iscanceled = rs.getBoolean(5);
				order = new Order(no, customer, productcode, amount, iscanceled);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return order;
	}
	
	public Order cancelOrder(Integer rNo) {
		Connection conn = getConnection();
		String sql = "update `order` set iscanceled=? where no=?"; // 가변하는 데이터 ?
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, false); // ?의 순서
			pstmt.setInt(2, rNo); // ?의 순서
			pstmt.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		Order order = findOrderByNo(rNo);
		updateProduct(conn, order);
		close(conn);
		return order;
	}
	
	
	public void printOrderDetailsByCustomerAndIsCanceled(String customerName, String string) {
		Connection conn = getConnection();
		String sql = "select customer, COUNT(*), sum(g.price * amount) from `order` join goods g on productcode=g.code where customer=? and iscanceled=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customerName); // ?의 순서
			if(string == "정상") {
				pstmt.setBoolean(2, true);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					String customer = rs.getString(1);
					Integer count = rs.getInt(2);
					Integer tot = rs.getInt(3);
					System.out.println(String.format("%s님의 정산주문 건수는: %d건이고, 정상주문합계금액은: %d원 입니다.",
							customer, count, tot));// ?의 순서				
				}
			} else {
				pstmt.setBoolean(2, false);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					String customer = rs.getString(1);
					Integer count = rs.getInt(2);
					Integer tot = rs.getInt(3);
					System.out.println(String.format("%s님의 취소주문 건수는: %d건이고, 최소주문합계금액은: %d원 입니다.",
							customer, count, tot));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		close(conn);
	}
}



