package com.kim.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Admin1 implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String phone;
  private String adress;
  private String birth;
  private String gender;
  private Date now;
  private int status;



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((adress == null) ? 0 : adress.hashCode());
    result = prime * result + ((birth == null) ? 0 : birth.hashCode());
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((now == null) ? 0 : now.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
    Admin1 other = (Admin1) obj;
    if (adress == null) {
      if (other.adress != null)
        return false;
    } else if (!adress.equals(other.adress))
      return false;
    if (birth == null) {
      if (other.birth != null)
        return false;
    } else if (!birth.equals(other.birth))
      return false;    
    if (gender == null) {
      if (other.gender != null)
        return false;
    } else if (!gender.equals(other.gender))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (now == null) {
      if (other.now != null)
        return false;
    } else if (!now.equals(other.now))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (status != other.status)
      return false;
    return true;
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
  public String getAdress() {
    return adress;
  }
  public void setAdress(String adress) {
    this.adress = adress;
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


}
