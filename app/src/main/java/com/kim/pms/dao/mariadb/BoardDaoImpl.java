package com.kim.pms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kim.pms.dao.BoardDao;
import com.kim.pms.domain.Board;

public class BoardDaoImpl implements BoardDao {
  SqlSession sqlSession;

  public BoardDaoImpl(SqlSession sqlSession) throws Exception {
    this.sqlSession = sqlSession;
  }

  @Override
  public int insert(Board board) throws Exception {
    return sqlSession.insert("BoardMapper.insert", board);
  }

  @Override
  public Board findByNo(int no) throws Exception {
    return sqlSession.selectOne("BoardMapper.findByNo", no);
  }
  @Override
  public int update(Board board) throws Exception {
    return sqlSession.update("BoardMapper.update", board);
  }

  @Override
  public int updateViewCount(int no) throws Exception {
    return sqlSession.update("BoardMapper.updateViewCount",no);
  }

  @Override
  public int delete(int no) throws Exception {
    return sqlSession.delete("BoardMapper.delete", no);
  }

  @Override
  public List<Board> findByKeyword(String keyword) throws Exception {
    return sqlSession.selectList("BoardMapper.findByKeyword", keyword);
  }

}
