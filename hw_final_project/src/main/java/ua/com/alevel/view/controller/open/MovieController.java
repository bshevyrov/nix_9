package ua.com.alevel.view.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.persistence.type.CinemaHallType;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.*;

@Controller
@RequestMapping("/movies")
public class MovieController extends AbstractController {

    private final MovieFacade movieFacade;
    private final ShowFacade showFacade;

    public MovieController(MovieFacade movieFacade, ShowFacade showFacade) {
        this.movieFacade = movieFacade;
        this.showFacade = showFacade;
    }


    @GetMapping()
    public String getFirst(Model model, WebRequest request) {

        List<MovieResponseDto> response = movieFacade.findAll();
        List<ShowResponseDto> shows = showFacade.findAll();
        Map<Long, Set<CinemaHallType>> typesByMovieId = new HashMap<>();
        for (MovieResponseDto movieResponseDto : response) {
            Set<CinemaHallType> cinemaHallTypeSet = new HashSet<>();
            for (ShowResponseDto show : shows) {
                if (CinemaHallType.values().length == cinemaHallTypeSet.size()) {
                    break;
                }
                if (show.getMovie().getId() == movieResponseDto.getId()) {
                    cinemaHallTypeSet.add(show.getCinemaHall().getCinemaHallType());
                }
            }
            typesByMovieId.put(movieResponseDto.getId(), cinemaHallTypeSet);
        }
        model.addAttribute("pageDataResponse", response);
        model.addAttribute("types", typesByMovieId);

        return "pages/clients/movie/movie_dashboard";
    }

    @GetMapping("/detail/{id}")
    public String details(@PathVariable("id") long id, Model model) {
        MovieResponseDto byId = movieFacade.findById(id);
        model.addAttribute("movie", byId);
        return "/pages/clients/movie/movie_detail";
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
