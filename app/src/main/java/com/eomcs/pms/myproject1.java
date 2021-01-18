package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class myproject1 {
  /*헬스장 회원 관리 
[ 회원 가입]
아이디 회원 번호 이름 전화 주소 생일 직업 성별 이메일 등록 기간 만료기간 
[기존 회원]
몇일 남았는지 보기
[관리자 모드]
[회원 조회]
아이디 회원 번호 이름 전화 주소 생일 직업 성별 이메일 등록 기간 만료기간 
[나중에 추가해줄것]
기존 회원: pt 회원이면 bmi 전 후 볼 수 있게하기 , 회원 아이디를 입력하여 정보 검색       
관리자 모드: 만료된 회원 삭제하기 , 회원 기간 늘리기 , 회원 번호로 락커룸 지정
   * 
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 회원 등록 데이터
    final int MEMBER = 100;
    String[] id = new String[MEMBER];
    String[] number = new String[MEMBER];
    String[] name = new String[MEMBER];
    String[] phone = new String[MEMBER];
    String[] adress = new String[MEMBER];
    String[] birth = new String[MEMBER];
    String[] job = new String[MEMBER];
    String[] gender = new String[MEMBER];
    String[] email = new String[MEMBER];
    Date[] now = new Date[MEMBER];
    int[] status = new int[MEMBER];

    int size = 0;



    while(true) {
      System.out.println("1. 신규 회원 2. 기존 회원 3. 관리자 모드 4. 종료 ");
      int command = scanner.nextInt();

      if(command == 1) {
        for (int i =  0; i < MEMBER; i++) {
          System.out.println("[회원 등록]");

          System.out.println("id");
          System.out.printf("> ");
          id[i]= scanner.nextLine();

          scanner.nextLine();
          System.out.println("회원 번호: ");
          System.out.printf("> ");
          number[i]= scanner.nextLine();

          System.out.println("회원 이름: ");
          System.out.printf("> ");
          name[i] = scanner.nextLine();

          System.out.println("전호 번호: ");
          System.out.printf("> ");
          phone[i] = scanner.nextLine();

          System.out.println("주소: ");
          System.out.printf("> ");
          adress[i] = scanner.nextLine();

          System.out.println("생년 월일: ");
          System.out.printf("> ");
          birth[i] = scanner.nextLine();

          System.out.println("직업: ");
          System.out.printf("> ");
          job[i] = scanner.nextLine();

          System.out.println("성별: ");
          System.out.printf("> ");
          gender[i] = scanner.nextLine();

          System.out.println("이메일: ");
          System.out.printf("> ");
          email[i] = scanner.nextLine();

          now[i] = new java.sql.Date(System.currentTimeMillis());

          System.out.println("등록 기간: ");
          System.out.println("0: 3개월 ");
          System.out.println("1: 6개월 ");
          System.out.println("2: 12개월 ");
          status[i] = Integer.valueOf(scanner.nextLine());

          size++;
          break;
        }
      }else if(command == 2) {
        System.out.println("[기존 회원]");
        System.out.println("남은 기간: ");
        System.out.println();
        System.out.println("bmi지수 계산기 ");
        System.out.println("몸무게: ");
        System.out.printf("> ");
        double weight = scanner.nextDouble();

        System.out.println("키: ");
        System.out.printf("> ");
        double height = scanner.nextDouble();

        double bmi = weight/height/height ;
        System.out.printf("bmi 지수: %.2f\n" ,bmi);

      }else if (command ==3) {
        // 회원 목록과 남은 일수 
        System.out.println("[관리자 모드]");
        for (int i = 0; i < size; i++) {
          String status1 = null;
          switch (status[i]) {
            case 1:
              status1 = "3개월 신청";
              break;
            case 2:
              status1 = "6개월 신청";
              break;
            default :
              status1 = "12개월 신청";
              break;
          }
          System.out.printf("회원 id: %s ,회원 번호: %s ,회원 이름: %s ,전화 번호: %s ,"
              + "주소: %s ,생년 월일: %s ,주소: %s ,직업: %s ,성별: %s ,이메일: %s ,등록 기간: %s\n"
              ,   id[i], number[i], name[i], phone[i], adress[i], birth[i], job[i], gender[i] 
                  ,email[i], now[i], status1 );

        }
      }else if (command == 4) {
        System.out.println("시스템을 종료합니다. ");
        break;

      }else {
        System.out.println("잘못 입력하셨습니다. ");
        System.out.println("다시 입력해주세요. ");

      }

    }
    scanner.close();
  }
}


