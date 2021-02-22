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
      System.out.println("=====================================================================================");
      System.out.println("회원 ID\t  회원 이름\t전화번호\t 주소 \t\t생년월일\t  성별 ");
      System.out.println("=====================================================================================");
      System.out.printf(" %s  %4s   %9s  %11s%12s %10s\n"
          ,  m.getId(), m.getName(), m.getPhone(), m.getAdress(),m.getBirth(),m.getGender());
      System.out.println("=====================================================================================");      
      System.out.println("등록 날짜\t등록 기간");
      System.out.printf(" %7s  %5s\n", m.getNow(), status1 );
      System.out.println();
    }
  }

}




