package ua.com.alevel.view.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.view.controller.AbstractController;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {


    @GetMapping("/movies/all")
    public String getAdminMoviesAll(Model model) {

        return "/pages/admin/movies/movies_all";
    }
}
