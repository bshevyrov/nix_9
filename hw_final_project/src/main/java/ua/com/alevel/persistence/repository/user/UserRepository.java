package ua.com.alevel.persistence.repository.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.BaseRepository;
import ua.com.alevel.persistence.type.RoleType;

@Repository
public interface UserRepository<U extends BaseEntity> extends BaseRepository<User> {


    User findByEmail(String email);

    boolean existsByEmail(String email);

    @Modifying
    @Query("update User u set u.enabled = false where u.id = :id")
       void ban(@Param("id") long id);

    @Modifying
    @Query("update User u set u.enabled = true where u.id = :id")
    void unban(@Param("id") long id);

    Page<User> findByRoleType(RoleType role, Pageable pageable);

}