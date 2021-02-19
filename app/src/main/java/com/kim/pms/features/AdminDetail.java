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

    System.out.println();
    System.out.printf("id: s\n" , m.getId());
    System.out.printf("회원 이름: s\n" , m.getName());
    System.out.printf("전화 번호: s\n" , m.getPhone());
    System.out.printf("주소: s\n" , m.getAdress()); 
    System.out.printf("생년 월일: s\n" , m.getBirth());
    System.out.printf("직업: s\n" , m.getJob());
    System.out.printf("성별: s\n" , m.getGender());
    System.out.printf("이메일: s\n" , m.getEmail());
    System.out.printf("가입일: s\n" , m.getNow());   
    System.out.printf("등록 기간: s\n" , m.getStatus());


  }

}



