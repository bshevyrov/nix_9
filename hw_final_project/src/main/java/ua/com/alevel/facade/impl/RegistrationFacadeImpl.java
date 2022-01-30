package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.view.dto.request.UserRequestDto;


@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final UserService userService;

    public RegistrationFacadeImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void registration(UserRequestDto requestDtoDto) {
        User clientUser = new User();
        clientUser.setEmail(requestDtoDto.getEmail());
        clientUser.setPassword(requestDtoDto.getPassword());
//        clientService.create(clientUser);

        User client = new User();
        client.setFirstName(requestDtoDto.getFirstName());
        client.setLastName(requestDtoDto.getLastName());
        client.setPhone(requestDtoDto.getPhone());
//        client.setsetClientUser(clientUser);

//        clientUser.setClient(client);
        userService.create(clientUser);
    }
}