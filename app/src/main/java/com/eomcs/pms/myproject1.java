package com.eomcs.pms;

import com.eomcs.pms.features.Register_Admin;
import com.eomcs.pms.features.existingMember;
import com.eomcs.util.Prompt;

public class myproject1 {


  /*헬스장 회원 관리 
[ 회원 가입]
아이디 회원 번호 이름 전화 주소 생일 직업 성별 이메일 등록 기간 만료기간 
[기존 회원]
몇일 남았는지 보기
[관리자 모드]
[회원 조회]
아이디 회원 번호 이름 전화 주소 생일 직업 성별 이메일 등록 기간 만료기간 
[나중에 추가해줄것]
기존 회원: pt 회원이면 몇회 남았고 예약 시간 정하기 , 회원 번호를 입력하여 정보 검색       
관리자 모드: 만료된 회원 삭제하기 , 회원 기간 늘리기  
 번호 중복없이 랜덤지정 해주기 
 회원 번호를 입력하면 출석체크 완료한거 뜨기 
 3. pt 신청하기 4. 관리자 모드 5. 종료 
   * 
   */


  public static void main(String[] args) {

    loop:
      while(true) {
        System.out.println("1. 신규 회원 2. 기존 회원 3. 관리자 모드 4. 종료 ");

        String command =  com.eomcs.util.Prompt.inputString("번호를 선택해주세요: ");


        switch (command) {
          case "1" :   
            Register_Admin.add1();
            break;
          case "2" :  
            existingMember.add2();
            break;
          case "3" :
            Register_Admin.add3();
            break;
          case "4" :
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
}
