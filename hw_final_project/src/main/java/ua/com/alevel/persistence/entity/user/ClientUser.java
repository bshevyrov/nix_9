/*
package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.entity.client.Client;
import ua.com.alevel.persistence.type.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientUser extends User {

    @OneToOne(mappedBy = "clientUser")
    private ua.com.alevel.persistence.entity.client.Client client;

    public ClientUser() {
        super();
        setRoleType(RoleType.ROLE_USER);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
*/
