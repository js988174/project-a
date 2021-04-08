package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.List;
import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Board;

public class BoardList implements Command {

  BoardDao boardDao;

  public BoardList(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service() throws Exception {
    System.out.println("[게시글 목록]");

    List<Board> boards = boardDao.findByKeyword(null);

    for (Board b : boards) {   
      System.out.printf("%d, %s, %s, %s, %d\n", 
          b.getNo(), 
          b.getTitle(), 
          b.getWriter().getName(),
          b.getNow(),
          b.getViewCount());
    }
  }
}



