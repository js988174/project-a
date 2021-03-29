package com.kim.pms.features;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.kim.util.Prompt;

public class AdminDelete implements Command {


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

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "delete from kim_admin where id=?")) {

      stmt.setString(1, id); 
      if (stmt.executeUpdate() == 0) {
        System.out.println("해당 ID의 회원이 없습니다.");
      } else {
        System.out.println("회원을 삭제하엿습니다.");
      }
    }
  }

}




