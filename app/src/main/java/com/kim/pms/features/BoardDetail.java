package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.List;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardDetail extends AbstractBoardHandler {


  public BoardDetail(List<Board> boardList) {
    super(boardList);
  }

  @Override
  public void service() {
    System.out.println("[게시글 보기]");

    int no = Prompt.inputInt("번호: ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getNow());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

}


