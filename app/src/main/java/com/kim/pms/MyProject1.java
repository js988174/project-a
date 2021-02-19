package com.kim.pms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Board;
import com.kim.pms.domain.Existing;
import com.kim.pms.features.AdminAdd;
import com.kim.pms.features.AdminMenu;
import com.kim.pms.features.AdminValidator;
import com.kim.pms.features.BoardMenu;
import com.kim.pms.features.Check;
import com.kim.pms.features.ExistingMenu;
import com.kim.util.Prompt;

public class MyProject1 {

  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();


  public static void main(String[] args) throws CloneNotSupportedException {


    // 게시판 메뉴
    ArrayList<Board> boardList = new ArrayList<>();
    BoardMenu boardMenu = new BoardMenu(boardList);

    // 관리자 메뉴
    ArrayList<Admin1> adminList = new ArrayList<>();
    AdminAdd adminAdd = new AdminAdd(adminList);
    AdminMenu adminMenu = new AdminMenu(adminList);
    AdminValidator adminValidator = new AdminValidator(adminList);


    // 기존 회원 메뉴
    ArrayList<Existing> existList = new ArrayList<>();
    ExistingMenu existingMenu = new ExistingMenu(existList, adminValidator);  

    // 출석 체크
    Check check = new Check(adminValidator);



    loop:
      while(true) {
        System.out.println("[ 헬스장 관리 프로그램 ]");
        System.out.println("[1] 신규 회원 [2] 기존 회원 ");
        System.out.println("[3] 출석 체크 ");
        System.out.println("[4] 게시판 ");
        System.out.println("[5] 관리자 모드 ");
        System.out.println("[h1] [h2] 방문 기록");
        System.out.println("[6] 종료 ");
        String command =  com.kim.util.Prompt.inputString("번호를 선택해주세요: ");

        if (command.length() == 0) 
          continue;

        commandStack.push(command);
        commandQueue.offer(command);

        try {
          switch (command) {

            case "1" :   
              adminAdd.service();
              break;
            case "2" :  
              existingMenu.service();
              break;
            case "3" :  
              check.service();
              break;
            case "4" :  
              boardMenu.service();
              break;          
            case "5" :
              adminMenu.service();
              break;
            case "h1" :
              printCommandHistory(commandStack.iterator());
              break;
            case "h2" :
              printCommandHistory(commandQueue.iterator());
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
        } catch (Exception e) {
          System.out.println("--------------------------------------");
          System.out.printf("오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println("--------------------------------------");
        }
        System.out.println();
      }

    Prompt.close();
  }

  static void printCommandHistory(Iterator<String> iterator) {
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