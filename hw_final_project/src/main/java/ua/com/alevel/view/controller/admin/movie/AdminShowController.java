package ua.com.alevel.view.controller.admin.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CinemaHallFacade;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.controller.admin.AdminController;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;

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
    public String fil(WebRequest request, ModelMap model) {

        HeaderName[] columnNames = getColumnNames();
        PageDataResponse<ShowResponseDto> response = showFacade.findAll(request);
        response.initPaginationState(response.getCurrentPage());
        List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("pageDataResponse", response);
        System.out.println(response.getItemsSize());
        model.addAttribute("cardHeader", "All Shows");
        model.addAttribute("allowCreate", true);
        model.addAttribute("createNewItemUrl", "/students/new");
        return "/pages/admin/shows/shows_all";
    }

/*
    @GetMapping("/all")
    public String getAdminShowsAll(Model model, WebRequest request) {
        PageDataResponse<ShowResponseDto> response = showFacade.findAll(request);
        model.addAttribute("shows", response);
        return "/pages/admin/shows/shows_all";
    }*/

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