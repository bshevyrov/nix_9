package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.entity.client.Client;
import ua.com.alevel.persistence.entity.user.ClientUser;
import ua.com.alevel.service.ClientUserCrudService;
import ua.com.alevel.view.dto.request.ClientRequestDto;
import ua.com.alevel.view.dto.request.RequestDto;
import ua.com.alevel.view.dto.request.register.AuthDto;


@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final ClientUserCrudService clientService;

    public RegistrationFacadeImpl(ClientUserCrudService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void registration(ClientRequestDto requestDtoDto) {
        ClientUser clientUser = new ClientUser();
        clientUser.setEmail(requestDtoDto.getEmail());
        clientUser.setPassword(requestDtoDto.getPassword());
//        clientService.create(clientUser);

        Client client = new Client();
       client.setFirstName(requestDtoDto.getFirstName());
       client.setLastName(requestDtoDto.getLastName());
       client.setPhone(requestDtoDto.getPhone());
       client.setClientUser(clientUser);

        clientUser.setClient(client);
        clientService.create(clientUser);
    }
}