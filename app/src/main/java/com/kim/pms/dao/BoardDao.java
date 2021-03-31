package com.kim.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Admin1;
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
      stmt.setString(3, board.getWriter().getName());

      return stmt.executeUpdate();
    }
  }

  public List<Board> findAll() throws Exception {
    ArrayList<Board> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + "b.no,"
            +"b.title,"
            +"b.cdt,"
            +"b.vw_cnt,"
            +"b.like_cnt,"
            +"a.name as writer_name"
            +"from kim_board b"
            +"inner join kim_admin a on a.name=b.writer"
            +"order by b.no desc");
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setNow(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        Admin1 writer = new Admin1();
        writer.setName(rs.getString("writer_name"));
        board.setWriter(writer);

        list.add(board);
      }
    }
    return list;
  }

  public Board findByNo(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + "b.no,"
            +"b.title,"
            +"b.cdt,"
            +"b.vw_cnt,"
            +"b.like_cnt,"
            +"a.name as writer_name"
            +"from kim_board b"
            +"inner join kim_admin a on a.name=b.writer"
            +"where b.no =?")) {


      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }
        Board board = new Board();
        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setNow(new Date(rs.getTimestamp("cdt").getTime()));
        board.setViewCount(rs.getInt("vw_cnt"));
        board.setLike(rs.getInt("like_cnt"));

        Admin1 writer = new Admin1();
        writer.setName(rs.getString("writer_name"));
        board.setWriter(writer);

        return board;
      }
    }
  }
  public int update(Board board) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement( 
        "update kim_board set title=?, content=? where no=?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      return stmt.executeUpdate();

    }
  }

  public int updateViewCount(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "update kim_board set vw_cnt=vw_cnt +1 where no=?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }
  public int delete(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from kim_board where no=?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }
  public List<Board> findByKeyword(String keyword) throws Exception {
    ArrayList<Board> list = new ArrayList<>();

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + "b.no,"
            +"b.title,"
            +"b.cdt,"
            +"b.vw_cnt,"
            +"b.like_cnt,"
            +"a.name as writer_name"
            +"from kim_board b"
            +"inner join kim_admin a on a.name=b.writer"
            +" where b.title like concat('%',?,'%')"
            + "   or b.content like concat('%',?,'%')"
            + "   or a.name like concat('%',?,'%')"
            +"order by b.no desc")) {

      stmt.setString(1, keyword);
      stmt.setString(2, keyword);
      stmt.setString(3, keyword);

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setNow(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        Admin1 writer = new Admin1();
        writer.setName(rs.getString("writer_name"));
        board.setWriter(writer);

        list.add(board);
      }
    }

    return list;

  }

}
