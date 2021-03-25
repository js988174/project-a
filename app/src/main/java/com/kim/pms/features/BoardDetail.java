package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kim.util.Prompt;

public class BoardDetail implements Command {


  @Override
  public void service() throws Exception {
    System.out.println("[게시글 보기]");

    int no = Prompt.inputInt("번호: ");

    try (Connection con = DriverManager.getConnection( 
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select * frm kim_board where no = ?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          System.out.println("해당 번호의 게시글이 없습니다.");
          return;
        }


        System.out.printf("제목: %s\n", rs.getString("title"));
        System.out.printf("내용: %s\n", rs.getString("content"));
        System.out.printf("작성자: %s\n", rs.getString("writer"));
        System.out.printf("등록일: %s\n", rs.getDate("cdt"),rs.getTime("cdt"));
        System.out.printf("조회수: %d\n", rs.getString("vw_cnt"));
        System.out.printf("좋아요: %d\n", rs.getString("like_cnt"));
      }
    }
  }
}

