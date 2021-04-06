package com.kim.pms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kim.pms.domain.Check1;

public class CheckDaoImpl {
  SqlSession sqlSession;

  public CheckDaoImpl(SqlSession sqlSession) throws Exception {
    this.sqlSession = sqlSession;
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
