package ua.com.alevel.view.controller.admin.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CinemaHallFacade;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.controller.admin.AdminController;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

@Controller
@RequestMapping("/admin/shows")
public class AdminShowController extends AdminController {

    private final ShowFacade showFacade;
    private final CinemaHallFacade cinemaHallFacade;
    private final MovieFacade movieFacade;

    public AdminShowController(ShowFacade showFacade, CinemaHallFacade cinemaHallFacade, MovieFacade movieFacade) {
        this.showFacade = showFacade;
        this.cinemaHallFacade = cinemaHallFacade;
        this.movieFacade = movieFacade;
    }


    @GetMapping("/all")
    public String getAdminShowsAll(Model model, WebRequest request) {
        PageDataResponse<ShowResponseDto> response = showFacade.findAll(request);
        model.addAttribute("shows", response);
        return "/pages/admin/shows/shows_all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        showFacade.delete(id);
        return "redirect:/admin/shows/all";

    }
    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        model.addAttribute("showRequestDto", new ShowRequestDto());
        model.addAttribute("cinemaHalls", cinemaHallFacade.findAll());
        model.addAttribute("movies", movieFacade.findAll());
        return "pages/admin/shows/show_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute ShowRequestDto showRequestDto,
                                /*@RequestParam long cinemaHall,
                                @RequestParam long movie,*/
                                Model model) {

        showFacade.create(showRequestDto);

        return "redirect:/admin/shows/all";
    }
}
