package ua.com.alevel.persistence.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.ClientUser;

@Repository
public interface ClientUserRepository extends UserRepository<ClientUser> {
}