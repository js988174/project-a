package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardAdd implements Command {


  @Override
  public void service() throws Exception{

    Board b = new Board();

    System.out.println("[게시글 등록]");

    b.setTitle(Prompt.inputString("글 제목: "));
    b.setContent(Prompt.inputString("글 내용: "));
    b.setWriter(Prompt.inputString("작성자: "));


    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://loaclhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into kim_board(title, content, writer) values(?,?,?)");) {

      stmt.executeUpdate();

      System.out.println("[글을 등록했습니다.]");
    }

  }
}

