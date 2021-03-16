package com.kim.pms.domain;

import com.kim.util.CsvObject;

public class Existing implements CsvObject{


  private String ID1;
  private int status1;
  private String number;
  private int status2;

  public Existing() {}

  public Existing(String csv) {
    String[] fields = csv.split(","); 
    this.setID1(fields[0]);
    this.setStatus1(Integer.parseInt(fields[1]));
    this.setStatus2(Integer.parseInt(fields[2]));
    this.setNumber(fields[3]);
  }

  @Override
  public String toCsvString() {
    return String.format("%s,%d,%d,%s",
        this.getID1(),
        this.getStatus1(),
        this.getStatus2(),
        this.getNumber());
  }

  public static Existing valueOfCsv(String csv) {
    String[] fields = csv.split(","); 
    Existing e = new Existing();
    e.setID1(fields[0]);
    e.setStatus1(Integer.parseInt(fields[1]));
    e.setStatus2(Integer.parseInt(fields[2]));
    e.setNumber(fields[3]);
    return e;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ID1 == null) ? 0 : ID1.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + status1;
    result = prime * result + status2;
    return result;
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Existing other = (Existing) obj;
    if (ID1 == null) {
      if (other.ID1 != null)
        return false;
    } else if (!ID1.equals(other.ID1))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (status1 != other.status1)
      return false;
    if (status2 != other.status2)
      return false;
    return true;
  }

  public String getID1() {
    return ID1;
  }

  public void setID1(String iD1) {
    ID1 = iD1;
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

  public int getStatus2() {
    return status2;
  }

  public void setStatus2(int status2) {
    this.status2 = status2;
  }


}

