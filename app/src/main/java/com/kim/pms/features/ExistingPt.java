package com.kim.pms.features;

import com.kim.pms.dao.ExistingDao;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingPt implements Command{

  ExistingDao existDao;
  AdminValidator adminValidator;

  public ExistingPt(ExistingDao existDao) {
    this.existDao = existDao;
  }

  @Override
  public void service() throws Exception{
    Existing e = new Existing();

    System.out.println();

    String input = Prompt.inputString("PT 신청: (Y/n)");
    if (input.equalsIgnoreCase("y")) {
      e.setStatus1(Prompt.inputInt("\n0: 5회 [25만원]\n1: 10회 [45만원]\n2: 15회 [68만원]\n "
          + "pt 신청 :"));
      System.out.println();
      System.out.println("PT를 신청하셨습니다.");

    } else {
      System.out.println("등록을 취소하셨습니다.");
      return;
    }
    existDao.insert(e);

  }
}