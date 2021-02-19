package com.kim.pms.features;

import java.util.List;
import com.kim.pms.domain.Existing;

public abstract class AbstractExistingHandler implements Command{


  protected List<Existing> existingList;

  public AbstractExistingHandler(List<Existing> existingList) {
    this.existingList = existingList;
  }

  protected Existing findById(String id) {
    Existing[] list = existingList.toArray(new Existing[existingList.size()]);
    for (Existing m : list) {
      if (m.getID1().equals(id)) {
        return m;
      }
    }
    return null;
  }


  protected String getStatus(int status) {
    switch (status) {
      case 1:
        return "10회 [45만원]";
      case 2:
        return "15회 [68만원]";
      default:
        return "1회 [5만원]";
    }
  }
  protected String getStatus1(int status) {
    switch (status) {
      case 1:
        return "6개월 [5.5만원]";
      case 2:
        return "12개월 [10만원]";
      default:
        return "3개월 [1만원]";
    }
  }
}
