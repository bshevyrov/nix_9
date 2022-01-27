package ua.com.alevel.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.user.ClientUser;
import ua.com.alevel.persistence.repository.user.ClientUserRepository;
import ua.com.alevel.service.ClientUserCrudService;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientUserCrudServiceImpl implements ClientUserCrudService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ClientUserRepository clientRepository;
    private final CrudRepositoryHelper<ClientUser, ClientUserRepository> crudRepositoryHelper;

    public ClientUserCrudServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, ClientUserRepository clientRepository, CrudRepositoryHelper<ClientUser, ClientUserRepository> crudRepositoryHelper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.clientRepository = clientRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(ClientUser entity) {
        if (clientRepository.existsByEmail(entity.getEmail())) {
            throw new EntityExistsException("entity already exist");
        }
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        crudRepositoryHelper.create(clientRepository, entity);
    }

    @Override
    public void update(ClientUser entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<ClientUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ClientUser> findAll() {
        return null;
    }

    @Override
    public DataTableResponse<ClientUser> findAll(DataTableRequest request) {
        return null;
    }
}
