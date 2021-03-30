package com.kim.pms.features;

import java.util.Iterator;
import java.util.List;
import com.kim.pms.domain.Existing;


public class ExistingList extends AbstractExistingHandler{


  public ExistingList(List<Existing> existList) {
    super(existList);

  }


  @Override
  public void service() {

    Iterator<Existing> iterator = existList.iterator();

    while (iterator.hasNext()) {
      Existing m = iterator.next();

      System.out.println();
      System.out.println("[신청 목록]");
      System.out.printf("PT: %s,락커룸 한달: %s\n", getStatus(m.getStatus1()),m.getStatus2());

      System.out.println();
    }        

  }
}