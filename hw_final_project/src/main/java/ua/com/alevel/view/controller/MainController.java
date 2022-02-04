package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String homePageRedirect() {
        return "redirect:/movies";
    }
}
