package ua.com.alevel.view.controller.admin;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CinemaHallFacade;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {

    private final ShowFacade showFacade;
    private final CinemaHallFacade cinemaHallFacade;
    private final MovieFacade movieFacade;

    public AdminController(ShowFacade showFacade, CinemaHallFacade cinemaHallFacade, MovieFacade movieFacade) {
        this.showFacade = showFacade;
        this.cinemaHallFacade = cinemaHallFacade;
        this.movieFacade = movieFacade;
    }


//    @GetMapping("/movies/all")
//    public String getAdminMoviesAll(Model model) {
//
//        return "/pages/admin/movies/movies_all";
//    }


    @GetMapping("/shows/all")
    public String getAdminShowsAll(Model model, WebRequest request) {
        PageDataResponse<ShowResponseDto> response = showFacade.findAll(request);
        System.out.println(response.getItemsSize());
        model.addAttribute("shows", response);
        return "/pages/admin/shows/shows_all";
    }

    @GetMapping("/show/new")
    public String redirectToNewHallPage(Model model) {
        model.addAttribute("showRequestDto", new ShowRequestDto());
        model.addAttribute("cinemaHalls", cinemaHallFacade.findAll());
        model.addAttribute("movies", movieFacade.findAll());
        return "pages/admin/shows/show_new";
    }

    @PostMapping("/show/new")
    public String CreateNewHall(@ModelAttribute ShowRequestDto showRequestDto,
                                @RequestParam long cinemaHall,
                                @RequestParam long movie,
                                Model model) {
        System.out.println(showRequestDto.getDate().toString());
        showFacade.create(showRequestDto);

//        for (Long l : checkedCourses) {
//            CourseStudentRequestDto courseStudentRequestDto = new CourseStudentRequestDto();
//            courseStudentRequestDto.setStudentId(studentFacade.findByEmail(studentRequestDto.getEmail()).getId());
//            courseStudentRequestDto.setCourseId(l);
//            courseStudentFacade.create(courseStudentRequestDto);
//        }
        return "redirect:/shows";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
