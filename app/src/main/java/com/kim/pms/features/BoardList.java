package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardList implements Command {


  @Override
  public void service() throws Exception {
    System.out.println("[게시글 목록]");

    try (Connection con = DriverManager.getConnection( 
        "jdbc:mysql://localhost:3306/myproejct?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement( 
            "select no,title,writer,cdt,vw_cnt from kim_board order by no desc");
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {   
        System.out.printf("%d, %s, %s, %s, %d\n", 
            rs.getInt("no"), 
            rs.getString("title"), 
            rs.getString("writer"),
            rs.getDate("cdt"), 
            rs.getInt("vw_cnt"));
      }
    }
  }
}


