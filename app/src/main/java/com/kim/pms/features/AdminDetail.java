package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminDetail extends AbstractAdminHandler{


  public AdminDetail(List<Admin1> adminList) {
    super(adminList);

  }

  @Override
  public void service() {

    System.out.println();
    System.out.println("[회원 상세보기]");

    String name = Prompt.inputString("회원 이름: ");

    Admin1 m = findByName(name);
    if (m == null) {
      System.out.println("해당 회원의 이름이 없습니다.");
      return;
    }

    System.out.println("=====================================================================================");
    System.out.printf("회원 id: %s ,회원 이름: %s ,전화 번호: %s\n ",  m.getId(), m.getName(), m.getPhone());
    System.out.printf("생년 월일: %s,성별: %s 주소: %s\n ",m.getBirth(), m.getGender(), m.getAdress());
    System.out.printf("등록 날짜: %s ,등록 기간: %s\n" ,m.getNow(), m.getStatus() );
    System.out.println();

  }

}



