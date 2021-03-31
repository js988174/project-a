package com.kim.pms.features;

import static java.util.Calendar.DAY_OF_MONTH;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.kim.pms.dao.CheckDao;
import com.kim.pms.domain.Check1;
import com.kim.util.Prompt;

public class Check implements Command {
  // 출석 체크를 하면 회원 이름과 시간 락커룸 신청 (랜덤 중복 안되게)  언제 왔는지 나타나게 하기


  AdminValidator adminValidator;
  CheckDao checkDao;

  public Check (CheckDao checkDao,AdminValidator adminValidator) {
    this.checkDao = checkDao;
    this.adminValidator = adminValidator;
  }

  @Override
  public void service() {
    Check1 c = new Check1();
    while (true) {
      System.out.println();
      System.out.println("===========출석 체크=============");
      c.setID1(adminValidator.inputMember("ID: (취소: 빈 문자열): "));
      if (c.getID1() == null) {
        System.out.println("아이디 입력을 취소합니다.");
        return;
      }


      System.out.println();
      String input = Prompt.inputString("입장 하시겠습니까?(y/n)");
      System.out.println();
      if (input.equalsIgnoreCase("y")) {     
        System.out.println("회원님 반갑습니다.");  
        System.out.println();
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
        System.out.println("\t" + "\t" + "[회원 출석 정보]");
        int year = 2021;
        int month = 3;
        System.out.println( "\t" + "\t" + "[ " + year +  " 년 " + month + "월" + "  ]" );
        System.out.println("-------------------------------------------------------");
        System.out.println("월\t화\t수\t목\t금\t토\t일");
        GregorianCalendar calendar = new GregorianCalendar(year,(month - 1), 1);
        int maxday = calendar.getActualMaximum((DAY_OF_MONTH));
        int week = (calendar.get(Calendar.DAY_OF_WEEK));

        if (week == 1) {
          week = 8;
        } for (int i = 1; i <= (week-2); i++) {
          System.out.print("\t");
        } for (int i = 1; i <= maxday; i++) {
          if (week <= 8) {
            System.out.print(i + "\t");
          } else {
            System.out.println();
            System.out.print(i + "\t");
            week = 2;
          }
          week += 1;
        }
        System.out.println( "\t" );
        System.out.println("-------------------------------------------------------");
      }else {
        System.out.println("취소했습니다.");
      }
      return;   
    }
  }
}

