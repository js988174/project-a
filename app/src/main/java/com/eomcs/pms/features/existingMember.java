package com.eomcs.pms.features;

import java.util.Scanner;

public class existingMember {

  static Scanner scanner = new Scanner(System.in);
 public static void add2 () {
    System.out.println("[기존 회원]");
   // 입력받은 id로 로그인 기능을 추가해보자
    System.out.println("id: ");
    System.out.printf("> "); 
    System.out.println();

    System.out.println("남은 기간: ");
    System.out.printf("> ");
    System.out.println();

    System.out.println("bmi지수를 계산하시겠습니까? [yes/no] ");
    String bmicalculation = scanner.nextLine();
    if(bmicalculation.equalsIgnoreCase("yes")) {

      System.out.println("[bmi지수 계산기] ");
      System.out.println("몸무게: ");
      System.out.printf("> ");
      double weight = scanner.nextDouble();

      System.out.println("키: ");
      System.out.printf("> ");
      double height = scanner.nextDouble();

      double bmi = weight/height/height ;
      System.out.printf("bmi 지수: %.2f\n" ,bmi);
    }else {
      System.out.println("메뉴로 돌아갑니다.");
    }
  }
}