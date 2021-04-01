package com.kim.pms.features;

import com.kim.pms.dao.AdminDao;
import com.kim.pms.dao.ExistingDao;
import com.kim.pms.domain.Existing;
import com.kim.util.Prompt;


public class ExistingMenu implements Command{


  AdminValidator adminValidator;
  ExistingDao existDao;
  AdminDao adminDao;

  public ExistingMenu(ExistingDao existDao ,AdminValidator adminValidator, AdminDao adminDao) {
    this.existDao = existDao;
    this.adminValidator = adminValidator;
    this.adminDao = adminDao;
  }


  ExistingList existList1 = new ExistingList(existDao, adminValidator, adminDao);
  ExistingPt existPt = new ExistingPt(existDao);
  ExistingRocker existRocker = new ExistingRocker(existDao);

  @Override
  public void service() throws Exception {
    System.out.println();
    System.out.println("[기존 회원]");

    while (true) {
      Existing m = new Existing();
      m.setID1(adminValidator.inputMember("ID: (취소: 빈 문자열): "));
      if (m.getID1() == null) {
        System.out.println("아이디 입력을 취소합니다.");
        return;
      }

      while (true) {
        System.out.println();
        System.out.println("========개인 신청 목록========");
        System.out.println("[1] pt 신청하기");
        System.out.println("[2] 개인 락커룸 신청하기");
        System.out.println("[3] 신청 목록");
        System.out.println("[4] 메뉴로 돌아가기");
        System.out.println();
        String command1 = Prompt.inputString("번호를 선택해주세요: ");
        System.out.println();
        switch (command1) {
          case "1":
            existPt.service();
            break;
          case "2": 
            existRocker.service();
            break;
          case "3" :
            existList1.service();
            break;
          case "4" : 
            System.out.println("메뉴로 돌아갑니다.");
            return;
          default : 
            System.out.println();
            System.out.println("잘못 입력하셨습니다. ");
            System.out.println("다시 입력해주세요. ");
            System.out.println();
            break;
        }    
      }
    }
  }


}