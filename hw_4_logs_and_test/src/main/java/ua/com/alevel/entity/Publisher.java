package ua.com.alevel.entity;

import org.apache.commons.lang3.ArrayUtils;

public class Publisher {
    String name;
   // String phone;
    String[] booksName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  //  public String getPhone() {
   //     return phone;
  //  }

  //  public void setPhone(String phone) {
  //      this.phone = phone;
  //  }

    public String[] getBooksName() {
        return booksName;
    }

    public void setBooksName(String[] booksName) {
        ArrayUtils.add(this.booksName,booksName);
    }
}
