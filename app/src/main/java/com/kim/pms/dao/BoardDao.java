package com.kim.pms.dao;

import java.util.List;
import com.kim.pms.domain.Board;

public interface BoardDao {


  int insert(Board board) throws Exception;

  List<Board> findByKeyword(String keyword) throws Exception;

  Board findByNo(int no) throws Exception; 

  int update(Board board) throws Exception; 

  int updateViewCount(int no) throws Exception; 

  int delete(int no) throws Exception;



}
