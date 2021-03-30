package com.kim.pms.features;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select * from kim_admin where id=?");
        PreparedStatement stmt2 = con.prepareStatement(
            "update kim_admin set id=id(?),name=?,address=?,phone=? where id=?")) {

      Admin1 admin = new Admin1();

      stmt.setString(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          System.out.println("해당 ID의 회원이 없습니다.");
          return;
        }
        admin.setId("id");
        admin.setName(rs.getString("name"));
        admin.setAddress(rs.getString("address"));
        admin.setPhone(rs.getString("phone"));     
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
      stmt2.setString(1, admin.getId());
      stmt2.setString(2, admin.getName());
      stmt2.setString(3, admin.getAddress());
      stmt2.setString(4, admin.getPhone());
      stmt2.executeUpdate();

      System.out.println("회원 정보를 변경하였습니다.");
    }
  }
}              





