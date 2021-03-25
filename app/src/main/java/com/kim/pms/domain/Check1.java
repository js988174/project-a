package com.kim.pms.domain;

public class Check1 {
  private String ID1;

  public Check1 () {} 

  public Check1(String csv) {
    String[] fields = csv.split(","); 
    this.setID1(fields[0]);
  }

  public String toCsvString() {
    return String.format("%s",
        this.getID1());
  }

  public static Check1 valueOfCsv(String csv) {
    String[] fields = csv.split(","); 
    Check1 c = new Check1();
    c.setID1(fields[0]);
    return c;
  }

  public String getID1() {
    return ID1;
  }

  public void setID1(String iD1) {
    ID1 = iD1;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ID1 == null) ? 0 : ID1.hashCode());
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
    Check1 other = (Check1) obj;
    if (ID1 == null) {
      if (other.ID1 != null)
        return false;
    } else if (!ID1.equals(other.ID1))
      return false;
    return true;
  }

}
