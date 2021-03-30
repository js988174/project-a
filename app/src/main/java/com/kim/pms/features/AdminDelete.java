package com.kim.pms.features;
import com.kim.pms.dao.AdminDao;
import com.kim.util.Prompt;

public class AdminDelete implements Command {

  AdminDao adminDao;

  public AdminDelete(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  @Override
  public void service() throws Exception{
    System.out.println();
    System.out.println("[회원 정보 삭제]");

    String id = Prompt.inputString("id: ");

    String input = Prompt.inputString("회원 정보를 삭제하시겠습니까?(y/n)");

    if (!input.equalsIgnoreCase("y")) {
      System.out.println("회원 정보 삭제를 취소하였습니다.");
      return;
    }


    if (adminDao.delete(id) == 0) {
      System.out.println("해당 ID의 회원이 없습니다.");
    } else {
      System.out.println("회원을 삭제하엿습니다.");
    }
  }
}





