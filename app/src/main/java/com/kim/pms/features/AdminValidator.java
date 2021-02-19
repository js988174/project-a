package com.kim.pms.features;

import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminValidator extends AbstractAdminHandler{

  public AdminValidator(List<Admin1> adminList) {
    super(adminList);

  }

  @Override
  public void service() {

  }

  public String inputMember(String promptTitle) {
    while (true) {
      String id = Prompt.inputString(promptTitle);
      if (id.length() == 0) {
        return null;
      }
      if (findById(id) != null) {
        return id;
      }
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println();
    }
  }
  public String inputMembers(String promptTitle) {
    String members = "";
    while (true) {
      String id = inputMember(promptTitle);
      if (id == null) {
        return members;
      } else {
        if (!members.isEmpty()) {
          members += ",";
        }
        members += id;
      }
    }
  }

  public String inputMember1(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      }
      if (findById(name) != null) {
        return name;
      }
      System.out.println("등록된 회원이 아닙니다.");
      System.out.println();
    }
  }
  public String inputMembers1(String promptTitle) {
    String members = "";
    while (true) {
      String name = inputMember(promptTitle);
      if (name == null) {
        return members;
      } else {
        if (!members.isEmpty()) {
          members += ",";
        }
        members += name;
      }
    }
  }

}
