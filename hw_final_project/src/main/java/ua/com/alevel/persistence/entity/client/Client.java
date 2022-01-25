package ua.com.alevel.persistence.entity.client;

import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.ClientUser;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {


    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;
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
        return Objects.equals(FirstName, client.FirstName) && Objects.equals(LastName, client.LastName) && Objects.equals(phone, client.phone) && Objects.equals(clientUser, client.clientUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, phone, clientUser);
    }
}
