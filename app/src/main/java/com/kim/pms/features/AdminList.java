package com.kim.pms.features;
import java.util.Iterator;
import java.util.List;
import com.kim.pms.domain.Admin1;

public class AdminList extends AbstractAdminHandler {


  public AdminList(List<Admin1> adminList) {
    super(adminList);

  }


  @Override
  public void service()  {

    Iterator<Admin1> iterator = adminList.iterator();

    while (iterator.hasNext()) {
      Admin1 m = iterator.next();
      String status1 = null;
      switch (m.getStatus()) {
        // 날짜 참조값 받아오기 
        case 1:
          status1 = "6개월 신청[8만원]";    
          break;
        case 2:
          status1 = "12개월 신청[15만원]";
          break;
        default :
          status1 = "3개월 신청[5만원]";
          break;
      }
      System.out.printf("회원 id: %s ,회원 이름: %s ,전화 번호: %s ,"
          + " 주소: %s ,생년 월일:%s\n"
          ,  m.getId(), m.getName(), m.getPhone(), m.getAdress(), m.getBirth());
      System.out.printf("직업: %s ,성별: %s ,이메일: %s\n ", m.getJob()
          , m.getGender(), m.getEmail());
      System.out.printf("등록 날짜: %s ,등록 기간: %s\n" ,m.getNow(), status1 );
    }
  }

}




