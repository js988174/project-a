package com.kim.pms;

import com.kim.pms.features.Admin;
import com.kim.pms.features.Board_a;
import com.kim.pms.features.Check;
import com.kim.pms.features.ExistingMember;
import com.kim.pms.features.Register;
import com.kim.util.Prompt;

public class MyProject1 {


  /*헬스장 회원 관리 

[기존 회원]
몇일 남았는지 보기
[회원 조회]
아이디 회원 번호 이름 전화 주소 생일 직업 성별 이메일 등록 기간 만료기간 
[나중에 추가해줄것]
기존 회원: 회원 아이디 검색하면 [이름 반갑습니다] 출력       
pt 회원 : id를 검색하면 몇회 남았고 ,예약 시간 추가하기 
관리자 모드: 만료된 회원 삭제하기 , 회원 기간 늘리기  
 번호 중복없이 랜덤지정 해주기 
 회원 번호를 입력하면 출석체크 완료한거 뜨기 

   * 
   */


  public static void main(String[] args) {

    Board_a boardHandler = new Board_a();
    Register memberHandler = new Register();
    Admin adminHandler = new Admin(memberHandler);
    ExistingMember existHandler = new ExistingMember(memberHandler);  
    Check checkHandler = new Check(memberHandler);



    loop:
      while(true) {
        System.out.println("[ 헬스장 관리 프로그램 ]");
        System.out.println("[1] 신규 회원 [2] 기존 회원 ");
        System.out.println("[3] 출석 체크 ");
        System.out.println("[4] 게시판 ");
        System.out.println("[5] 관리자 모드 ");
        System.out.println("[6] 종료 ");
        String command =  com.kim.util.Prompt.inputString("번호를 선택해주세요: ");


        switch (command) {
          case "1" :   
            memberHandler.add();
            break;
          case "2" :  
            existHandler.list();
            break;
          case "3" :  
            checkHandler.list();
            break;
          case "4" :  
            boardHandler.board();
            break;          
          case "5" :
            adminHandler.service();
            break;
          case "6" :
            System.out.println("시스템을 종료합니다. ");
            break loop;

          default :
            System.out.println();
            System.out.println("잘못 입력하셨습니다. ");
            System.out.println("다시 입력해주세요. ");
            System.out.println();
        }
        System.out.println();
      }

    Prompt.close();
  }

  private static void Board_a() {


  }

}
