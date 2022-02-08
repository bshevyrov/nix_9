package ua.com.alevel.view.controller.admin.movie;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.MovieRequestDto;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin/movies")
@Controller
public class AdminMovieController extends AbstractController {

    private final MovieFacade movieFacade;

    public AdminMovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/details/{id}")
    public String detail(@PathVariable("id") long id, Model model) {
        model.addAttribute("movie", movieFacade.findById(id));
        return "redirect:/admin/movies/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        movieFacade.delete(id);
        return "redirect:/admin/movies/all";

    }

    @GetMapping("/new")
    public String create(Model model) {

        model.addAttribute("movieRequestDto", new MovieRequestDto());
        return "/pages/admin/movies/movies_new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("movieRequestDto") MovieRequestDto movieRequestDto,
                         @RequestParam("hours") int hours,
                         @RequestParam("minutes") int minutes,
                         Model model) {
        movieRequestDto.setDuration(Time.valueOf(hours + ":" + minutes + ":00"));
        movieFacade.create(movieRequestDto);
        return "redirect:/admin/movies/all";
    }


    @GetMapping("/all")
    public String fil(WebRequest request, ModelMap model) {
        AbstractController.HeaderName[] columnNames = getColumnNames();
        PageDataResponse<MovieResponseDto> response = movieFacade.findAll(request);
        response.initPaginationState(response.getCurrentPage());
        List<AbstractController.HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("createUrl", "/admin/movies/new");
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All Movies");
        model.addAttribute("allowCreate", true);
        return "/pages/admin/movies/movies_all";
    }

    @PostMapping("/all")
    public ModelAndView findAll(WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        return new ModelAndView("redirect:/admin/movies/all", model);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        MovieRequestDto movieRequestDto = new MovieRequestDto();
        movieRequestDto.setId(id);
        model.addAttribute("movieRequestDto", movieRequestDto);
        return "/pages/admin/movies/movies_new";
    }

    private AbstractController.HeaderName[] getColumnNames() {
        return new AbstractController.HeaderName[]{
                new AbstractController.HeaderName("#", null, null),
                new AbstractController.HeaderName("Id", "id", "id"),
                new AbstractController.HeaderName("Title", "title", "title"),
                new AbstractController.HeaderName("Duration", "duration", "duration"),
                new AbstractController.HeaderName("Director", "director", "director"),
                new AbstractController.HeaderName("Genre", "genre", "genre"),
                new AbstractController.HeaderName("Release year", "release_year", "releaseYear"),
                new AbstractController.HeaderName("Delete", null, null),
                new AbstractController.HeaderName("Update", null, null)
        };
    }
}
