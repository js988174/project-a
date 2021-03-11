package com.kim.pms.features;

import java.util.Iterator;
import java.util.List;
import com.kim.pms.domain.Existing;


public class ExistingList extends AbstractExistingHandler{


  private Iterator<Existing> iterator1;
  private Iterator<Existing> iterator;

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
      System.out.printf("pt 신청번호: %s\n", getStatus(m.getStatus()));

      System.out.println();
      System.out.printf("락커룸 기간 : %s\n " , getStatus1(m.getStatus1()));
    }        

  }
}