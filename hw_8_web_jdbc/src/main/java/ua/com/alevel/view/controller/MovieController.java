package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.view.dto.movie.MovieRequestDto;
import ua.com.alevel.view.dto.movie.MovieResponseDto;
import ua.com.alevel.facade.MovieFacade;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping()
    public String findAll(Model model) {
        List<MovieResponseDto> movies = movieFacade.findAll();
        model.addAttribute("movies", movies);
        return "pages/movie/movie_all";
    }

    @GetMapping( "/halls/{hallId}")
    public String findAllByHallId( @PathVariable Long hallId, Model model) {
        List<MovieResponseDto> movies = movieFacade.findAllByHall(hallId);
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

    @GetMapping("/details/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieFacade.findById(id));
        return "pages/movie/movie_details";
    }

    @GetMapping("/detlete/{id}")
    public String deleteById(@PathVariable Long id) {
        movieFacade.delete(id);
        return "redirect:/movies";
    }

}
