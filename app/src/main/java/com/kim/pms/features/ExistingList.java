package com.kim.pms.features;

import com.kim.pms.dao.AdminDao;
import com.kim.pms.dao.ExistingDao;
import com.kim.pms.domain.Admin1;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingList implements Command {

  ExistingDao existDao;
  AdminValidator adminValidator;
  AdminDao adminDao;

  public ExistingList(ExistingDao existDao, AdminValidator adminValidator, AdminDao adminDao) {
    this.adminValidator = adminValidator;
    this.existDao = existDao;
    this.adminDao = adminDao;
  }

  @Override
  public void service() throws Exception {

    Existing e = new Existing();


    System.out.println();
    System.out.println("[신청 목록]");


    String input = Prompt.inputString("회원 ID:(취소 빈 문자)");

    Admin1 admin = adminDao.findById(input);

    if (admin == null) {
      System.out.println("해당 회원님의 ID가 없습니다.");
      return;
    }

    System.out.printf("PT: %s", Existing.getStatus(e.getStatus1()));
    System.out.printf("락커룸 한달 신청: %s ,락커룸 번호: %d\n", e.getStatus2(), e.getNumber());
    System.out.println();

    existDao.insert(e);
  }
}