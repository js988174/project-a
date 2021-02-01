package com.kim.pms.features;
import java.util.Random;
import java.util.Scanner;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class Admin {
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();

  public AdminList adminList = new AdminList();

  /*System.out.println();  로그인 메서드
  System.out.println("[관리자 모드]"); 

  System.out.print("id: ");
  String ID = scanner.nextLine();
  System.out.print("password: ");
  String PW = scanner.nextLine();
  String id1 = "admin";
  String pass = "1234";

  if(ID.equals(id1) && PW.equals(pass)){
    System.out.println("로그인 성공 ");

  }else {
    System.out.println("로그인 실패");
  }
   */

  public void service() {

    while(true) {
      System.out.println();
      System.out.println("===============[관리자]================");
      System.out.println("[1] 회원 정보 목록");
      System.out.println("[2] 회원 정보 수정");
      System.out.println("[3] 회원 삭제");
      System.out.println("[4] 메뉴로 돌아가기");
      System.out.println("=======================================");
      String command1 = Prompt.inputString("번호를 선택해주세요: ");
      System.out.println();
      switch(command1) {
        case "1" :      
          this.list();
          break;      
        case "2" :   
          this.update();
          break;
        case "3" :
          this.delete();
          break;
        case "4" : 
          System.out.println();
          System.out.println("메뉴로 돌아갑니다.");
          return;
        default :
          System.out.println();
          System.out.println("잘못 입력하셨습니다. ");
          System.out.println("다시 입력해주세요. ");
          System.out.println();
          break;

      }      
      System.out.println();
    }
  }    

  public void add() {
    Admin1 m = new Admin1();

    System.out.println();
    System.out.println("[회원 등록]");

    System.out.println("회원 락커룸 지정: ");
    System.out.printf("> ");
    m.number = random.nextInt(150)+1;
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
    m.status = Prompt.inputInt("등록기간:\n0: 3개월[5만원]\n1: 6개월[8만원]\n2: 12개월[15만원]\n>");

    adminList.add(m);
    System.out.println("회원을 등록하였습니다.");
  }
  public void list() {

    Admin1[] admins = adminList.toArray();
    for (Admin1 m : admins) {

      String status1 = null;
      switch (m.status) {
        case 1:
          status1 = "6개월 신청[8만원]";
          break;
        case 2:
          status1 = "12개월 신청[15만원]";
          break;
        default :
          status1 = "3개월 신청[5만원]";
          break;
      }
      System.out.printf("회원 id: %s ,회원 번호: %d ,회원 이름: %s ,전화 번호: %s ,"
          + " 주소: %s ,생년 월일: %s  ,직업: %s ,성별: %s ,이메일: %s ,등록 날짜: %s ,등록 기간: %s\n"
          ,  m.id, m.number, m.name, m.phone, m.adress, m.birth , m.job, m.gender 
          ,m.email, m.now, status1 );
    }
  }
  public void update() {
    System.out.println();
    System.out.println("[회원 정보 변경]");
    String id = Prompt.inputString("id: ");

    Admin1 admin = adminList.get(id);   
    if (admin == null) {         
      System.out.println("등록 되지 않은 아이디입니다.");
      return;
    }
    String name = Prompt.inputString(String.format("이름(%s)? ", admin.name));
    String adress = Prompt.inputString(String.format("변경 하실 주소(%s): ", admin.adress));
    String phone = Prompt.inputString(String.format("변경 하실 번호(%s)" , admin.phone));

    String input = Prompt.inputString("변경 하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      admin.name = name;
      admin.adress = adress;
      admin.phone = phone;
      System.out.println("정보를 변경하였습니다.");

    }else {
      System.out.println("정보 변경을 취소하였습니다.");
    }  
  }              

  public void delete() {
    System.out.println();
    System.out.println("[회원 정보 삭제]");

    String id = Prompt.inputString("id: ");

    Admin1 admin = adminList.get(id);

    if (admin == null) {
      System.out.println("등록 되지 않은 아이디입니다.");
      return;
    }
    String input = Prompt.inputString("회원 정보를 삭제하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      adminList.delete(id);
      System.out.println("회원을 삭제하였습니다.");
    }else {
      System.out.println("회원 정보 삭제를 취소하였습니다.");
    }

  }

}




