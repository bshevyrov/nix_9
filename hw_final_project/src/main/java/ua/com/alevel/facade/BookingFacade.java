package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.response.BookingResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;

public interface BookingFacade extends BaseFacade<BookingRequestDto, BookingResponseDto> {


    BookingResponseDto save(BookingRequestDto requestDto);

    List<BookingResponseDto> findAllByUser(User user);

    PageDataResponse<BookingResponseDto> findAllByUser(User user, WebRequest request);

    List<Booking> findAllByBookingStatus(BookingStatus status);

    void buy(long id);

    void removeCopy(User user);
}
