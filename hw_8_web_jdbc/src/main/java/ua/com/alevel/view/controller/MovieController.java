package ua.com.alevel.view.controller;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.view.dto.request.MovieRequestDto;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ua.com.alevel.util.WebRequestUtil.DEFAULT_ORDER_PARAM_VALUE;

@Controller
@RequestMapping("/movies")
public class MovieController extends AbstractController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping()
    public String findAll(Model model, WebRequest request) {
        HeaderName[] columnNames = new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("name", "name", "name"),
                new HeaderName("description", "description", "description"),
//                new HeaderName("movie count", "movieCount", "movieCount"),
                new HeaderName("details", null, null),
                new HeaderName("delete", null, null)
        };
        PageDataResponse<MovieResponseDto> response = movieFacade.findAll(request);
        response.initPaginationState(response.getCurrentPage());
        List<HeaderData> headerDataList = new ArrayList<>();
        for (HeaderName headerName : columnNames) {
            HeaderData data = new HeaderData();
            data.setHeaderName(headerName.getColumnName());
            if (StringUtils.isBlank(headerName.getTableName())) {
                data.setSortable(false);
            } else {
                data.setSortable(true);
                data.setSort(headerName.getTableName());
                if (response.getSort().equals(headerName.getTableName())) {
                    data.setActive(true);
                    data.setOrder(response.getOrder());
                } else {
                    data.setActive(false);
                    data.setOrder(DEFAULT_ORDER_PARAM_VALUE);
                }
            }
            headerDataList.add(data);
        }
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("createUrl", "/movies/all");
        model.addAttribute("pageDataResponse", response);
        model.addAttribute("cardHeader", "All Movies");
        return "pages/movie/movie_all";
    }

    @GetMapping("/halls/{hallId}")
    public String findAllByHallId(@PathVariable Long hallId, Model model) {
        List<MovieResponseDto> movies = movieFacade.findAllByHall(hallId);
        model.addAttribute("movies", movies);
        return "pages/movie/movie_all";
    }

    @GetMapping("/new/{hallId}")
    public String redirectToNewMoviePage(@PathVariable Long hallId, Model model) {
        MovieRequestDto movieRequestDto = new MovieRequestDto();
//        movieRequestDto.setHallId(hallId);
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

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        Map<String,String[]> paremetrMap = request.getParameterMap();
        if(MapUtils.isNotEmpty(paremetrMap)){
            paremetrMap.forEach(model::addAttribute);
        }
        return  new ModelAndView("redirect/movies", model);
    }

}
