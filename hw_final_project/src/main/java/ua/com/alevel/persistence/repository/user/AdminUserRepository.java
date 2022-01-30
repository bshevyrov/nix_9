package ua.com.alevel.persistence.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Admin;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface AdminUserRepository extends BaseRepository<Admin> {
}