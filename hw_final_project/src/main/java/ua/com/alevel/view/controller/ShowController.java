package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;

@Controller
@RequestMapping("/shows")
public class ShowController extends AbstractController {

    private final ShowFacade showFacade;
    private final MovieFacade movieFacade;

    public ShowController(ShowFacade showFacade, MovieFacade movieFacade) {
        this.showFacade = showFacade;
        this.movieFacade = movieFacade;
    }


    @GetMapping("/movie/{id}")
    public String movieShows(@PathVariable("id") long id, Model model) {
        model.addAttribute("shows", showFacade.findAllByMovieId(id));
        model.addAttribute("movie", movieFacade.findById(id));
        return "/pages/open/show_detail";
    }
}
