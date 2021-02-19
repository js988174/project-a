package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.List;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardDelete extends AbstractBoardHandler{



  public BoardDelete(List<Board> boardList) {
    super(boardList);

  }

  @Override
  public void service()  {

    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      boardList.remove(board);

      System.out.println("게시글을 삭제하였습니다.");
    }else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }


}


