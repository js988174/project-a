package com.kim.pms.dao;

import java.util.List;
import com.kim.pms.domain.Admin1;

public interface AdminDao {


  int insert(Admin1 admin) throws Exception;

  List<Admin1> findAll() throws Exception;

  Admin1 findById(String Id) throws Exception; 

  int update(Admin1 admin) throws Exception;

  int delete(String id) throws Exception;

  Admin1 findByName(String name) throws Exception;



}