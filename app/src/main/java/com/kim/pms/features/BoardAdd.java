package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;


public class BoardAdd implements Command {


  BoardDao boardDao;

  public BoardAdd(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service() throws Exception{

    Board b = new Board();

    System.out.println("[게시글 등록]");

    b.setTitle(Prompt.inputString("글 제목: "));
    b.setContent(Prompt.inputString("글 내용: "));

    Admin1 writer = new Admin1();
    writer.setName(Prompt.inputString("작성자 닉네임: "));
    b.setWriter(writer);

    boardDao.insert(b);

    System.out.println("[글을 등록했습니다.]");
  }

}


