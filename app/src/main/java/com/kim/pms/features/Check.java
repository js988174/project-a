package com.kim.pms.features;

import java.text.SimpleDateFormat;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;

public class Check {
  static final int MEMBER_NUMBER = 1000;

  Register[] members = new Register[MEMBER_NUMBER];
  int size = 0;

  Register registerList;

  public Check(Register registerHandler) {
    this.registerList = registerHandler;
  }

  public void list() {
    Existing m = new Existing();
    while (true) {
      System.out.println();
      System.out.println("===========출석 체크=============");
      String id = Prompt.inputString("ID: (취소: 빈 문자열)");
      if (id.length() == 0) {
        System.out.println("ID입력을 취소합니다.");
        return;
      } else if (this.registerList.exist(id)) {   
        m.ID1 = id;    

        break;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }                
    System.out.println();
    String input = Prompt.inputString("입장 하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {     
      System.out.println("회원님 반갑습니다.");
      SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");            
      String format_time1 = format.format (System.currentTimeMillis());                                       
      System.out.println(format_time1);

    }else {
      System.out.println("취소했습니다.");
    }
    return;   
  }

}
