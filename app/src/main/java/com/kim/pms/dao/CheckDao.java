package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckDao {
  Connection con;

  public CheckDao() throws Exception {
    this.con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
  }
}
