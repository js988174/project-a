package com.kim.pms.features;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kim.pms.domain.Admin1;

public class AdminList implements Command {


  @Override
  public void service() throws Exception {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select id,name,phone,birth,gender,address,now,status from kim_admin order by name asc");
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {

        System.out.println("=====================================================================================");
        System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n",
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("phone"),
            rs.getString("birth"),
            rs.getString("gender"),
            rs.getString("address"),
            rs.getDate("now"),
            Admin1.getStatus(rs.getInt("status")));
        System.out.println();

      }
    }
  }
}




