package com.kim.pms.features;
import java.util.Random;
import java.util.Scanner;
import com.kim.pms.domain.Register;
import com.kim.util.Prompt;

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
    m.status = Prompt.inputInt("등록기간:\n0: 3개월\n1: 6개월\n2: 12개월\n>");

    this.members[this.size++] = m;
  }

  public void add5() {

    System.out.println("[관리자 모드]"); 

    System.out.print("id: ");
    String ID = scanner.nextLine();
    System.out.print("password: ");
    String PW = scanner.nextLine();
    String id1 = "admin";
    String pass = "1234";

    if(ID.equals(id1) && PW.equals(pass)){
      System.out.println("로그인 성공 ");


      while(true) {
        System.out.println();
        System.out.println("[1]  회원 정보 목록 [2] 회원 정보 수정 [3] 회원 삭제  [4] 메뉴로 돌아가기 ");
        String command1 = Prompt.inputString("번호를 선택해주세요: ");

        switch(command1) {
          case "1" :      
            for (int i = 0; i < this.size; i++) {
              Register m = this.members[i];

              String status1 = null;
              switch (m.status) {
                case 1:
                  status1 = "6개월 신청";
                  break;
                case 2:
                  status1 = "12개월 신청";
                  break;
                default :
                  status1 = "3개월 신청";
                  break;
              }
              System.out.printf("회원 id: %s ,회원 번호: %d ,회원 이름: %s ,전화 번호: %s ,"
                  + " 주소: %s ,생년 월일: %s  ,직업: %s ,성별: %s ,이메일: %s ,등록 날짜: %s ,등록 기간: %s\n"
                  ,  m.id, m.number, m.name, m.phone, m.adress, m.birth , m.job, m.gender 
                  ,m.email, m.now, status1 );
            }
            break;      
          case "2" :   
            System.out.println();
            System.out.println("[회원 정보 수정]");
            String id = Prompt.inputString("id: ");

            for (int i = 0; i < this.size; i ++) {
              Register m = this.members[i];
              if (m.id == id) {               
                String adress = Prompt.inputString(String.format("변경 하실 주소(%s): ", m.adress));
                String phone = Prompt.inputString(String.format("변경 하실 번호(%s)" , m.phone));

                String input = Prompt.inputString("수정 하시겠습니까?(y/n)");

                if (input.equalsIgnoreCase("y")) {
                  m.adress = adress;
                  m.phone = phone;
                  System.out.println("정보를 수정하였습니다.");
                }else {
                  System.out.println("정보 수정을 취소하였습니다.");
                }
                return;
              }
            }              
            System.out.println("등록 되지 않은 아이디입니다.");

            break;
          case "3" :
            System.out.println();
            System.out.println("[회원 정보 삭제]");

            String id11 = Prompt.inputString("id: ");

            for (int i = 0; i < size; i++) {
              Register m = members[i];
              if (m.id == id11) {
                String input = Prompt.inputString("회원 정보를 삭제하시겠습니까?(y/n)");

                if (input.equalsIgnoreCase("y")) {
                  members[i] = null;
                  System.out.println("회원을 삭제하였습니다.");
                }else {
                  System.out.println("회원 정보 삭제를 취소하였습니다.");
                }
                return;
              }
            }
            System.out.println("등록 되지 않은 아이디입니다.");
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

