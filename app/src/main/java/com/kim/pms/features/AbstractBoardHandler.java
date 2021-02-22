package com.kim.pms.features;

import java.util.List;
import com.kim.pms.domain.Board;

public abstract class AbstractBoardHandler implements Command {

  protected List<Board> boardList;

  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  protected Board findByNo(int boardNo) {
    Board[] list = boardList.toArray(new Board[boardList.size()]);
    for (Object obj : list) {
      Board b = (Board) obj;
      if (b.getNo() == boardNo) {
        return b;
      }
    }
    return null;
  }
}
