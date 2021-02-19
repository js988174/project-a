package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;

public abstract class AbstractAdminHandler implements Command{


  public List<Admin1> adminList;

  protected AbstractAdminHandler(List<Admin1> adminList) {
    this.adminList = adminList;
  }

  public Admin1 findById(String id) {
    Admin1[] list = adminList.toArray(new Admin1[adminList.size()]);
    for (Admin1 m : list) {
      if (m.getId().equals(id)) {
        return m;
      }
    }
    return null;
  }
  public Admin1 findByName(String name) {
    Admin1[] list = adminList.toArray(new Admin1[adminList.size()]);
    for (Admin1 m : list) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    return null;
  }

}




