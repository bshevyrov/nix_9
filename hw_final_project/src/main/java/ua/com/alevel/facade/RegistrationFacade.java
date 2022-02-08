package ua.com.alevel.facade;


import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.view.dto.request.UserRequestDto;

public interface RegistrationFacade {

    void registration(UserRequestDto authForm);

    User findByEmail(String email);
}

