package com.kim.pms.features;

import com.kim.pms.dao.ExistingDao;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingPt implements Command{

  ExistingDao existDao;

  public ExistingPt(ExistingDao existDao) {
    this.existDao = existDao;
  }

  @Override
  public void service() {
    Existing m = new Existing();

    System.out.println();
    String input = Prompt.inputString("pt 신청(y/n)");

    if (input.equalsIgnoreCase("y")) {
      m.setStatus1(Prompt.inputInt("\n0: 5회 [25만원]\n1: 10회 [45만원]\n2: 15회 [68만원]\n "
          + "pt 신청 :"));
      System.out.println();

      System.out.println("pt를 신청하셨습니다.");
    }
    existList.add(m);
  }


}