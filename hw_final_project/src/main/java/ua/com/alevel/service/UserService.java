package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.user.User;

@Service
public interface UserService extends BaseCrudService<User> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
