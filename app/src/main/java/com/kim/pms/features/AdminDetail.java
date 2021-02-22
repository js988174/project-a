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
    System.out.println("회원 ID\t 회원 이름\t전화번호\t 주소 \t\t생년월일\t  성별 ");
    System.out.println("=====================================================================================");
    System.out.printf(" %s  %4s   %9s  %11s%12s %10s\n"
        ,  m.getId(), m.getName(), m.getPhone(), m.getAdress(),m.getBirth(),m.getGender());
    System.out.println("=====================================================================================");      
    System.out.println("등록 날짜\t등록 기간");
    System.out.printf(" %7s  %5s\n", m.getNow(), m.getStatus() );

  }

}



