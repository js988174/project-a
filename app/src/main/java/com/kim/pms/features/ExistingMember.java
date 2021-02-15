package com.kim.pms.features;

import java.util.Random;
import com.kim.pms.domain.Existing;
import com.kim.util.List;
import com.kim.util.Prompt;
public class ExistingMember {





  private List adminList = new List();

  private Admin admin;

  public ExistingMember(Admin admin) {
    this.admin = admin;
  }



  public void service() {
    System.out.println("[기존 회원]");

    while (true) {
      Existing m = new Existing();
      m.setID1(admin.inputMember("ID: (취소: 빈 문자열): "));
      if (m.getID1() == null) {
        System.out.println("아이디 입력을 취소합니다.");
        return;
      }

      while (true) {
        System.out.println();
        System.out.println("========개인 신청 목록========");
        System.out.println("[1] pt 신청하기");
        System.out.println("[2] 개인 락커룸 신청하기");
        System.out.println("[3] 회원 정보");
        System.out.println("[4] 메뉴로 돌아가기");
        System.out.println();
        String command1 = Prompt.inputString("번호를 선택해주세요: ");
        System.out.println();
        switch (command1) {
          case "1":
            this.pt();
            break;
          case "2": 
            this.room();
            break;
          case "3" :
            this.list();
            break;
          case "4" : 
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

  public void pt() {
    Existing m = new Existing();

    System.out.println();
    String input = Prompt.inputString("pt 신청(y/n)");

    if (input.equalsIgnoreCase("y")) {
      m.setStatus(Prompt.inputInt("\n0: 5회 [25만원]\n1: 10회 [45만원]\n2: 15회 [68만원]\n "
          + "pt 신청 :"));
      System.out.println();
      System.out.println("pt를 신청하셨습니다.");
    }
    adminList.add(m);
  }

  public void room() {
    Existing m = new Existing();

    System.out.println();
    String input = Prompt.inputString("락커룸 신청(y/n)");

    if (input.equalsIgnoreCase("y")) {
      m.setStatus(Prompt.inputInt("\n0: 3개월 [1만원]\n1: 6개월 [5.5만원]\n2: 12개월 [10만원]\n "
          + "락커룸 신청 :"));
      int Number[] = new int[1];
      Random r = new Random();

      for (int i = 0; i < Number.length; i ++) {
        Number[i] = r.nextInt(150)+1;
        for (int j = 0; j < i; j++) {
          if (Number[i] ==Number[j]) {
            i--;
            break;
          }
        }
        System.out.println();
        System.out.printf("> ");
        System.out.printf("락커룸 번호: %d\n ", Number[i]);
      }
    }
    adminList.add(m);
  }

  public void list() {

    Object[] list = adminList.toArray();

    for (Object obj : list) {
      Existing m1 = (Existing) obj;
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
      System.out.println();
      System.out.printf("pt 신청번호: %s\n", status1);
    }        

    for (Object obj : list) {
      Existing m2 = (Existing) obj;
      String status2 = null;
      switch (m2.getStatus()) {
        case 1:
          status2 = "6개월 [5.5만원]";
          break;
        case 2:
          status2 = "12개월 [10만원]";
          break;
        default :
          status2 = "3개월 [1만원]";
          break;
      }
      System.out.println();
      System.out.printf("락커룸 기간 : %s\n " , status2);
    }        
  }
}