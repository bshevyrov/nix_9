package ua.com.alevel.view.controller.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.config.security.SecurityService;
import ua.com.alevel.facade.AuthValidatorFacade;
import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.ClientRequestDto;
import ua.com.alevel.view.dto.request.register.AuthDto;

@Controller
@RequestMapping("/client/registration")
public class ClientRegistrationController extends AbstractController {

    private final RegistrationFacade registrationFacade;
    private final AuthValidatorFacade authValidatorFacade;
    private final SecurityService securityService;

    public ClientRegistrationController(
            RegistrationFacade registrationFacade,
            AuthValidatorFacade authValidatorFacade,
            SecurityService securityService) {
        this.registrationFacade = registrationFacade;
        this.authValidatorFacade = authValidatorFacade;
        this.securityService = securityService;
    }


    @GetMapping
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return redirectProcess(model);
        }
        model.addAttribute("authForm", new ClientRequestDto());
        return "/pages/client/registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("authForm") ClientRequestDto authForm, BindingResult bindingResult, Model model) {
        showMessage(model, false);
        authValidatorFacade.validate(authForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/pages/client/registration";
        }
        registrationFacade.registration(authForm);
        securityService.autoLogin(authForm.getEmail(), authForm.getPasswordConfirm());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal.toString());
        model.addAttribute("user",principal.toString());
        return redirectProcess(model);
    }

    private String redirectProcess(Model model) {
        showMessage(model, false);
        if (SecurityUtil.hasRole(RoleType.ROLE_CLIENT.name())) {
            return "redirect:/client/dashboard";
        }
        return "redirect:/login";

    }

/*
    @GetMapping
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return redirectProcess(model);
        }
        model.addAttribute("authForm", new AuthDto());
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("authForm") ClientRequestDto authForm, BindingResult bindingResult, Model model) {
        showMessage(model, false);
        authValidatorFacade.validate(authForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        registrationFacade.registration(authForm);
        securityService.autoLogin(authForm.getEmail(), authForm.getPasswordConfirm());
        return redirectProcess(model);
    }

    private String redirectProcess(Model model) {
        showMessage(model, false);
        if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
            return "redirect:/admin/dashboard";
        }
        if (SecurityUtil.hasRole(RoleType.ROLE_CLIENT.name())) {
            return "redirect:/client/dashboard";
        }
        return "redirect:/login";
    }*/

}