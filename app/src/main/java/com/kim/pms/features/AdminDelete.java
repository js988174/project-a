package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminDelete extends AbstractAdminHandler {


  public AdminDelete(List<Admin1> adminList) {
    super(adminList);

  }

  @Override
  public void service() {
    System.out.println();
    System.out.println("[회원 정보 삭제]");

    String id = Prompt.inputString("id: ");

    Admin1 admin = findById(id);

    if (admin == null) {
      System.out.println("등록 되지 않은 아이디입니다.");
      return;
    }
    String input = Prompt.inputString("회원 정보를 삭제하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      adminList.remove(admin);
      System.out.println("회원을 삭제하였습니다.");
    }else {
      System.out.println("회원 정보 삭제를 취소하였습니다.");
    }
  }

}




