package ua.com.alevel.persistence.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;

    public Student() {
      super();
    }

    public Student(ResultSet resultSet) {
        try {
       setId(resultSet.getLong("id"));
       setCreateDate(resultSet.getDate("create_date"));
        setFirstName(resultSet.getString("first_name"));
        setLastName(resultSet.getString("last_name"));
        setEmail(resultSet.getString("email"));
        setPhone(resultSet.getString("phone"));
        setBirthDate(resultSet.getDate("birth_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
