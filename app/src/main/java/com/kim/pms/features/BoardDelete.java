package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kim.util.Prompt;

public class BoardDelete implements Command{


  @Override
  public void service() throws Exception{

    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/n)");

    if (!input.equalsIgnoreCase("y")) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement( 
            "delete from kim_board where no =?")) {

      stmt.setInt(1, no);
      if (stmt.executeUpdate() == 0) {
        System.out.println("해당 번호의 게시글이 없습니다.");
      }else {
        System.out.println("게시글 삭제를 취소하였습니다.");
      }
    }
  }
}


