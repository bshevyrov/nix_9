package ua.com.alevel.facade;

//import ua.com.alevel.view.dto.request.register.AuthDto;

import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.request.register.AuthDto;

public interface RegistrationFacade {
    void registration(UserRequestDto authForm);
     User findByEmail(String email);
}

