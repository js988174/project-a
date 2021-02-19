package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.List;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardUpdate extends AbstractBoardHandler {


  public BoardUpdate(List<Board> boardList) {
    super(boardList);

  }

  @Override
  public void service() {
    System.out.println("게시글 변경");

    int no = Prompt.inputInt("번호: ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String title = Prompt.inputString(String.format("제목(%s):", board.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s):", board.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/n)");

    if( input.equalsIgnoreCase("y")) {
      board.setTitle(title);
      board.setContent(content);
      System.out.println("게시글을 변경하였습니다.");
    }else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }
  }

}


