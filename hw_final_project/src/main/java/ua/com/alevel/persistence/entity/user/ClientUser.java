package ua.com.alevel.persistence.entity.user;

import ua.com.alevel.persistence.type.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@DiscriminatorValue("CLIENT")
public class ClientUser extends User {

    @OneToOne(mappedBy = "clientUser")
    private Client client;

    public ClientUser() {
        super();
        setRoleType(RoleType.ROLE_CLIENT);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
