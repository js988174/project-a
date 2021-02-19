package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Date;
import java.util.List;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardAdd extends AbstractBoardHandler {

  public BoardAdd(List<Board> boardList) {
    super(boardList);
  }

  @Override
  public void service() {

    Board b = new Board();

    System.out.println("[게시글 등록]");
    b.setNo(Prompt.inputInt("글 번호: " ));
    b.setTitle(Prompt.inputString("글 제목: "));
    b.setContent(Prompt.inputString("글 내용: "));
    b.setWriter(Prompt.inputString("작성자: "));
    b.setNow(new Date(System.currentTimeMillis()));
    b.setViewCount(0);

    boardList.add(b);

    System.out.println("[글을 등록했습니다.]");
  }

}


