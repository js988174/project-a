package com.kim.pms.dao;

import java.util.List;
import com.kim.pms.domain.Existing;

public interface ExistingDao {



  public int insert(Existing e) throws Exception; 

  public List<Existing> findAll() throws Exception;
}
