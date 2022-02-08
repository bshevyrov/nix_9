package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.*;
import ua.com.alevel.persistence.entity.CinemaHallSeat;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.persistence.type.ShowSeatStatus;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.util.ShowSeatUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.request.ShowSeatRequestDto;
import ua.com.alevel.view.dto.response.BookingResponseDto;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/clients/show")
public class ClientShowSeatOrderController extends AbstractController {

    private final UserFacade userFacade;
    private final BookingFacade bookingFacade;
    private final ShowFacade showFacade;
    private final ShowSeatFacade showSeatFacade;
    private final CinemaHallSeatFacade cinemaHallSeatFacade;

    public ClientShowSeatOrderController(UserFacade userFacade, BookingFacade bookingFacade,
                                         ShowFacade showFacade,
                                         ShowSeatFacade showSeatFacade,
                                         CinemaHallSeatFacade cinemaHallSeatFacade) {
        this.userFacade = userFacade;
        this.bookingFacade = bookingFacade;
        this.showFacade = showFacade;
        this.showSeatFacade = showSeatFacade;
        this.cinemaHallSeatFacade = cinemaHallSeatFacade;
    }

    @GetMapping("/seat/{id}")
    public String seat(@PathVariable("id") long id, Model model) {

        model.addAttribute("newBookingRequestDto", new BookingRequestDto());
        ShowResponseDto showResponseDto = showFacade.findById(id);
        model.addAttribute("showResponseDto", showResponseDto);
        long cinemaHallId = showResponseDto.getCinemaHall().getId();
        int totalSeat = showResponseDto.getCinemaHall().getTotalSeats();
        List<CinemaHallSeatResponseDto> cinemaHallSeatList = cinemaHallSeatFacade.findAllByCinemaHallId(cinemaHallId);
        model.addAttribute("seatMap", ShowSeatUtil.createSeatMap(totalSeat, cinemaHallSeatList));
        List<ShowSeatResponseDto> showSeatList = showSeatFacade.findAllByShowId(id);
        model.addAttribute("soldSeats", ShowSeatUtil.createSoldSeats(showSeatList));

        return "/pages/clients/show_seat_order";
    }

    @PostMapping("/seat/{id}")
    public String seatOrder(@PathVariable("id") long id,
                            @ModelAttribute("newBookingRequestDto") BookingRequestDto newBookingRequestDto,
                            @RequestParam("chosenSeats") int[] chosenSeats,
                            Model model) {

        Show show = ClassConverterUtil.showResponseDtoToEntity(showFacade.findById(id));
        newBookingRequestDto.setShow(show);
        String userEmail = SecurityUtil.getUsername();
        User user = ClassConverterUtil.userResponseDtoToEntity(
                userFacade.findByEmail(userEmail));
        newBookingRequestDto.setUser(user);

        //ЕЩВЩscheduller 2 минуты пендинга и снятие с брони
        newBookingRequestDto.setBookingStatus(BookingStatus.PENDING);
        newBookingRequestDto.setTimestamp(Timestamp.from(Instant.now()));
        newBookingRequestDto.setNumberOfSeats(chosenSeats.length);
        BookingResponseDto bookingResponseDto = bookingFacade.save(newBookingRequestDto);

        if (showSeatFacade.findAllByBookingId(bookingResponseDto.getId()).size() <= 0) {

            for (int seat : chosenSeats) {
                CinemaHallSeat cinemaHallSeat = ClassConverterUtil
                        .cinemaHallSeatResponseDtoToCinemaHallSeat(
                                cinemaHallSeatFacade.findById(seat));
                ShowSeatRequestDto requestDto = new ShowSeatRequestDto();
                requestDto.setBooking(ClassConverterUtil.bookingResponseDtoToEntity(bookingResponseDto));
                requestDto.setShow(show);
                requestDto.setPrice(cinemaHallSeat.getCinemaSeatType().getPrice());
                requestDto.setCinemaHallSeat(cinemaHallSeat);
                requestDto.setShowSeatStatus(ShowSeatStatus.UNAVAILABLE);
                showSeatFacade.create(requestDto);

            }
        }
        model.addAttribute("showSeats", showSeatFacade.findAllByBookingId(bookingResponseDto.getId()));
        model.addAttribute("bookingResponseDto", bookingResponseDto);

        return "/pages/clients/booking/booking_confirmation";
    }
}
