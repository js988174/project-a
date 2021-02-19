package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.Iterator;
import java.util.List;
import com.kim.pms.domain.Board;

public class BoardList extends AbstractBoardHandler {

  public BoardList(List<Board> boardList) {
    super(boardList);

  }

  @Override
  public void service()  {
    System.out.println("[게시글 목록]");

    Iterator<Board> iterator = boardList.iterator();

    while (iterator.hasNext()) {
      Board b = iterator.next();

      System.out.printf("%d, %s, %s, %s, %d, %s\n", 
          b.getNo(), 
          b.getTitle(), 
          b.getContent(),
          b.getWriter(), 
          b.getViewCount(),
          b.getNow());

    }
  }

}


