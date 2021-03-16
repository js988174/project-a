package com.kim.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kim.context.ContextListener;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Board;
import com.kim.pms.domain.Existing;
import com.kim.util.CsvObject;

public class FileListener implements ContextListener{

  File boardFile = new File("boards.json");
  File adminFile = new File("admins.json");
  File existFile = new File("exists.json");
  File checkFile = new File("checks.json");

  List<Board> boardList;
  List<Admin1> adminList; 
  List<Existing> existList;
  List<Existing> checkList;

  @Override
  public void contextStart(Map<String,Object> context) {
    boardList = loadObjects(boardFile, Board.class);
    adminList = loadObjects(adminFile, Admin1.class);
    existList = loadObjects(existFile,Existing.class);
    checkList = loadObjects(checkFile, Existing.class);

    context.put("boardList", boardList);
    context.put("adminList", adminList);
    context.put("existList", existList);
    context.put("checkList", checkList);

  }

  @Override
  public void contextEnd(Map<String,Object> context) {
    saveObjects(boardFile, boardList);
    saveObjects(adminFile, adminList);
    saveObjects(existFile, existList);
    saveObjects(checkFile, checkList);

  }

  private <T> List<T> loadObjects(File file, Class<T> elementType) {
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
      StringBuilder stringBuilder = new StringBuilder(); 
      String str = null;
      while ((str = in.readLine()) != null) {
        stringBuilder.append(str);
      }


      Type listType = TypeToken.getParameterized(ArrayList.class, elementType).getType();

      List<T> list = new Gson().fromJson(stringBuilder.toString(), listType);

      System.out.printf("파일 %s 로딩\n", file.getName());
      return list;

    } catch (Exception e) {
      System.out.printf("파일 %s 로딩중 오류 발생\n", file.getName());
      return new ArrayList<T>();
    }

  }

  private <T extends CsvObject> void saveObjects(File file, List<T> list ) {
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
      out.write(new Gson().toJson(list));
      System.out.printf("파일 %s 저장\n", file.getName());
    } catch (Exception e) {
      System.out.printf("파일 %s 저장중 오류 발생\n", file.getName());
    }
  }

}
