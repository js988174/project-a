package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardUpdate implements Command {


  @Override
  public void service() throws Exception{
    System.out.println("게시글 변경");

    int no = Prompt.inputInt("번호: ");

    try (Connection con = DriverManager.getConnection( 
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement( 
            "select no,title,content from kim_board where no=?");
        PreparedStatement stmt2 = con.prepareStatement( 
            "update kim_board set title=?, content=? where no=?")) {

      Board board = new Board();

      stmt.setInt(1, no);
      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          System.out.println(".해당 번호의 게시글이 없습니다.");
          return;
        }
        board.setNo(no);
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
      }


      board.setTitle(Prompt.inputString(String.format("제목(%s):", board.getTitle())));
      board.setContent(Prompt.inputString(String.format("내용(%s):", board.getContent())));

      String input = Prompt.inputString("정말 변경하시겠습니까?(y/n)");

      if(!input.equalsIgnoreCase("y")) {
        System.out.println("게시글 변경을 취소하였습니다.");
        return;
      }
      stmt2.setString(1, board.getTitle());
      stmt2.setString(2, board.getContent());
      stmt2.setInt(3, board.getNo());
      stmt2.executeUpdate();
    }
  }
}


