package com.kim.pms.features;
import java.util.ArrayList;
import java.util.List;
import com.kim.pms.domain.Admin1;
import com.kim.util.Prompt;

public class AdminMenu extends AbstractAdminHandler{


  public AdminMenu(List<Admin1> adminList ) {
    super(adminList);
  }

  ArrayList<Admin1> adminList = new ArrayList<>();
  AdminList adminList1 = new AdminList(adminList);
  AdminDetail adminDetail = new AdminDetail(adminList);
  AdminUpdate adminUpdate = new AdminUpdate(adminList);
  AdminDelete adminDelete = new AdminDelete(adminList);

  @Override
  public void service() {

    while(true) {
      System.out.println("===============[관리자]================");
      System.out.println("[1] 회원 정보 목록");
      System.out.println("[2] 회원 정보 상세 보기");
      System.out.println("[3] 회원 정보 수정");
      System.out.println("[4] 회원 삭제");
      System.out.println("[5] 메뉴로 돌아가기");
      System.out.println("=======================================");
      String command1 = Prompt.inputString("번호를 선택해주세요: ");
      System.out.println();
      switch(command1) {
        case "1" :      
          adminList1.service();
          break;      
        case "2" :   
          adminDetail.service();
          break;
        case "3" :
          adminUpdate.service();
          break;
        case "4" :
          adminDelete.service();
          break;
        case "5" : 
          System.out.println();
          System.out.println("메뉴로 돌아갑니다.");
          return;
        default :
          System.out.println();
          System.out.println("잘못 입력하셨습니다. ");
          System.out.println("다시 입력해주세요. ");
          System.out.println();
          break;

      }      
      System.out.println();
    }
  }    

}




