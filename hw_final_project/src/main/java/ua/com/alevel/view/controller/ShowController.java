package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.service.ShowService;

@Controller
@RequestMapping("/shows")
public class ShowController extends AbstractController{

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/movie/{id}")
    public String  movieShows(@PathVariable("id") long id, Model model){

        return "/pages/open/show";
    }
}
