package com.kim.pms.features;
// 건의 게시판  번호 제목 글 건의자 

import java.util.List;
import com.kim.pms.domain.Board;
import com.kim.util.Prompt;

public class BoardMenu extends AbstractBoardHandler {

  public BoardMenu(List<Board> boardList) {
    super(boardList);
  }


  BoardAdd boardAdd = new BoardAdd(boardList);
  BoardList boardList1 = new BoardList(boardList);
  BoardDetail boardDetail = new BoardDetail(boardList);
  BoardUpdate boardUpdate = new BoardUpdate(boardList);
  BoardDelete boardDelete = new BoardDelete(boardList);

  @Override
  public void service() {
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
          boardAdd.service();
          break;
        case "2" :
          boardList1.service();
          break;     
        case "3" :
          boardDetail.service();
          break;
        case "4" :
          boardUpdate.service();
          break;
        case "5" :
          boardDelete.service();
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


}


