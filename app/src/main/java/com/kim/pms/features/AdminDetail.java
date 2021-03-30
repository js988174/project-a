package com.kim.pms.features;
import com.kim.pms.dao.AdminDao;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminDetail implements Command{

  AdminDao adminDao;

  public AdminDetail(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  @Override
  public void service() throws Exception {

    System.out.println();
    System.out.println("[회원 상세보기]");

    String name = Prompt.inputString("회원 이름: ");

    Admin1 m = adminDao.findByName(name);


    if (m == null) {
      System.out.println("해당 회원의 이름이 없습니다.");
      return;
    }

    System.out.println("=====================================================================================");
    System.out.printf("회원 ID: %s\n", m.getId());
    System.out.printf("회원 이름: %s\n", m.getName());
    System.out.printf("전화 번호: %s\n", m.getPhone());
    System.out.printf("생년 월일: %s\n", m.getBirth());
    System.out.printf("성별: %s\n", m.getGender());
    System.out.printf("주소: %s\n", m.getAddress());
    System.out.printf("등록 날짜: %s\n", m.getNow());
    System.out.printf("등록 기간: %s\n", Admin1.getStatusLabel(m.getStatus()));
  }
}





