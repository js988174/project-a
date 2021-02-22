package com.kim.pms.features;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminAdd extends AbstractAdminHandler {

  public AdminAdd(List<Admin1> adminList) {
    super(adminList);
  }


  @Override
  public void service() {
    Admin1 m = new Admin1();

    System.out.println();
    System.out.println("[회원 등록]");



    System.out.println();
    m.setId(Prompt.inputString("id: "));
    m.setName(Prompt.inputString("회원 이름: "));
    m.setPhone(Prompt.inputString("전화 번호: "));
    m.setAdress(Prompt.inputString("주소: "));
    m.setBirth(Prompt.inputString("생년 월일: "));
    m.setJob(Prompt.inputString("직업: "));
    m.setGender(Prompt.inputString("성별: "));
    m.setEmail(Prompt.inputString("이메일: "));
    m.setNow(new java.sql.Date(System.currentTimeMillis()));
    m.setStatus(Prompt.inputInt("등록기간:\n0: 3개월[5만원]\n1: 6개월[8만원]\n2: 12개월[15만원]\n>"));

    adminList.add(m);

    System.out.println("회원을 등록하였습니다.");

  }

}




