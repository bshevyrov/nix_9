package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.config.security.SecurityService;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final SecurityService securityService;
    private final MovieFacade movieFacade;

    public MovieController(SecurityService securityService, MovieFacade movieFacade) {
        this.securityService = securityService;
        this.movieFacade = movieFacade;
    }

    @GetMapping()
    public String getFirst(Model model, WebRequest request) {
        //
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
                return "redirect:/admin/movies/all";
            }
        }
        //

      //  AbstractController.HeaderName[] columnNames = getColumnNames();
        PageDataResponse<MovieResponseDto> response = movieFacade.findAll(request);
        response.initPaginationState(response.getCurrentPage());
      //  List<AbstractController.HeaderData> headerDataList = getHeaderDataList(columnNames, response);
      //  model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All Students");
        model.addAttribute("allowCreate", true);
        model.addAttribute("createNewItemUrl", "/students/new");
//        return "/pages/student/student_all";


        return "/pages/open/dashboard";
    }
}
