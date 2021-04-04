package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Admin1;

public class AdminDao {

  Connection con;

  public AdminDao() throws Exception {
    this.con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
  }

  public int insert(Admin1 admin) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into kim_admin(id,name,phone,address,birth,gender,status) values(id(?),?,?,?,?,?,?");) {

      stmt.setString(1, admin.getId());
      stmt.setString(2, admin.getName());
      stmt.setString(3, admin.getPhone());
      stmt.setString(4, admin.getBirth());
      stmt.setString(5, admin.getGender());
      stmt.setString(6, admin.getAddress());
      stmt.setInt(7, admin.getStatus());
      return stmt.executeUpdate();
    }
  }
  public List<Admin1> findAll() throws Exception {
    ArrayList<Admin1> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select id,name,phone,birth,gender,address from kim_admin order by name asc ");
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        Admin1 admin = new Admin1();
        admin.setId(rs.getString("id"));
        admin.setName(rs.getString("name"));
        admin.setPhone(rs.getString("phone"));
        admin.setBirth(rs.getString("birth"));
        admin.setGender(rs.getString("gender"));
        admin.setAddress(rs.getString("address"));

        list.add(admin);
      }
    }
    return list;
  }


  public Admin1 findById(String Id) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from kim_admin where id=?")) {

      stmt.setString(1, Id);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {  
          return null;
        }

        Admin1 admin = new Admin1();
        admin.setId(rs.getString("id"));
        admin.setName(rs.getString("name"));
        admin.setPhone(rs.getString("phone"));
        admin.setBirth(rs.getString("birth"));
        admin.setGender(rs.getString("gender"));
        admin.setAddress(rs.getString("address"));
        admin.setNow(rs.getDate("now"));
        admin.setStatus(rs.getInt("status"));

        return admin;
      }
    }
  }


  public int update(Admin1 admin) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "update kim_admin set id=id(?),name=?,address=?,phone=? where id=?")) {
      stmt.setString(1, admin.getId());
      stmt.setString(2, admin.getName());
      stmt.setString(3, admin.getAddress());
      stmt.setString(4, admin.getPhone());
      stmt.setString(5, admin.getId());
      return stmt.executeUpdate();
    }
  }

  public int delete(String id) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from kim_admin where id=?")) {
      stmt.setString(1, id); 
      return stmt.executeUpdate();
    }
  }

  public Admin1 findByName(String name) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from kim_admin where name=?")) {
      stmt.setString(1, name);

      ResultSet rs =stmt.executeQuery();

      if (!rs.next()) {
        return null;
      }
      Admin1 admin = new Admin1();
      admin.setId(rs.getString("id"));
      admin.setName(rs.getString("name"));
      admin.setPhone(rs.getString("phone"));
      admin.setBirth(rs.getString("birth"));
      admin.setGender(rs.getString("gender"));
      admin.setAddress(rs.getString("address"));
      admin.setNow(rs.getDate("now"));
      admin.setStatus(rs.getInt("status"));

      return admin;
    }
  }
}