package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Date;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class Board_a {

  static final int SIZE = 1000;

  Board[] boards = new Board[SIZE];
  int size = 0;

  public void add3(Board_a boardList) {
    Board b = new Board();
    System.out.println("[게시글 등록]");
    b.no = Prompt.inputInt("글 번호: " );
    b.title = Prompt.inputString("글 제목: ");
    b.content = Prompt.inputString("글 내용: ");
    b.writer = Prompt.inputString("작성자: ");
    b.now = new Date(System.currentTimeMillis());
    b.viewCount = 0;
    System.out.println("[글을 등록했습니다.]");
    this.boards[this.size++] = b;


  }
  public void list() {
    System.out.println("[게시글 목록]");

    for (int i = 0; i < this.size; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %s, %s, %d, %s\n", 
          b.no, 
          b.title, 
          b.content,
          b.writer, 
          b.viewCount,
          b.now);
    }
  }
}
