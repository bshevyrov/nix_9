package ua.com.alevel.view.controller.client;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.CinemaHallSeatFacade;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.facade.ShowFacade;
import ua.com.alevel.facade.ShowSeatFacade;
import ua.com.alevel.persistence.entity.CinemaHallSeat;
import ua.com.alevel.persistence.entity.ShowSeat;
import ua.com.alevel.util.ShowSeatUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;

@Controller
@RequestMapping("/client/show")
public class ClientShowSeatOrderController extends AbstractController {

    private final ShowFacade showFacade;
    private final ShowSeatFacade showSeatFacade;
    private final MovieFacade movieFacade;
    private final CinemaHallSeatFacade cinemaHallSeatFacade;

    public ClientShowSeatOrderController(ShowFacade showFacade, ShowSeatFacade showSeatFacade, MovieFacade movieFacade, CinemaHallSeatFacade cinemaHallSeatFacade) {
        this.showFacade = showFacade;
        this.showSeatFacade = showSeatFacade;
        this.movieFacade = movieFacade;
        this.cinemaHallSeatFacade = cinemaHallSeatFacade;
    }

    @GetMapping("/seat/{id}")
    public String seat(@PathVariable("id") long id, Model model){
        ShowResponseDto showResponseDto = showFacade.findById(id);
        model.addAttribute("show", showResponseDto);
        model.addAttribute("movie", movieFacade.findById(showResponseDto.getMovie().getId()));

        long cinemaHallId = showResponseDto.getCinemaHall().getId();
        int totalSeat = showResponseDto.getCinemaHall().getTotalSeats();
        List<CinemaHallSeatResponseDto> cinemaHallSeatList = cinemaHallSeatFacade.findAllByCinemaHallId(cinemaHallId);
                model.addAttribute("seatMap", ShowSeatUtil.createSeatMap(totalSeat ,cinemaHallSeatList));

        List<ShowSeatResponseDto> showSeatList = showSeatFacade.findAllByShowId(showResponseDto.getId());
        model.addAttribute("soldSeats" ,ShowSeatUtil.createSoldSeats(showSeatList));
        return "/pages/client/show_seat_order";
    }

    @PostMapping("/seat/{id}")
    public String seatOrder(@PathVariable("id") long id,
                            @RequestParam ("sum") int sum,
                            @RequestParam ("chosenSeats") int[] chosenSeats,
                            Model model){

//        model.addAttribute("show", showFacade.findById(id));
        return "redirect:/client/booking";
    }

}
