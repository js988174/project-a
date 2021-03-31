package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import com.kim.pms.dao.BoardDao;
import com.kim.util.Prompt;


public class BoardDelete implements Command{

  BoardDao boardDao;

  public BoardDelete(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service() throws Exception{

    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/n)");

    if (!input.equalsIgnoreCase("y")) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }


    if (boardDao.delete(no) == 0) {
      System.out.println("해당 번호의 게시글이 없습니다.");
    }else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }
}



