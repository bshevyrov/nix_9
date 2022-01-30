package ua.com.alevel.view.controller.client;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.BookingFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.response.BookingResponseDto;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientBookingController extends AbstractController {

    private final BookingFacade bookingFacade;
    private final UserFacade userFacade;

    public ClientBookingController(BookingFacade bookingFacade, UserFacade userFacade) {
        this.bookingFacade = bookingFacade;
        this.userFacade = userFacade;
    }


    @PostMapping("/booking/dashboard")
    public String bookingDash1(@ModelAttribute("confirm1") String confirm1,
//                                @RequestParam("bookingStatus") String bookingStatus,
                               Model model) {


        List<BookingResponseDto> responseDtos = bookingFacade.findAllByUser(ClassConverterUtil.userResponseDtoToEntity(userFacade.findByEmail(SecurityUtil.getUsername())));

        long id = responseDtos.get(responseDtos.size() - 1).getId();
        BookingResponseDto responseDtos1 = bookingFacade.findById(id);
        if(!(StringUtils.equals(responseDtos1.getBookingStatus().name(),"SUCCESS"))){
            if (StringUtils.equals("agree", confirm1)) {
                bookingFacade.buy(id);
            } else {
                System.out.println("NOT BUY");
            }
        }

        model.addAttribute("bookingList", bookingFacade.findAll());
//        model.addAttribute("show", responseDtos);
//        model.addAttribute("bookingList", responseDtos);

        return "/pages/clients/booking_dashboard";
    }

    @GetMapping("/booking/{id}")
    public String booking(@PathVariable("id") long id,
                          Model model) {
        model.addAttribute("booking", bookingFacade.findById(id));
        model.addAttribute("agreement", new BookingRequestDto());
        return "/pages/clients/booking";
    }

    @PostMapping("/booking/{id}")
    public String bookingUpd(@PathVariable("id") long id,
                             @ModelAttribute BookingRequestDto bookingRequestDto,
                             Model model) {
        bookingFacade.update(bookingRequestDto);
        return "redirect:/booking/all";
    }

//    @GetMapping("/booking/all")
//    public String bookingDash(Model model) {
//        model.addAttribute("booking", bookingFacade.findAllByUser(ClassConverterUtil
//                .userResponseDtoToEntity(userFacade.findByEmail(SecurityUtil.getUsername()))));
//        model.addAttribute("agreement", new BookingRequestDto());
//        return "/pages/clients/booking/dashboard";
//    }
}
