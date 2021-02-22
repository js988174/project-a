package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;

public abstract class AbstractAdminHandler implements Command{


  protected List<Admin1> adminList;

  public AbstractAdminHandler(List<Admin1> adminList) {
    this.adminList = adminList;
  }

  protected Admin1 findById(String id) {
    Admin1[] list = adminList.toArray(new Admin1[adminList.size()]);
    for (Admin1 m : list) {
      if (m.getId().equals(id)) {
        return m;
      }
    }
    return null;
  }

  protected Admin1 findByName(String name) {
    Admin1[] list = adminList.toArray(new Admin1[adminList.size()]);
    for (Admin1 m : list) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    return null;
  }

}




