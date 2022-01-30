package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.*;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.ShowSeatStatus;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.util.ShowSeatUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.request.ShowSeatRequestDto;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;

@Controller
@RequestMapping("/client/show")
public class ClientShowSeatOrderController extends AbstractController {

    private final UserFacade userFacade;
    private final BookingFacade bookingFacade;
    private final ShowFacade showFacade;
    private final ShowSeatFacade showSeatFacade;
    private final MovieFacade movieFacade;
    private final CinemaHallSeatFacade cinemaHallSeatFacade;

    public ClientShowSeatOrderController(UserFacade userFacade, BookingFacade bookingFacade,
                                         ShowFacade showFacade,
                                         ShowSeatFacade showSeatFacade,
                                         MovieFacade movieFacade,
                                         CinemaHallSeatFacade cinemaHallSeatFacade) {
        this.userFacade = userFacade;
        this.bookingFacade = bookingFacade;
        this.showFacade = showFacade;
        this.showSeatFacade = showSeatFacade;
        this.movieFacade = movieFacade;
        this.cinemaHallSeatFacade = cinemaHallSeatFacade;
    }

    @GetMapping("/seat/{id}")
    public String seat(@PathVariable("id") long id, Model model) {
        //request responce TODO yне та ентитя
        model.addAttribute("showSeat", new ShowSeatRequestDto());
        ShowResponseDto showResponseDto = showFacade.findById(id);
        model.addAttribute("show", showResponseDto);
        model.addAttribute("movie", movieFacade.findById(showResponseDto.getMovie().getId()));

        long cinemaHallId = showResponseDto.getCinemaHall().getId();
        int totalSeat = showResponseDto.getCinemaHall().getTotalSeats();
        List<CinemaHallSeatResponseDto> cinemaHallSeatList = cinemaHallSeatFacade.findAllByCinemaHallId(cinemaHallId);
        model.addAttribute("seatMap", ShowSeatUtil.createSeatMap(totalSeat, cinemaHallSeatList));

        List<ShowSeatResponseDto> showSeatList = showSeatFacade.findAllByShowId(showResponseDto.getId());
        model.addAttribute("soldSeats", ShowSeatUtil.createSoldSeats(showSeatList));
        return "/pages/client/show_seat_order";
    }

    @PostMapping("/seat/{id}")
    public String seatOrder(@PathVariable("id") long id,
                            @RequestParam("sum") int sum,
                            @RequestParam("chosenSeats") int[] chosenSeats,
                            Model model) {
        System.out.println(SecurityUtil.getUsername());

        for (int seat : chosenSeats) {

            BookingRequestDto bookingRequestDto = new BookingRequestDto();
            String userEmail = SecurityUtil.getUsername();
            User user = ClassConverterUtil.userResponseDtoToEntity(
                    userFacade.findByEmail(userEmail));
            bookingRequestDto.setUser(user);
            bookingRequestDto.setShow(ClassConverterUtil.showResponseDtoToEntity( showFacade.findById(id)));

            bookingFacade.create(bookingRequestDto);

            ShowSeatRequestDto requestDto = new ShowSeatRequestDto();
            List<CinemaHallSeatResponseDto> responseDtos = cinemaHallSeatFacade.findAll();
            CinemaHallSeatResponseDto responseDto = responseDtos.stream().
                    filter(responseDtoa -> seat == (responseDtoa.getSeatNumber()))
                    .findFirst().get();

            requestDto.setPrice(responseDto.getCinemaSeatType().getPrice());
            requestDto.setShow(ClassConverterUtil.
                    showResponseDtoToEntity(showFacade.findById(id)));
            requestDto.setCinemaHallSeat(ClassConverterUtil
                    .cinemaHallSeatResponseDtoToCinemaHallSeat(
                            cinemaHallSeatFacade.findById(seat)));
            requestDto.setShowSeatStatus(ShowSeatStatus.UNAVAILABLE);



//            requestDto.setBooking(ClassConverterUtil.bookingResponseDtoToEntity(
//                    bookingFacade.findByUser(user)));
            showSeatFacade.create(requestDto);
        }
//        model.addAttribute()
        return "redirect:/client/booking";

    }
   /* @PostMapping("/seat/{id}")
    public String seatOrder(@PathVariable("id") long id,
                            @ModelAttribute("showSeats") List<ShowSeatRequestDto> showSeats,
                            Model model){

        for (ShowSeatRequestDto showSeat : showSeats) {
            System.out.println(showSeat.toString());
        }
        return "redirect:/client/booking";
    }*/

}
