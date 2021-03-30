package com.kim.pms.features;
import java.util.List;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.domain.Admin1;

public class AdminList implements Command {

  AdminDao adminDao;

  public AdminList(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  @Override
  public void service() throws Exception {

    List<Admin1> list = adminDao.findAll();
    for (Admin1 m : list) {
      System.out.println("=====================================================================================");
      System.out.println("[회원 목록]");
      System.out.printf("%s, %s, %s, %s, %s, %s\n",
          m.getId(),
          m.getName(),
          m.getPhone(),
          m.getBirth(),
          m.getGender(),
          m.getAddress());
      System.out.println();

    }
  }
}





