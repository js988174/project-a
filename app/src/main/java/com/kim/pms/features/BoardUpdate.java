package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardUpdate implements Command {

  BoardDao boardDao;

  public BoardUpdate(BoardDao boardDao) {
    this.boardDao = boardDao; 
  }

  @Override
  public void service() throws Exception{
    System.out.println("게시글 변경");

    int no = Prompt.inputInt("번호: ");



    Board board = boardDao.findByNo(no);

    if (board == null) {
      System.out.println(".해당 번호의 게시글이 없습니다.");
      return;
    }

    board.setTitle(Prompt.inputString(String.format("제목(%s):", board.getTitle())));
    board.setContent(Prompt.inputString(String.format("내용(%s):", board.getContent())));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/n)");

    if(!input.equalsIgnoreCase("y")) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    boardDao.update(board);

    System.out.println("게시글을 변경하였습니다.");
  }
}


