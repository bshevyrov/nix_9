package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.view.dto.request.HallRequestDto;
import ua.com.alevel.view.dto.response.HallResponseDto;
import ua.com.alevel.facade.HallFacade;
import ua.com.alevel.view.dto.response.PageDataResponse;


@Controller
@RequestMapping("/halls")
public class HallController {

    private final HallFacade hallFacade;

    public HallController(HallFacade hallFacade) {
        this.hallFacade = hallFacade;
    }

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        PageDataResponse<HallResponseDto> response = hallFacade.findAll(request);
        model.addAttribute("pageData", response);
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

    @GetMapping("/details/{id}")
    public String findById(@PathVariable Long id, Model model){
        model.addAttribute("hall", hallFacade.findById(id));
        return "pages/hall/hall_details";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        hallFacade.delete(id);
        return "redirect:/halls";
    }
}
