package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.dto.request.ShowSeatRequestDto;

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
        return "/pages/clients/show_detail";
    }


    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Id", "id", "id"),
                new HeaderName("Date", "date", "date"),
                new HeaderName("Start time", "start_time", "startTime"),
                new HeaderName("End time", "end_time", "emdTime"),
                new HeaderName("Movie", "movie", "movie"),
                new HeaderName("Cinema Hall", "cinema_hall", "cinemaHall"),
                new HeaderName("Delete", null, null),
                new HeaderName("Update", null, null)
        };
    }
}
