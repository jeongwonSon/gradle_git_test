package com.example.demo.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * (18.12.05)
 * 참고 : http://fruitdev.tistory.com/111
 * @author jeongwon
 *
 */
public class TestAddBatch {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Connection con = null;
    PreparedStatement pstmt = null;
    
    String sql = "Insert Into TB_TEST(uid, name, age) Values (?,?,?)";
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TEST_DB", "test_user", "12345");
      
      pstmt = con.prepareStatement(sql);
      
      for(int i=0; i < 100000 ; i++) {
        int uid = 10000 + i;
        String name = "홍길동_" + Integer.toString(i);
        int age = i;

        pstmt.setInt(1, uid);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        
        // addBatch에 담기
        pstmt.addBatch();
        
        // 파라미터 Clear
        pstmt.clearParameters();
        
        // outOfMemory를 고려하여 만건 단위로 커밋
        if((i % 10000) == 0) {
          // Batch 실행
          pstmt.executeBatch();
          
          // executeBatch를 했을 경우, 처리결과를 받을 수 있음(배열로 처리결과 확인 가능함)
//          int[] result = pstmt.executeBatch();
          
          // Batch 초기화
          pstmt.clearBatch();
          
          // 커밋
          con.commit();
        }
      }
      
      // 커밋되지 못한 나머지 구문에 대하여 커밋
      pstmt.executeBatch();
      con.commit();
      
    }catch (Exception e) {
      e.printStackTrace();
      
      try {
        con.rollback();
      }catch (SQLException e1) {
        // TODO: handle exception
        e1.printStackTrace();
      }
    }finally {
      if(pstmt != null) {
        try {
          pstmt.close();
          pstmt = null;
        }catch(SQLException ex) {}
      }
      if(con != null) {
        try {
          con.close();
          con = null;
        }catch(SQLException ex) {}
      }
    }
  }

}
