package com.kim.pms;

import com.kim.pms.features.Admin;
import com.kim.pms.features.Board_a;
import com.kim.pms.features.Check;
import com.kim.pms.features.ExistingMember;
import com.kim.util.Prompt;
import com.kim.util.Queue;
import com.kim.util.QueueIterator;
import com.kim.util.Stack;
import com.kim.util.StackIterator;

public class MyProject1 {

  static Stack commandStack = new Stack();
  static Queue commandQueue = new Queue();


  public static void main(String[] args) {

    Board_a boardHandler = new Board_a();

    Admin adminHandler = new Admin();

    ExistingMember existHandler = new ExistingMember(adminHandler);  

    Check checkHandler = new Check(adminHandler);



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
            adminHandler.add();
            break;
          case "2" :  
            existHandler.service();
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
  static void printCommandHistory() throws CloneNotSupportedException {

    StackIterator iterator = new StackIterator(commandStack);

    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if ((++count % 5) == 0) {
        String input = Prompt.inputString(": ");
        if (input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
  static void printCommandHistory2() throws CloneNotSupportedException {


    QueueIterator iterator = new QueueIterator(commandQueue);

    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if ((++count % 5) == 0) {
        String input = Prompt.inputString(": ");
        if (input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}
