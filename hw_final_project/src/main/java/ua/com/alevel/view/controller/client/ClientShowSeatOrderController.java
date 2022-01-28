package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.view.controller.AbstractController;

@Controller
@RequestMapping("/client/show")
public class ClientShowSeatOrderController extends AbstractController {

    private final ShowFacade showFacade;

    public ClientShowSeatOrderController(ShowFacade showFacade) {
        this.showFacade = showFacade;
    }

    @GetMapping("/seat/{id}")
    public String seat(@PathVariable("id") long id, Model model){
        model.addAttribute("show", showFacade.findById(id));
        return "/pages/client/show_seat_order";
    }

    @PostMapping("/seat/{id}")
    public String seatOrder(@PathVariable("id") long id, Model model){
        model.addAttribute("show", showFacade.findById(id));
        return "/pages/client/show_seat_order";
    }

}
