package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.text.SimpleDateFormat;
import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardDetail implements Command {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  BoardDao boardDao;

  public BoardDetail(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service() throws Exception {
    System.out.println("[게시글 보기]");

    int no = Prompt.inputInt("번호: ");

    Board b = boardDao.findByNo(no);

    if (b == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }


    System.out.printf("제목: %s\n", b.getTitle());
    System.out.printf("내용: %s\n", b.getContent());
    System.out.printf("작성자: %s\n", b.getWriter().getName());
    System.out.printf("등록일: %s\n", formatter.format(b.getNow()));
    System.out.printf("조회수: %s\n", b.getViewCount());
    System.out.printf("좋아요: %s\n", b.getLike());

    boardDao.updateViewCount(no);
  }
}

