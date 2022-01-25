package ua.com.alevel.persistence.entity.client;

import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.ClientUser;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {


    @Column(name = "name")
    private String name;
    //    private String password;
//    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_user_id", referencedColumnName = "id")
    private ClientUser clientUser;

    public Client() {
        super();
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

    public ClientUser getClientUser() {
        return clientUser;
    }

    public void setClientUser(ClientUser clientUser) {
        this.clientUser = clientUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(phone, client.phone) && Objects.equals(clientUser, client.clientUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, clientUser);
    }
}
