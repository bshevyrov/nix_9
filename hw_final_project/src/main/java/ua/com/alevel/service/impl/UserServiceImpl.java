package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.user.UserRepository;
import ua.com.alevel.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CrudRepositoryHelper<User, UserRepository> crudRepositoryHelper;

    public UserServiceImpl(UserRepository userRepository, CrudRepositoryHelper<User, UserRepository> crudRepositoryHelper) {
        this.userRepository = userRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(User entity) {
crudRepositoryHelper.create(userRepository,entity);
    }

    @Override
    public void update(User entity) {
        crudRepositoryHelper.update(userRepository,entity);

    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(userRepository,id);

    }

    @Override
    @Transactional(readOnly = true)

    public Optional<User> findById(Long id) {

        return crudRepositoryHelper.findById(userRepository,id);

    }

    @Override
    public List<User> findAll() {
                return crudRepositoryHelper.findAll(userRepository);

    }

    @Override
    public DataTableResponse<User> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(userRepository,request);

    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        //TODO проверка перед созданием с формы
        return userRepository.existsByEmail(email);
    }
}
