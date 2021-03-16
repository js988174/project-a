package com.kim.context;

import java.util.Map;

public interface ContextListener {

  void contextStart(Map<String,Object> context); 

  void contextEnd(Map<String,Object> context); 


}
