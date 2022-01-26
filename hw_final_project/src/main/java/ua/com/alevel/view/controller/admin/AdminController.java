package ua.com.alevel.view.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {

    private final ShowFacade showFacade;

    public AdminController(ShowFacade showFacade) {
        this.showFacade = showFacade;
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
}
