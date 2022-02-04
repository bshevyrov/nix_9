package ua.com.alevel.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.user.UserRepository;
import ua.com.alevel.service.UserService;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository<BaseEntity> userRepository;
    private final CrudRepositoryHelper<User, UserRepository<BaseEntity>> crudRepositoryHelper;

    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository<BaseEntity> userRepository, CrudRepositoryHelper<User, UserRepository<BaseEntity>> crudRepositoryHelper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void create(User entity) {
        if (userRepository.existsByEmail(entity.getEmail())) {
            throw new EntityExistsException("entity already exist");
        }
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        crudRepositoryHelper.create(userRepository, entity);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(User entity) {
        crudRepositoryHelper.update(userRepository, entity);

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void delete(Long id) {
        crudRepositoryHelper.delete(userRepository, id);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return crudRepositoryHelper.findById(userRepository, id);

    }

    @Override
    public List<User> findAll() {
        return crudRepositoryHelper.findAll(userRepository);

    }

    @Override
    @Transactional(readOnly = true)

    public DataTableResponse<User> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(userRepository, request);

    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        //TODO проверка перед созданием с формы
        return userRepository.existsByEmail(email);
    }

    public void updatePassword(long id, String encode) {
        User user = userRepository.findById(id).get();
        user.setPassword(encode);
      userRepository.save(user);
    }
}
