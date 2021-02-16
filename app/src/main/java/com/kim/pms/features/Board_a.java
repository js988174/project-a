package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.sql.Date;
import com.kim.pms.domain.Board;
import com.kim.util.List;
import com.kim.util.Prompt;

public class Board_a {

  private List<Board> boardList = new List<>();

  public void board () throws CloneNotSupportedException {
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
    b.setNo(Prompt.inputInt("글 번호: " ));
    b.setTitle(Prompt.inputString("글 제목: "));
    b.setContent(Prompt.inputString("글 내용: "));
    b.setWriter(Prompt.inputString("작성자: "));
    b.setNow(new Date(System.currentTimeMillis()));
    b.setViewCount(0);

    boardList.add(b);

    System.out.println("[글을 등록했습니다.]");
  }

  public void list() throws CloneNotSupportedException {
    System.out.println("[게시글 목록]");

    com.kim.util.Iterator<Board> iterator = boardList.iterator();

    while (iterator.hasNext()) {
      Board b = iterator.next();

      System.out.printf("%d, %s, %s, %s, %d, %s\n", 
          b.getNo(), 
          b.getTitle(), 
          b.getContent(),
          b.getWriter(), 
          b.getViewCount(),
          b.getNow());

    }
  }

  public void detail() {
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

  public void update() {
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
  public void delete()  {

    System.out.println("[게시글 삭제]");

    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      boardList.delete(board);

      System.out.println("게시글을 삭제하였습니다.");
    }else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }
  private Board findByNo(int boardNo) {
    Board[] list = boardList.toArray(new Board[0]);
    for (Object obj : list) {
      Board b = (Board) obj;
      if (b.getNo() == boardNo) {
        return b;
      }
    }
    return null;
  }

}


