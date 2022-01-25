package ua.com.alevel.view.dto.request;

import ua.com.alevel.view.dto.request.register.AuthDto;

public class ClientRequestDto extends AuthDto {

   private String firstName;
   private String lastName;
   private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
