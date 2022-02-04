package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import ua.com.alevel.config.security.SecurityService;
import ua.com.alevel.facade.AuthValidatorFacade;
import ua.com.alevel.view.dto.request.register.AuthDto;

@Service
public class AuthValidatorFacadeImpl implements AuthValidatorFacade {

    private final SecurityService securityService;

    public AuthValidatorFacadeImpl(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthDto.class.equals(clazz);
    }


    //TODO exeption eeror page
    @Override
    public void validate(Object target, Errors errors) {
        AuthDto dto = (AuthDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Email can`t be empty");
        if (dto.getEmail().length() < 6 || dto.getEmail().length() > 32) {
            errors.reject("email", "Email size from 6 to 32 symbols");
        }

        if (securityService.existsByEmail(dto.getEmail())) {
            errors.reject("email", "User with this email already exist");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password can`t be empty");
        if (dto.getPassword().length() < 8 || dto.getPassword().length() > 32) {
            errors.reject("password", "Password size from 8 to 32 symbols");
        }
        if (!dto.getPasswordConfirm().equals(dto.getPassword())) {
            errors.reject("passwordConfirm", "Password and Password Confirm are different");
        }
    }

}