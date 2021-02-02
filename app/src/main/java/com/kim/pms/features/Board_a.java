package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Date;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class Board_a {

  BoardList boardList = new BoardList();

  public void board () {
    while(true) {
      System.out.println();
      System.out.println("===============[게시판]================");
      System.out.println("[1] 글 등록 ");
      System.out.println("[2] 글 목록");
      System.out.println("[3] 글 보기");
      System.out.println("[4] 글 변경");
      System.out.println("[5] 글 삭제");
      System.out.println("[6] 메뉴로 돌아가기");
      System.out.println("=======================================");
      String command1 = Prompt.inputString("번호를 선택해주세요: ");
      System.out.println();

      switch(command1) {
        case "1" :            
          this.add();
          break;
        case "2" :
          this.list();
          break;     
        case "3" :
          this.detail();
          break;
        case "4" :
          this.update();
          break;
        case "5" :
          this.delete();
          break;
        case "6" :
          System.out.println("메뉴로 돌아갑니다.");
          return;
        default :
          System.out.println();
          System.out.println("잘못 입력하셨습니다. ");
          System.out.println("다시 입력해주세요. ");
          System.out.println();
          break;
      }
    }    
  }
  public void add() {

    Board b = new Board();

    System.out.println("[게시글 등록]");
    b.no = Prompt.inputInt("글 번호: " );
    b.title = Prompt.inputString("글 제목: ");
    b.content = Prompt.inputString("글 내용: ");
    b.writer = Prompt.inputString("작성자: ");
    b.now = new Date(System.currentTimeMillis());
    b.viewCount = 0;

    boardList.add(b);

    System.out.println("[글을 등록했습니다.]");
  }

  public void list() {
    System.out.println("[게시글 목록]");

    Board[] boards = boardList.toArray();

    for (Board b : boards) {

      System.out.printf("%d, %s, %s, %s, %d, %s\n", 
          b.no, 
          b.title, 
          b.content,
          b.writer, 
          b.viewCount,
          b.now);

    }
  }

  public void detail() {
    System.out.println("[게시글 보기]");

    int no = Prompt.inputInt("번호: ");

    Board board = boardList.get(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    board.viewCount++;
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.now);
    System.out.printf("조회수: %d\n", board.viewCount);
  }

  public void update() {
    System.out.println("게시글 변경");

    int no = Prompt.inputInt("번호: ");

    Board board = boardList.get(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String title = Prompt.inputString(String.format("제목(%s):", board.title));
    String content = Prompt.inputString(String.format("내용(%s):", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/n)");

    if( input.equalsIgnoreCase("y")) {
      board.title = title;
      board.content = content;
      System.out.println("게시글을 변경하였습니다.");
    }else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }
  }
  public void delete()  {

    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");

    Board board = boardList.get(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      boardList.delete(no);

      System.out.println("게시글을 삭제하였습니다.");
    }else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }
}

