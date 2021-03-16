package com.kim.pms.listener;

import java.util.Map;
import com.kim.context.ContextListener;

public class AppListener implements ContextListener{

  @Override
  public void contextStart(Map<String,Object> context) {
    System.out.println("프로젝트 시작");

  }

  @Override
  public void contextEnd(Map<String,Object> context) {
    System.out.println("프로젝트 종료");

  }

}
