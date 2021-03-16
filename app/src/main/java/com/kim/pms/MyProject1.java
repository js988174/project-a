package com.kim.pms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.kim.context.ContextListener;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Board;
import com.kim.pms.domain.Check1;
import com.kim.pms.domain.Existing;
import com.kim.pms.features.AdminAdd;
import com.kim.pms.features.AdminMenu;
import com.kim.pms.features.AdminValidator;
import com.kim.pms.features.BoardMenu;
import com.kim.pms.features.Check;
import com.kim.pms.features.Command;
import com.kim.pms.features.ExistingMenu;
import com.kim.pms.listener.AppListener;
import com.kim.pms.listener.FileListener;
import com.kim.util.Prompt;

public class MyProject1 {

  List<ContextListener> listeners = new ArrayList<>();

  ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();


  Map<String,Object> appContext = new HashMap<>();


  public static void main(String[] args)  {
    MyProject1 myproject1 = new MyProject1();

    myproject1.addContextListener(new AppListener());

    myproject1.addContextListener(new FileListener());

    myproject1.service();
  }

  public void addContextListener(ContextListener listener) {
    listeners.add(listener);
  }
  public void removeContextListener(ContextListener listener) {
    listeners.remove(listener);
  }


  @SuppressWarnings("unchecked")
  public void service() {
    ServiceStart();

    List<Board> boardList = (List<Board>) appContext.get("boardList");
    List<Admin1> adminList = (List<Admin1>) appContext.get("adminList");
    List<Existing> existList = (List<Existing>) appContext.get("existList");
    List<Check1> checkList = (List<Check1>) appContext.get("checkList");

    HashMap<String,Command> commandMap = new HashMap<>();

    AdminValidator adminValidator = new AdminValidator(adminList);

    commandMap.put("1", new AdminAdd(adminList));
    commandMap.put("2", new ExistingMenu(existList, adminValidator));
    commandMap.put("3", new Check(checkList, adminValidator));
    commandMap.put("4", new BoardMenu(boardList));
    commandMap.put("5", new AdminMenu(adminList));



    loop:
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
              break loop;

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

    Prompt.close();
    ServiceEnd();
  }

  private void ServiceStart() {
    for (ContextListener listener : listeners) {
      listener.contextStart(appContext);
    }
  }

  private void ServiceEnd() {
    for (ContextListener listener : listeners) {
      listener.contextEnd(appContext);
    }
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