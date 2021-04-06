package com.kim.pms.domain;

import java.sql.Date;

public class Admin1  {


  private int no;
  private String id;
  private String name;
  private String phone;
  private String address;
  private String birth;
  private String gender;
  private Date now;
  private int status;



  @Override
  public String toString() {
    return "Admin1 [no=" + no + ", id=" + id + ", name=" + name + ", phone=" + phone + ", address="
        + address + ", birth=" + birth + ", gender=" + gender + ", now=" + now + ", status="
        + status + "]";
  }



  public int getNo() {
    return no;
  }



  public void setNo(int no) {
    this.no = no;
  }



  public String getId() {
    return id;
  }



  public void setId(String id) {
    this.id = id;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getPhone() {
    return phone;
  }



  public void setPhone(String phone) {
    this.phone = phone;
  }



  public String getAddress() {
    return address;
  }



  public void setAddress(String address) {
    this.address = address;
  }



  public String getBirth() {
    return birth;
  }



  public void setBirth(String birth) {
    this.birth = birth;
  }



  public String getGender() {
    return gender;
  }



  public void setGender(String gender) {
    this.gender = gender;
  }



  public Date getNow() {
    return now;
  }



  public void setNow(Date now) {
    this.now = now;
  }



  public int getStatus() {
    return status;
  }



  public void setStatus(int status) {
    this.status = status;
  }



  public static String getStatusLabel(int status) {
    switch (status) {
      case 1:
        return "6개월 신청[8만원]";
      case 2:
        return "12개월 신청[15만원]";
      default:
        return "3개월 신청[5만원]";
    }
  }

}
