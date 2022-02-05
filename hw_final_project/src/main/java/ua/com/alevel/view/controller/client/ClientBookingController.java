package ua.com.alevel.view.controller.client;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.BookingFacade;
import ua.com.alevel.facade.ShowSeatFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.response.BookingResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientBookingController extends AbstractController {

    private final BookingFacade bookingFacade;
    private final UserFacade userFacade;
    private final ShowSeatFacade showSeatFacade;

    public ClientBookingController(BookingFacade bookingFacade, UserFacade userFacade, ShowSeatFacade showSeatFacade) {
        this.bookingFacade = bookingFacade;
        this.userFacade = userFacade;
        this.showSeatFacade = showSeatFacade;
    }


    @GetMapping("/booking/dashboard")
    public String bookingMeth(WebRequest request, ModelMap model) {
        model.addAttribute("bookingList", bookingFacade
                .findAllByUser(ClassConverterUtil
                        .userResponseDtoToEntity(
                                userFacade.findByEmail(
                                        SecurityUtil.getUsername()))));

            HeaderName[] columnNames = getColumnNames();
            PageDataResponse<BookingResponseDto> response =bookingFacade
                    .findAllByUser(ClassConverterUtil
                            .userResponseDtoToEntity(
                                    userFacade.findByEmail(
                                            SecurityUtil.getUsername())), request);
            response.initPaginationState(response.getCurrentPage());
            List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
            model.addAttribute("headerDataList", headerDataList);
            model.addAttribute("createUrl", "/clients/booking/dashboard");
            model.addAttribute("pageData", response);
            model.addAttribute("cardHeader", "Booking History");
            model.addAttribute("allowCreate", true);

        return "/pages/clients/booking/booking_dashboard";
    }

    @GetMapping("/booking/detail/{id}")
    public String details(@PathVariable("id") long id,
                          Model model) {
        model.addAttribute("booking", bookingFacade.findById(id));
        model.addAttribute("showSeats", showSeatFacade.findAllByBookingId(id) );
        return "/pages/clients/booking/booking_details";
    }

    @PostMapping("/booking/{id}")
    public String bookingUpd(@PathVariable("id") long id,
                             @ModelAttribute("confirm") String confirm,
                             Model model) {

        if (!confirm.isEmpty() && StringUtils.equals("agree", confirm)) {
                bookingFacade.buy(id);


                //SPIKE
//                bookingFacade.removeCopy(ClassConverterUtil
//                        .userResponseDtoToEntity(
//                                userFacade.findByEmail(
//                                        SecurityUtil.getUsername())));
//                        }
                //
        }
        return "redirect:/clients/booking/dashboard";
    }



    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Date", "timestamp", "timestamp"),
                new HeaderName("Booking status", "booking_status", "bookingStatus"),
                new HeaderName("Total Price", "total_price", "totalPrice"),
           };
    }
}
