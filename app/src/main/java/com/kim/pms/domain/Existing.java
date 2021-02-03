package com.kim.pms.domain;

public class Existing {
  private String ID1;
  private int height;
  private int weight;
  private String bmicalculation;
  private int status;



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ID1 == null) ? 0 : ID1.hashCode());
    result = prime * result + ((bmicalculation == null) ? 0 : bmicalculation.hashCode());
    result = prime * result + height;
    result = prime * result + status;
    result = prime * result + weight;
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
    if (bmicalculation == null) {
      if (other.bmicalculation != null)
        return false;
    } else if (!bmicalculation.equals(other.bmicalculation))
      return false;
    if (height != other.height)
      return false;
    if (status != other.status)
      return false;
    if (weight != other.weight)
      return false;
    return true;
  }
  public String getID1() {
    return ID1;
  }
  public void setID1(String iD1) {
    ID1 = iD1;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public String getBmicalculation() {
    return bmicalculation;
  }
  public void setBmicalculation(String bmicalculation) {
    this.bmicalculation = bmicalculation;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }


}
