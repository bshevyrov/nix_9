package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.client.Client;
import ua.com.alevel.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl  implements ClientService {
    @Override
    public void create(Client entity) {

    }

    @Override
    public void update(Client entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public DataTableResponse<Client> findAll(DataTableRequest request) {
        return null;
    }
}
