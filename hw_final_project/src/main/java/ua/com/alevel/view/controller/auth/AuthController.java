package ua.com.alevel.view.controller.auth;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.alevel.config.security.SecurityService;
import ua.com.alevel.facade.AuthValidatorFacade;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;

@Controller
public class AuthController extends AbstractController {

    private final RegistrationFacade registrationFacade;
    private final AuthValidatorFacade authValidatorFacade;
    private final SecurityService securityService;

    public AuthController(
            RegistrationFacade registrationFacade,
            AuthValidatorFacade authValidatorFacade,
            SecurityService securityService) {
        this.registrationFacade = registrationFacade;
        this.authValidatorFacade = authValidatorFacade;
        this.securityService = securityService;
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        showMessage(model, false);
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
                return "redirect:/movies";
            }
            if (SecurityUtil.hasRole(RoleType.ROLE_USER.name())) {
                return "redirect:/movies";
            }
        }
        if (error != null) {
            showError(model, "Your email and password is invalid.");
        }
        if (logout != null) {
            showInfo(model, "You have been logged out successfully.");
        }
        return "login";
    }


}