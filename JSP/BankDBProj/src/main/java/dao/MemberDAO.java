package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDAO {

   public int insertMember(Member member) {
      Connection conn = JdbcUtil.getConnection();
      int cnt = 0;
      PreparedStatement pstmt = null;
      String sql = "INSERT INTO member VALUES(?,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getId());
         pstmt.setString(2, member.getName());
         pstmt.setString(3, member.getPassword());
         pstmt.setString(4, member.getAddress());
         pstmt.setString(5, member.getEmail());
         cnt = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null)
               pstmt.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return cnt;
   }
   
   public Member selectMember(String id) {
	   Connection conn = JdbcUtil.getConnection();
	   String sql = "select * from member where id=?";
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   Member member = null;
	   try {
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   if(rs!=null && rs.next()) {
			   member = new Member();
			   member.setId(rs.getString("id"));
			   member.setName(rs.getString("name"));
			   member.setPassword(rs.getString("password"));
			   member.setAddress(rs.getString("address"));
			   member.setEmail(rs.getString("email"));
		   }
	   } catch(Exception e) {
		   e.printStackTrace();
	   } finally {
		   try {
			   if(rs!=null) rs.close();
			   if(pstmt!=null) pstmt.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
	   JdbcUtil.close(conn);
	   return member;
   }
}