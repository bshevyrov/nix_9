package ua.com.alevel.view.controller.open;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.MovieResponseDto;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController extends AbstractController {

    private final MovieFacade movieFacade;

    public MovieController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }


    @GetMapping()
    public String getFirst(Model model, WebRequest request) {
       /* //
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
                return "redirect:/admin/movies/all";
            }
        }
        //*/

        //  AbstractController.HeaderName[] columnNames = getColumnNames();
        List<MovieResponseDto> response = movieFacade.findAll();
//        response.initPaginationState(response.getCurrentPage());
//          List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
//          model.addAttribute("headerDataList", headerDataList);
//        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("pageDataResponse", response);
//        model.addAttribute("cardHeader", "All Students");
//        model.addAttribute("allowCreate", true);
//        model.addAttribute("createNewItemUrl", "/students/new");
//        return "/pages/student/student_all";


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
