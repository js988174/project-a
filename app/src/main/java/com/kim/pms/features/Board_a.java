package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Date;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class Board_a {

  static final int SIZE = 1000;

  Board[] boards = new Board[SIZE];
  int size = 0;

  public void board () {
    while(true) {
      System.out.println();
      System.out.println("[1]  글 등록 [2] 글 보기 [3] 글 변경 [4] 글 목록 [5] 글 삭제");
      String command1 = Prompt.inputString("번호를 선택해주세요: ");

      switch(command1) {
        case "1" :                   
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
          break;

        case "2" :

          System.out.println("[게시글 목록]");

          for (int i = 0; i < this.size; i++) {
            Board b1 = boards[i];
            System.out.printf("%d, %s, %s, %s, %d, %s\n", 
                b1.no, 
                b1.title, 
                b1.content,
                b1.writer, 
                b1.viewCount,
                b1.now);
            break;
          }
        case "3" :
      }
    }    
  }
}