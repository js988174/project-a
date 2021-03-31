package com.kim.pms.features;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminUpdate implements Command {

  AdminDao adminDao;

  public AdminUpdate(AdminDao adminDao) {
    this.adminDao = adminDao;
  }


  @Override
  public void service() throws Exception {
    System.out.println();
    System.out.println("[회원 정보 변경]");

    String id = Prompt.inputString("ID: ");

    Admin1 admin = adminDao.findById(id);  

    if (admin == null) {
      System.out.println("해당 ID의 회원이 없습니다.");
      return;
    }

    admin.setId(Prompt.inputString("new ID:"));
    admin.setName(Prompt.inputString(String.format("이름(%s): ", admin.getName())));
    admin.setAddress(Prompt.inputString(String.format("변경 하실 주소(%s): ", admin.getAddress())));
    admin.setPhone(Prompt.inputString(String.format("변경 하실 번호(%s):" , admin.getPhone())));

    String input = Prompt.inputString("변경 하시겠습니까?(y/n)");
    if (!input.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    adminDao.update(admin);

    System.out.println("회원 정보를 변경하였습니다.");
  }
}






