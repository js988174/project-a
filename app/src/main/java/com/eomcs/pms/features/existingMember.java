package com.eomcs.pms.features;

import com.eomcs.util.Prompt;

public class existingMember {

  static class Emember {   
    String ID1;
    int height;
    int weight;
    String bmicalculation;
  }
  static final int MEMBER_SIZE= 1000;
  static Emember[] members = new Emember[MEMBER_SIZE];
  static int size = 0;



  public static void add2 () {
    System.out.println("[기존 회원]");

    Emember m = new Emember();
    while (true) {
      String id = Prompt.inputString("ID: (취소: 빈 문자열)");
      if (id.length() == 0) {
        System.out.println("ID입력을 취소합니다.");
        return;
      } else if (Register_Admin.exist(id)) {   
        m.ID1 = id;
        break;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
    String bmicalculation = Prompt.inputString("bmi지수를 계산하시겠습니까?[yes/no]");
    if(bmicalculation.equalsIgnoreCase("yes")) {

      m.height = Prompt.inputInt("몸무게: ");    
      m.weight = Prompt.inputInt("키: ");
      double bmi = m.weight/m.height/m.height ;
      System.out.printf("bmi 지수: %.2f\n" ,bmi);
    }else {
      System.out.println("메뉴로 돌아갑니다.");
    }


    members[size++] = m;
  }
  public static void list() {
    System.out.println("[회원 정보]");
    for (int i = 0; i < size; i++) {
      Emember m = members[i];
      System.out.printf("%d\n" ,m.ID1);
    }
  }

}
