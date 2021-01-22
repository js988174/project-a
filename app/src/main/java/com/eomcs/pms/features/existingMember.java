package com.eomcs.pms.features;

import com.eomcs.pms.domain.existing;
import com.eomcs.util.Prompt;

public class existingMember {

  static final int MEMBER_SIZE= 1000;

  existing[] members = new existing[MEMBER_SIZE];
  int size = 0;



  public void add2 (Register_Admin memberList) {
    System.out.println("[기존 회원]");

    existing m = new existing();
    while (true) {
      String id = Prompt.inputString("ID: (취소: 빈 문자열)");
      if (id.length() == 0) {
        System.out.println("ID입력을 취소합니다.");
        return;
      } else if (memberList.exist(id)) {   
        m.ID1 = id;
        System.out.println("[]회원님 반갑습니다.");
        break;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
    while (true) {
      System.out.println("[1] pt 신청하기 [2] bmi 계산하기");
      String command = Prompt.inputString("번호를 선택해주세요: ");
      if (command == 1) {
        System.out.println("1회 5만원,10회 45만원 ,15회 ");

      } else if (command ==2) {
        String bmicalculation = Prompt.inputString("bmi지수를 계산하시겠습니까?[yes/no]");
        if(bmicalculation.equalsIgnoreCase("yes")) {

          m.height = Prompt.inputInt("몸무게: ");    
          m.weight = Prompt.inputInt("키: ");
          double bmi = m.weight/m.height/m.height ;
          System.out.printf("bmi 지수: %.2f\n" ,bmi);
        }else {
          System.out.println("메뉴로 돌아갑니다.");
        }
      }
    }



    this.members[this.size++] = m;
  }
  public void list() {
    System.out.println("[회원 정보]");
    for (int i = 0; i < this.size; i++) {
      existing m = this.members[i];
      System.out.printf("%d\n" ,m.ID1);
    }
  }

}
