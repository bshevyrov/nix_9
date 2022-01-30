package ua.com.alevel.facade.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.WebSecurityConfig;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.dto.request.UserRequestDto;


@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final UserService userService;

    public RegistrationFacadeImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void registration(UserRequestDto requestDtoDto) {
        User user = new User();

        user.setEmail(requestDtoDto.getEmail());
        System.out.println(requestDtoDto.getPassword());
        user.setPassword(requestDtoDto.getPassword());
        user.setFirstName(requestDtoDto.getFirstName());
        user.setLastName(requestDtoDto.getLastName());
        user.setPhone(requestDtoDto.getPhone());


//        client.setsetClientUser(clientUser);

//        clientUser.setClient(client);
        userService.create(user);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}