package com.kim.pms;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.dao.BoardDao;
import com.kim.pms.dao.CheckDao;
import com.kim.pms.dao.ExistingDao;
import com.kim.pms.features.AdminAdd;
import com.kim.pms.features.AdminMenu;
import com.kim.pms.features.AdminValidator;
import com.kim.pms.features.BoardMenu;
import com.kim.pms.features.Check;
import com.kim.pms.features.Command;
import com.kim.pms.features.ExistingMenu;
import com.kim.util.Prompt;

public class MyProject1 {


  ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();

  String serverAddress;
  int port;



  public static void main(String[] args)  {
    MyProject1 app = new MyProject1("localhost", 8888);

    try {
      app.execute();
    } catch (Exception e) {
      System.out.println("클라이언트 실행중 오류 발생");
      e.printStackTrace();
    }
  }

  public MyProject1(String serverAddress, int port) {
    this.serverAddress = serverAddress;
    this.port = port;
  }



  public void execute() throws Exception{

    AdminDao adminDao = new AdminDao();
    BoardDao boardDao = new BoardDao();
    ExistingDao existDao = new ExistingDao();
    CheckDao checkDao = new CheckDao();

    HashMap<String,Command> commandMap = new HashMap<>();

    AdminValidator adminValidator = new AdminValidator(adminDao);

    commandMap.put("1", new AdminAdd(adminDao));
    commandMap.put("2", new ExistingMenu(existDao ,adminValidator, adminDao));
    commandMap.put("3", new Check(checkDao,adminValidator));
    commandMap.put("4", new BoardMenu(boardDao));
    commandMap.put("5", new AdminMenu(adminDao));


    try {

      while(true) {
        System.out.println();
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

            case "h1" :
              printCommandHistory(commandStack.iterator());
              break;
            case "h2" :
              printCommandHistory(commandQueue.iterator());
              break;
            case "6" :
              System.out.println("시스템을 종료합니다. ");
              return;

            default :
              Command commandHandler = commandMap.get(command);
              System.out.println();
              if (commandHandler == null) {
                System.out.println("잘못 입력하셨습니다. ");
                System.out.println("다시 입력해주세요. ");
              } else {
                commandHandler.service();
              }
              System.out.println();
          }
        } catch (Exception e) {
          System.out.println("--------------------------------------");
          System.out.printf("오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println("--------------------------------------");
        }
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println("서버와 통신 하는 중에 오류 발생!");
    }
    Prompt.close();

  }


  private void printCommandHistory(Iterator<String> iterator) {
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