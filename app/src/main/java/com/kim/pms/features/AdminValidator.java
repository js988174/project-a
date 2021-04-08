package com.kim.pms.features;

import java.util.ArrayList;
import java.util.List;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminValidator {

  AdminDao adminDao;

  public AdminValidator(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  public Admin1 inputMember(String promptTitle) throws Exception {
    while (true) {
      String id = Prompt.inputString(promptTitle);
      if (id.length() == 0) {
        return null;
      }
      Admin1 m = adminDao.findById(id);
      if (m != null) {
        return m;
      }
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println();
    }
  }

  public Admin1 inputMember1(String promptTitle) throws Exception {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      }

      Admin1 m = adminDao.findByName(name);
      if (m != null) {
        return m;
      }
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println();
    }
  }

  public List<Admin1> inputMembers(String promptTitle) throws Exception{
    ArrayList<Admin1> admins = new ArrayList<>();

    while (true) {
      Admin1 admin = inputMember(promptTitle);
      if (admin == null) {
        return admins;
      } else {
        admins.add(admin);
      }
    }
  }



}
