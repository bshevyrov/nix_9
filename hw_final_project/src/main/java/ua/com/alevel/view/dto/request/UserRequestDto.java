package ua.com.alevel.view.dto.request;

import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.view.dto.request.register.AuthDto;

public class UserRequestDto extends AuthDto {

    private Boolean enabled;
    private RoleType roleType;
    private String FirstName;
    private String LastName;
    private String phone;
    private String oldPassword;

    public String getOldPassword() {

        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
