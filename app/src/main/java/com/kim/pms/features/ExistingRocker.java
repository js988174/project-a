package com.kim.pms.features;

import java.util.Random;
import com.kim.pms.dao.ExistingDao;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingRocker implements Command {

  ExistingDao existDao;
  AdminValidator adminValidator;

  public ExistingRocker(ExistingDao existDao) {
    this.existDao = existDao;

  }

  @Override
  public void service() throws Exception{
    Existing e = new Existing();

    System.out.println();

    e.setStatus2(Prompt.inputString("락커룸 신청(y/n) : 10000원[1개월]"));
    if (e.getStatus2().equalsIgnoreCase("y")) {   

      int Number[] = new int[1];
      Random r = new Random();
      for (int i = 0; i < Number.length; i ++) {
        Number[i] = r.nextInt(150)+1;
        for (int j = 0; j < i; j++) {
          if (Number[i] ==Number[j]) {
            i--;
            break;
          }
        }
        System.out.println();
        System.out.printf("> ");
        System.out.printf("락커룸 번호: %d\n ", Number[i]);
      }
    } else {
      System.out.println("등록을 취소하였습니다.");
      return;
    }
    existDao.insert(e);
  }

}