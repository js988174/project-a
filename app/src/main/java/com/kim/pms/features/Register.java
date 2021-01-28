package com.kim.pms.features;

import java.util.Random;
import java.util.Scanner;
import com.kim.pms.domain.Register1;
import com.kim.util.Prompt;

public class Register {

  static Random random = new Random();
  static Scanner scanner = new Scanner(System.in);


  static final int MEMBER_NUMBER = 1000;

  Register1[] register1 = new Register1[MEMBER_NUMBER];
  int size = 0;

  public void add() {
    Register1 m = new Register1();

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

    this.register1[this.size++] = m;
  }

  public boolean exist(String id) {
    for (int i = 0; i < this.size; i++) {
      if (id.equals(this.register1[i].id)) {
        return true;
      }
    }
    return false;
  }
}
