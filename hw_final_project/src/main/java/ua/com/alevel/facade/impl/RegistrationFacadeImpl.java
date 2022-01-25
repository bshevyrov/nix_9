package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.entity.user.ClientUser;
import ua.com.alevel.service.ClientUserCrudService;
import ua.com.alevel.view.dto.request.register.AuthDto;


@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final ClientUserCrudService clientService;

    public RegistrationFacadeImpl(ClientUserCrudService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void registration(AuthDto dto) {
        ClientUser client = new ClientUser();
        client.setEmail(dto.getEmail());
        client.setPassword(dto.getPassword());
        clientService.create(client);
    }
}