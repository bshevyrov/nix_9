package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.config.security.SecurityService;
import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.util.SecurityUtil;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final SecurityService securityService;

    public MovieController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping()
    public String getFirst(Model model) {
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
                return "redirect:/admin/movies/all";
            }
        }

        return "/pages/open/dashboard";
    }
}
