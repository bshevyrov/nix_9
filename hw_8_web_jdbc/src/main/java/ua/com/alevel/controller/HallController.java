package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.dto.hall.HallResponseDto;
import ua.com.alevel.facade.HallFacade;

import java.util.List;

@Controller
@RequestMapping("/halls")
public class HallController {

    private final HallFacade hallFacade;

    public HallController(HallFacade hallFacade) {
        this.hallFacade = hallFacade;
    }

@GetMapping
    public String findAll(Model model){
        List<HallResponseDto> halls = hallFacade.findAll();
        model.addAttribute("halls", halls);
        return "pages/hall/hall_all";
    }
}
