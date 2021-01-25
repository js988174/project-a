package com.eomcs.pms.features;
import java.util.Random;
import java.util.Scanner;
import com.eomcs.pms.domain.Register;
import com.eomcs.util.Prompt;

public class Register_Admin {

  static Random random = new Random();
  static Scanner scanner = new Scanner(System.in);


  static final int MEMBER_NUMBER = 1000;

  Register[] members = new Register[MEMBER_NUMBER];
  int size = 0;

  public void add1() {
    Register m = new Register();

    System.out.println();
    System.out.println("[회원 등록]");

    System.out.println("회원 번호 지정: ");
    System.out.printf("> ");
    m.number = random.nextInt(1000)+1;
    System.out.println(m.number);



    System.out.println();
    m.id = Prompt.inputString("id: ");
    m.name = Prompt.inputString("회원 이름: ");
    m.phone = Prompt.inputString("전화 번호: ");
    m.adress = Prompt.inputString("주소: ");
    m.birth = Prompt.inputString("생년 월일: ");
    m.job = Prompt.inputString("직업: ");
    m.gender = Prompt.inputString("성별: ");
    m.email =Prompt.inputString("이메일: ");
    m.now = new java.sql.Date(System.currentTimeMillis());
    m.status = Prompt.inputInt("등록기간:\n0: 3개월\n1: 6개월\n2: 12개월\n>");

    this.members[this.size++] = m;
  }

  public void add4() {
    // 회원 목록과 남은 일수 
    System.out.println("[관리자 모드]"); 

    // 관리자 로그인 하여 회원 삭제
    System.out.print("id: ");
    String ID = scanner.nextLine();
    System.out.print("password: ");
    String PW = scanner.nextLine();
    String id = "admin";
    String pass = "1234";

    if(ID.equals(id) && PW.equals(pass)){
      System.out.println("로그인 성공 ");

      for (int i = 0; i < size; i++) {
        Register m = this.members[i];

        String status1 = null;
        switch (m.status) {
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
            ,  m.id, m.number, m.name, m.phone, m.adress, m.birth , m.job, m.gender 
            ,m.email, m.now, status1 );
      }
    }else {
      System.out.println("로그인 실패");
    }



  }
  public boolean exist(String id) {
    for (int i = 0; i < this.size; i++) {
      if (id.equals(this.members[i].id)) {
        return true;
      }
    }
    return false;
  }

}

