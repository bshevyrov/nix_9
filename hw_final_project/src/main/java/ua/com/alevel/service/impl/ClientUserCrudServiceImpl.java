//package ua.com.alevel.service.impl;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
//import ua.com.alevel.persistence.datatable.DataTableRequest;
//import ua.com.alevel.persistence.datatable.DataTableResponse;
//import ua.com.alevel.persistence.entity.user.Client;
//import ua.com.alevel.persistence.repository.user.ClientUserRepository;
//import ua.com.alevel.service.ClientUserCrudService;
//
//import javax.persistence.EntityExistsException;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClientUserCrudServiceImpl implements ClientUserCrudService {
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final ClientUserRepository clientUserRepository;
//    private final CrudRepositoryHelper<Client, ClientUserRepository> crudRepositoryHelper;
//
//    public ClientUserCrudServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, ClientUserRepository clientUserRepository, CrudRepositoryHelper<Client, ClientUserRepository> crudRepositoryHelper) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.clientUserRepository = clientUserRepository;
//        this.crudRepositoryHelper = crudRepositoryHelper;
//    }
//
//    @Override
//    public void create(Client entity) {
//        if (clientUserRepository.existsByEmail(entity.getEmail())) {
//            throw new EntityExistsException("entity already exist");
//        }
//        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
//        crudRepositoryHelper.create(clientUserRepository, entity);
//    }
//
//    @Override
//    public void update(Client entity) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public Optional<Client> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Client> findAll() {
//
//        return crudRepositoryHelper.findAll(clientUserRepository);
//    }
//
//    @Override
//    public DataTableResponse<Client> findAll(DataTableRequest request) {
//        return crudRepositoryHelper
//                .findAll(clientUserRepository,request);
//    }
//
//    @Override
//    public Client findByEmail(String email) {
//        return clientUserRepository.findByEmail(email);
//    }
//
//    @Override
//    public boolean existsByEmail(String email) {
//        return false;
//    }
//}
