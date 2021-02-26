package com.kim.pms.domain;

import java.io.Serializable;

public class Existing implements Serializable{
  private static final long serialVersionUID = 1L;

  private String ID1;
  private int status;
  private int number;
  private int status1;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ID1 == null) ? 0 : ID1.hashCode());
    result = prime * result + number;
    result = prime * result + status;

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
    if (status != other.status)
      return false;

    if (number != other.number)
      return false;
    return true;
  }
  public String getID1() {
    return ID1;
  }
  public void setID1(String iD1) {
    ID1 = iD1;
  }
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public int getStatus1() {
    return status1;
  }
  public void setStatus1(int status1) {
    this.status1 = status1;
  }


}
