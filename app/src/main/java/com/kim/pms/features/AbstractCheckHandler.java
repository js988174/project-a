package com.kim.pms.features;

import java.util.List;
import com.kim.pms.domain.Check1;

public abstract class AbstractCheckHandler implements Command {

  protected List<Check1> checkList;

  public AbstractCheckHandler(List<Check1> checkList) {
    this.checkList = checkList;
  }



  protected Check1 findById(String id) {
    Check1[] list = checkList.toArray(new Check1[checkList.size()]);
    for (Check1 c : list) {
      if (c.getID1().equals(id)) {
        return c;
      }
    }
    return null;
  }
}
