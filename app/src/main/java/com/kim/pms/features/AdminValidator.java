package com.kim.pms.features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select id,name from kim_admin where id=?")) {


      while (true) {
        String id = Prompt.inputString(promptTitle);
        if (id.length() == 0) {
          return null;
        }
        stmt.setString(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
          if (rs.next()) {
            Admin1 admin = new Admin1();
            admin.setId(rs.getString("id"));
            admin.setName(rs.getString("name"));
            return admin;
          }
          System.out.println("등록된 회원이 아닙니다.");
          System.out.println();
        }
      }
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
