package com.kim.pms.features;

import com.kim.pms.domain.Existing;
import com.kim.util.List;
import com.kim.util.Prompt;

public class ExistingMember {


  static final int MEMBER_SIZE= 1000;

  Existing[] members = new Existing[MEMBER_SIZE];
  int size = 0;

  List adminList;

  public ExistingMember(List adminList) {
    this.adminList = adminList;
  }



  public void list() {
    System.out.println("[기존 회원]");

    Existing m = new Existing();
    while (true) {

      String id = Prompt.inputString("ID: (취소: 빈 문자열)");
      Existing existing = new Existing();
      if (id.length() == 0) {
        System.out.println("ID입력을 취소합니다.");
        return;

      } else if (m.getID1().equals(id)) {   

        System.out.println("회원님 반갑습니다.");  
        break;

      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }

    while (true) {
      System.out.println();
      System.out.println("[1] pt 신청하기 [2] bmi 계산하기 [3] 메뉴로 돌아가기");
      String command1 = Prompt.inputString("번호를 선택해주세요: ");

      switch (command1) {
        case "1":
          m.setStatus(Prompt.inputInt("\n0: 1회 [5만원]\n1: 10회 [45만원]\n2: 15회 [68만원]\n "));


          for (int i = 0; i < size; i++) {
            Existing m1 = this.members[i];

            String status1 = null;
            switch (m1.getStatus()) {
              case 1:
                status1 = "10회 [45만원]";
                break;
              case 2:
                status1 = "15회 [68만원]";
                break;
              default :
                status1 = "1회 [5만원]";
                break;
            }
            System.out.printf("pt 신청번호: %s\n", status1);
          }        
          break;
        case "2": 
          String bmicalculation = Prompt.inputString("bmi지수를 계산하시겠습니까?[yes/no]");
          if(bmicalculation.equalsIgnoreCase("yes")) {
            m.setHeight(Prompt.inputInt("몸무게: "));    
            m.setWeight(Prompt.inputInt("키: "));
            double bmi = m.getWeight()/m.getHeight()/m.getHeight() ;
            System.out.printf("bmi 지수: %.2f\n" ,bmi);
            break;
          }
        case "3" : 
          System.out.println("메뉴로 돌아갑니다.");
          return;
        default : 
          System.out.println("실행할 수 없는 명령입니다.");
      }    
      this.members[this.size++] = m;
    }
  }

}