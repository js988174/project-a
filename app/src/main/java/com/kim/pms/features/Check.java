package com.kim.pms.features;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;
public class Check {
  // 출석 체크를 하면 회원 이름과 시간 락커룸 신청 (랜덤 중복 안되게)  언제 왔는지 나타나게 하기


  private Admin admin;

  public Check(Admin admin) {
    this.admin = admin;
  }

  public void list() {
    Existing m = new Existing();
    while (true) {
      System.out.println();
      System.out.println("===========출석 체크=============");
      m.setID1(admin.inputMember("ID: (취소: 빈 문자열): "));
      if (m.getID1() == null) {
        System.out.println("아이디 입력을 취소합니다.");
        return;
      }


      System.out.println();
      String input = Prompt.inputString("입장 하시겠습니까?(y/n)");
      System.out.println();
      if (input.equalsIgnoreCase("y")) {     
        System.out.println("회원님 반갑습니다.");     
        System.out.println("입장시간 >");

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat now = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");  
        System.out.println(now.format(cal.getTime()));
        System.out.println();

        System.out.println("만료 기간 >");
        SimpleDateFormat finish = new SimpleDateFormat ( "yyyy-MM-dd ");  
        cal.add(Calendar.MONTH, 3);
        System.out.println(finish.format(cal.getTime()));

        System.out.println();
        System.out.println("회원 출입 날짜");

      }else {
        System.out.println("취소했습니다.");
      }
      return;   
    }
  }
}

