package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminUpdate extends AbstractAdminHandler {


  public AdminUpdate(List<Admin1> adminList) {
    super(adminList);
  }

  @Override
  public void service() {
    System.out.println();
    System.out.println("[회원 정보 변경]");
    String id = Prompt.inputString("id: ");

    Admin1 admin = findById(id);   
    if (admin == null) {         
      System.out.println("등록 되지 않은 아이디입니다.");
      return;
    }
    String name = Prompt.inputString(String.format("이름(%s)? ", admin.getName()));
    String adress = Prompt.inputString(String.format("변경 하실 주소(%s): ", admin.getAdress()));
    String phone = Prompt.inputString(String.format("변경 하실 번호(%s)" , admin.getPhone()));

    String input = Prompt.inputString("변경 하시겠습니까?(y/n)");

    if (input.equalsIgnoreCase("y")) {
      admin.setName(name);
      admin.setAdress(adress);
      admin.setPhone(phone);
      System.out.println("정보를 변경하였습니다.");

    }else {
      System.out.println("정보 변경을 취소하였습니다.");
    }  
  }              

}




