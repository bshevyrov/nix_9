package ua.com.alevel.persistence.entity.user;


import ua.com.alevel.persistence.type.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {
        super();
        this.setEnabled(true);
        setRoleType(RoleType.ROLE_ADMIN);
    }

}