package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.view.controller.AbstractController;

@Controller
@RequestMapping("/client/show")
public class ClientShowSeatController extends AbstractController {

    @GetMapping("/seat/{id}")
    public String seat(@PathVariable("id") long id, Model model){

        
        return "/pages/client/show_seat";
    }
}
