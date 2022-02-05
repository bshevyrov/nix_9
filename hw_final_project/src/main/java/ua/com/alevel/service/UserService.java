package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.user.User;

@Service
public interface UserService extends BaseCrudService<User> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    void updatePassword(long id, String encode);


    void ban(long id);

    void unban(long id);

    DataTableResponse<User> findAllUser(DataTableRequest request);
}
