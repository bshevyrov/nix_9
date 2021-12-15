package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.movie.MovieRequestDto;
import ua.com.alevel.dto.movie.MovieResponseDto;
import ua.com.alevel.facade.MovieFacade;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping
    public String findAll(Model model) {
        List<MovieResponseDto> movies = movieFacade.findAll();
        model.addAttribute("movies", movies);
        return "pages/movie/movie_all";
    }

    @GetMapping("/new/{hallId}")
    public String redirectToNewMoviePage(@PathVariable Long hallId, Model model) {
        MovieRequestDto movieRequestDto = new MovieRequestDto();
        movieRequestDto.setHallId(hallId);
        model.addAttribute("movie", movieRequestDto);
        model.addAttribute("hallId", hallId);
        //Какаято переброска далее
        return "pages/movie/movie_new";
    }

    @PostMapping("/new")
    public String createNewMovie(@ModelAttribute("movie") MovieRequestDto movieRequestDto) {
        movieFacade.create(movieRequestDto);
        return "redirect:/movies";
    }

}
