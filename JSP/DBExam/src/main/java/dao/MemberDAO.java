package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dto.JdbcUtil;
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

}