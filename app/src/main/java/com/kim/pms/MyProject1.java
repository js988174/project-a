package com.kim.pms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Board;
import com.kim.pms.domain.Existing;
import com.kim.pms.features.AdminAdd;
import com.kim.pms.features.AdminMenu;
import com.kim.pms.features.AdminValidator;
import com.kim.pms.features.BoardMenu;
import com.kim.pms.features.Check;
import com.kim.pms.features.Command;
import com.kim.pms.features.ExistingMenu;
import com.kim.util.CsvObject;
import com.kim.util.ObjectFactory;
import com.kim.util.Prompt;

public class MyProject1 {

  static ArrayDeque<String> commandStack = new ArrayDeque<>();
  static LinkedList<String> commandQueue = new LinkedList<>();


  public static ArrayList<Board> boardList = new ArrayList<>();
  public static LinkedList<Admin1> adminList = new LinkedList<>(); 
  public static LinkedList<Existing> existList = new LinkedList<>();
  static List<Existing> checkList;

  static File boardFile = new File("boards.csv");
  static File adminFile = new File("admins.csv");
  static File existFile = new File("exists.csv");
  static File checkFile = new File("checks.csv");


  public static void main(String[] args) throws CloneNotSupportedException {

    loadObjects(boardFile, boardList, Board::new);
    loadObjects(adminFile, adminList, Admin1::new);
    loadObjects(existFile, existList, Existing::new);
    loadObjects(checkFile, checkList, Existing::new);

    HashMap<String,Command> commandMap = new HashMap<>();

    AdminValidator adminValidator = new AdminValidator(adminList);

    commandMap.put("1", new AdminAdd(adminList));
    commandMap.put("2", new ExistingMenu(existList, adminValidator));
    commandMap.put("3", new Check(checkList, adminValidator));
    commandMap.put("4", new BoardMenu(boardList));
    commandMap.put("5", new AdminMenu(adminList));



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
    saveObjects(boardFile, boardList);
    saveObjects(adminFile, adminList);
    saveObjects(existFile, existList);
    saveObjects(checkFile, checkList);

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


  static <T> void loadObjects(File file, List<T> list, ObjectFactory<T> objFactory) {
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      String csvStr = null;
      while ((csvStr = in.readLine()) != null) {
        list.add(objFactory.create(csvStr));
      }
      System.out.printf("파일 %s 로딩\n", file.getName());
    } catch (Exception e) {
      System.out.printf("파일 %s 로딩중 오류 발생\n", file.getName());

    }
  }

  static <T extends CsvObject> void saveObjects(File file, List<T> list ) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      for (CsvObject csvObj : list) {
        out.write(csvObj.toString() + "/n");
      }
      System.out.printf("파일 % 저장\n", file.getName());
    } catch (Exception e) {
      System.out.printf("파일 % 저장중 오류 발생\n", file.getName());
    }
  }
}