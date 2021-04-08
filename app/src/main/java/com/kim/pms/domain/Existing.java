package com.kim.pms.domain;

public class Existing {

  private int no;
  private Admin1 ID1;
  private int status1;
  private String number;
  private String status2;

  @Override
  public String toString() {
    return "Existing [no=" + no + ", ID1=" + ID1 + ", status1=" + status1 + ", number=" + number
        + ", status2=" + status2 + "]";
  }

  public Admin1 getID1() {
    return ID1;
  }

  public void setID1(Admin1 admin1) {
    ID1 = admin1;
  }

  public int getStatus1() {
    return status1;
  }

  public void setStatus1(int status1) {
    this.status1 = status1;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getStatus2() {
    return status2;
  }

  public void setStatus2(String status2) {
    this.status2 = status2;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public static String getStatus(int status) {
    switch (status) {
      case 1:
        return "10회 [45만원]";
      case 2:
        return "15회 [68만원]";
      default:
        return "5회 [25만원]";
    }
  }

}

