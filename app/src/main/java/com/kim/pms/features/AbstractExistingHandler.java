package com.kim.pms.features;

import java.util.List;
import com.kim.pms.domain.Existing;

public abstract class AbstractExistingHandler implements Command{


  protected List<Existing> existList;

  public AbstractExistingHandler(List<Existing> existList) {
    this.existList = existList;
  }

  protected Existing findById(String id) {
    Existing[] list = existList.toArray(new Existing[existList.size()]);
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
        return "5회 [25만원]";
    }
  }
}
