package com.kim.pms.domain;

import java.sql.Date;

public class Check1 {
  private Admin1 ID1;
  private Date registerDate;


  public Admin1 getID1() {
    return ID1;
  }

  public void setID1(Admin1 admin1) {
    ID1 = admin1;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Check1 other = (Check1) obj;
    if (ID1 == null) {
      if (other.ID1 != null)
        return false;
    } else if (!ID1.equals(other.ID1))
      return false;
    return true;
  }

}
