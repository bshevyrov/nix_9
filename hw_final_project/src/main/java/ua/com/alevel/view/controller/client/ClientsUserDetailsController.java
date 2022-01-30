package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.UserResponseDto;

@Controller
@RequestMapping("/clients")
public class ClientsUserDetailsController extends AbstractController {

    private final UserFacade userFacade;

    public ClientsUserDetailsController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/user/detail")
    public String detail(Model model){
        UserResponseDto responseDto = userFacade.findByEmail(
                SecurityUtil.getUsername());
        System.out.println(responseDto.getPhone());
        model.addAttribute("user",responseDto);
        return "/pages/clients/user/user_detail";
    }

}
