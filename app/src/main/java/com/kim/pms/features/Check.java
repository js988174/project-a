package com.kim.pms.features;

import java.text.SimpleDateFormat;
import com.kim.pms.domain.Existing;
import com.kim.util.List;
import com.kim.util.Prompt;
public class Check {



  List adminList;

  public Check(List adminList) {
    this.adminList = adminList;
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
      } else if  (m.getID1().equals(id)) {   
        adminList.add(id);
        System.out.println("로그인 되었습니다.");
        break;     
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }                

    System.out.println();
    String input = Prompt.inputString("입장 하시겠습니까?(y/n)");
    System.out.println();
    if (input.equalsIgnoreCase("y")) {     
      System.out.println("회원님 반갑습니다.");
      System.out.println("입장시간 >");
      SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");            
      String format_time1 = format.format (System.currentTimeMillis());                                       
      System.out.println(format_time1);

    }else {
      System.out.println("취소했습니다.");
    }
    return;   
  }

}

