package com.kim.pms.dao.mariadb;


import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.domain.Admin1;

public class AdminDaoImpl implements AdminDao{
  SqlSession sqlSession;

  public AdminDaoImpl(SqlSession sqlSession) throws Exception {
    this.sqlSession = sqlSession;
  }


  @Override
  public int insert(Admin1 admin) throws Exception {
    int count = sqlSession.insert("AdminMapper.insert", admin);
    sqlSession.commit();
    return count;
  }
  @Override
  public List<Admin1> findAll() throws Exception {
    return sqlSession.selectList("AdminMapper.findAll");
  }

  @Override
  public Admin1 findById(String id) throws Exception {
    return sqlSession.selectOne("AdminMapper.findById", id);
  }


  @Override
  public int update(Admin1 admin) throws Exception {
    int count = sqlSession.update("AdminMapper.update", admin);
    sqlSession.commit();
    return count;
  }

  @Override
  public int delete(String id) throws Exception {
    int count = sqlSession.delete("AdminMapper.delete", id);
    sqlSession.commit();
    return count;
  }

  @Override
  public Admin1 findByName(String name) throws Exception {
    return sqlSession.selectOne("AdminMapper.findByName", name);
  }
  @Override
  public Admin1 findByNo(int no) throws Exception {
    return sqlSession.selectOne("AdminMapper.findByNo", no);
  }
}
