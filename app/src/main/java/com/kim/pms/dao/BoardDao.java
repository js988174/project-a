package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Board;

public class BoardDao {
  Connection con;

  public BoardDao() throws Exception {
    this.con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/myproject?user=root&password=1111");
  }

  public int insert(Board board) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert int kim_board(title, content, writer) values(?,?,?)");) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getWriter().getno());

      return stmt.executeUpdate();
    }
  }

  public List<Board> findAll() throws Exception {
    ArrayList<Board> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select"))
  }
}
