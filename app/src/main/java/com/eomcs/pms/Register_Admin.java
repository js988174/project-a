package com.eomcs.pms;
import java.sql.Date;
import java.util.Random;

public class Register_Admin {

  static Random random = new Random();
  static final int MEMBER = 1000;
  static String[] id = new String[MEMBER];
  static int[] number = new int[1];
  static String[] name = new String[MEMBER];
  static String[] phone = new String[MEMBER];
  static String[] adress = new String[MEMBER];
  static String[] birth = new String[MEMBER];
  static String[] job = new String[MEMBER];
  static String[] gender = new String[MEMBER];
  static String[] email = new String[MEMBER];
  static Date[] now = new Date[MEMBER];
  static int[] status = new int[MEMBER];
  static int size = 0;

  static void add1() {
    System.out.println();
    System.out.println("[회원 등록]");

    System.out.println("회원 번호 지정: ");
    System.out.printf("> ");
    for (int j = 0; j < number.length; j++) {
      number[j] = random.nextInt(1000)+1;
      System.out.println(number[j]);
    }

    System.out.println();
    id[size]= Prompt.inputString("id: ");
    name[size] = Prompt.inputString("회원 이름: ");
    phone[size] = Prompt.inputString("전화 번호: ");
    adress[size] = Prompt.inputString("주소: ");
    birth[size] = Prompt.inputString("생년 월일: ");
    job[size] = Prompt.inputString("직업: ");
    gender[size] = Prompt.inputString("성별: ");
    email[size] =Prompt.inputString("이메일: ");
    now[size] = new java.sql.Date(System.currentTimeMillis());
    status[size] = Prompt.inputInt("등록기간:\n0: 3개월\n1: 6개월\n2: 12개월\n>");

    size++;
  }

  static void add3() {
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
      System.out.printf("회원 id: %s ,회원 번호: %d ,회원 이름: %s ,전화 번호: %s ,"
          + " 주소: %s ,생년 월일: %s  ,직업: %s ,성별: %s ,이메일: %s ,등록 날짜: %s ,등록 기간: %s\n"
          ,  id[i], number[i], name[i], phone[i], adress[i], birth[i] , job[i], gender[i] 
              ,email[i], now[i], status1 );
    }

  }
}

