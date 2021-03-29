package com.kim.pms.features;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminAdd implements Command {


  @Override
  public void service() throws Exception{

    System.out.println();
    System.out.println("[회원 등록]");

    Admin1 m = new Admin1();

    System.out.println();
    m.setId(Prompt.inputString("ID: "));
    m.setName(Prompt.inputString("회원 이름: "));
    m.setPhone(Prompt.inputString("전화 번호: "));
    m.setAddress(Prompt.inputString("주소: "));
    m.setBirth(Prompt.inputString("생년 월일: "));
    m.setGender(Prompt.inputString("성별: "));
    m.setNow(new java.sql.Date(System.currentTimeMillis()));
    m.setStatus(Prompt.inputInt("등록기간:\n0: 3개월[5만원]\n1: 6개월[8만원]\n2: 12개월[15만원]\n>"));

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user/root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into kim_admin(id,name,phone,address,birth,gender,now,status)"
                + "values(id(?),?,?,?,?,?,?,?");) {

      stmt.setString(1, m.getId());
      stmt.setString(2, m.getName());
      stmt.setString(3, m.getPhone());
      stmt.setString(4, m.getAddress());
      stmt.setString(5, m.getBirth());
      stmt.setString(6, m.getGender());
      stmt.setDate(7, m.getNow());
      stmt.setInt(8, m.getStatus());

      stmt.executeUpdate();

      System.out.println("회원을 등록하였습니다.");

    }
  }
}




