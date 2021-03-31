package com.kim.pms.features;

import java.util.List;
import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardSearch implements Command {

  BoardDao boardDao;

  public BoardSearch(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service() throws Exception {
    String keyword = Prompt.inputString("검색어: ");

    if (keyword.length() == 0) {
      System.out.println("검색어를 입력하세요. ");
      return;
    }

    List<Board> list = boardDao.findByKeyword(keyword);

    if (list.size() == 0) {
      System.out.println("검색어에 해당하는 게시글이 없습니다.");
      return;
    }

    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          b.getNo(),
          b.getTitle(),
          b.getWriter().getName(),
          b.getNow(),
          b.getViewCount());
    }
  }
}
