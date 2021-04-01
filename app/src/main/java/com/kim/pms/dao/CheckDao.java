package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Check1;

public class CheckDao {
  Connection con;

  public CheckDao() throws Exception {
    this.con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
  }

  public List<Check1> findAll() throws Exception {
    ArrayList<Check1> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + "c.cdt,"
            + "from kim_Check c");
        ResultSet rs =stmt.executeQuery()) {

      while (rs.next()) {
        Check1 c = new Check1();
        c.setRegisterDate(rs.getDate("cdt"));
        list.add(c);
      }
    }
    return list;
  }
}
