package ua.com.alevel.view.controller.admin.user;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.UserResponseDto;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController extends AbstractController {

    private final UserFacade userFacade;

    public AdminUserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/dashboard")
    public String dashboard(WebRequest request,
                            Model model) {

        HeaderName[] columnNames = getColumnNames();
        PageDataResponse<UserResponseDto> response = userFacade.findAllUser(request);
        response.initPaginationState(response.getCurrentPage());
        List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All Users");
        return "/pages/admin/admin_dashboard";
    }

    @PostMapping("/dashboard")
    public ModelAndView findAll(WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        return new ModelAndView("redirect:/admin/users/dashboard", model);
    }

    @PostMapping("/ban/{id}")
    public String ban(@PathVariable("id") long id,
                      @RequestParam("enabled") String enabled,
                      Model model) {
        if (StringUtils.equals("true", enabled)) {
            userFacade.ban(id);
        } else {
            userFacade.unban(id);
        }
        return "redirect:/admin/users/dashboard";
    }

    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Id", "id", "id"),
                new HeaderName("First name", "first_name", "firstName"),
                new HeaderName("Last Name", "last_name", "lastName"),
                new HeaderName("Email", "email", "email"),
                new HeaderName("Phone", "phone", "phone"),
                new HeaderName("Enabled", "enabled", "enabled"),
                new HeaderName("Ban/Unban", null, null),
        };
    }
}
