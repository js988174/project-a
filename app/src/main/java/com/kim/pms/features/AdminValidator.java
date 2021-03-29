package com.kim.pms.features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kim.util.Prompt;

public class AdminValidator {



  public String inputMember(String promptTitle) throws Exception {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select id,name from kim_admin where id=?")) {


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
