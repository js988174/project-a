package com.kim.pms.features;

import java.util.List;
import java.util.Random;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingRocker extends AbstractExistingHandler {


  public ExistingRocker(List<Existing> existList) {
    super(existList);
  }


  @Override
  public void service() {
    Existing m = new Existing();

    System.out.println();
    String input = Prompt.inputString("락커룸 신청(y/n)");

    if (input.equalsIgnoreCase("y")) {
      m.setStatus2(Prompt.inputInt("\n0: 3개월 [1만원]\n1: 6개월 [5.5만원]\n2: 12개월 [10만원]\n "
          + "락커룸 신청 :"));
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
    }
    existList.add(m);
  }


}