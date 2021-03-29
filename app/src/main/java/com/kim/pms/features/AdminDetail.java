package com.kim.pms.features;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminDetail implements Command{



  @Override
  public void service() throws Exception {

    System.out.println();
    System.out.println("[회원 상세보기]");

    String name = Prompt.inputString("회원 이름: ");

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select * from kim_admin where name = ?")) {

      stmt.setString(1, name);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          System.out.println("해당 회원의 이름이 없습니다.");
          return;
        }
        System.out.println("=====================================================================================");
        System.out.printf("회원 ID: %s\n", rs.getString("id"));
        System.out.printf("회원 이름: %s\n", rs.getString("name"));
        System.out.printf("전화 번호: %s\n", rs.getString("phone"));
        System.out.printf("생년 월일: %s\n", rs.getString("birth"));
        System.out.printf("성별: %s\n", rs.getString("gender"));
        System.out.printf("주소: %s\n", rs.getString("address"));
        System.out.printf("등록 날짜: %s\n", rs.getDate("now"));
        System.out.printf("등록 기간: %s\n", Admin1.getStatus(rs.getInt("status")));
      }
    }

  }

}



