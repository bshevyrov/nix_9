package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.view.controller.AbstractController;

@Controller
@RequestMapping("/client/booking")
public class ClientBookingController extends AbstractController {

    @GetMapping
    public String booking(Model model){

        return "/pages/client/booking";
    }
}
