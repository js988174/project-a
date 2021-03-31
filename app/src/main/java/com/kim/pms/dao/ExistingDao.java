package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Existing;

public class ExistingDao {

  Connection con;

  public ExistingDao() throws Exception {
    this.con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
  }

  public int insert(Existing e) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into kim_exist(pt,r_room,r_number) values(?,?,?)");) {

      stmt.setInt(1, e.getStatus1());
      stmt.setString(2, e.getStatus2());
      stmt.setString(3, e.getNumber());

      return stmt.executeUpdate();
    }
  }

  public List<Existing> findAll() throws Exception {
    ArrayList<Existing> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select pt,r_room,r_number from kim_exist order by r_number asc");
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        Existing e = new Existing();
        e.setStatus1(rs.getInt("pt"));
        e.setStatus2(rs.getString("r_room"));
        e.setNumber(rs.getString("r_number"));

        list.add(e);
      }
    }
    return list;
  }
}
