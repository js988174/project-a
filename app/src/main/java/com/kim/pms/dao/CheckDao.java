package com.kim.pms.dao;

import java.util.List;
import com.kim.pms.domain.Check1;

public interface CheckDao {


  public List<Check1> findAll() throws Exception;
}
