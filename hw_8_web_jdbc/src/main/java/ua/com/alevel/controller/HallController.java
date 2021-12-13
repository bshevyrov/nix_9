package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.dto.hall.HallRequestDto;
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
    public String findAll(Model model) {
        List<HallResponseDto> halls = hallFacade.findAll();
        model.addAttribute("halls", halls);
        return "pages/hall/hall_all";
    }

    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        //модел  адд атрибьют, те модели что передаем на ХТМЛИНУ
        model.addAttribute("hall", new HallRequestDto());
        return "pages/hall/hall_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute("hall") HallRequestDto hallRequestDto) {
        hallFacade.create(hallRequestDto);
        return "redirect:/halls";
    }
}
