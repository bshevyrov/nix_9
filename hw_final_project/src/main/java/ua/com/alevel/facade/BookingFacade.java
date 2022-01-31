package ua.com.alevel.facade;

import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.response.BookingResponseDto;

import java.util.List;

public interface BookingFacade extends BaseFacade<BookingRequestDto, BookingResponseDto> {

    BookingResponseDto findByUser(User user);

    BookingResponseDto save(BookingRequestDto requestDto);

    List<BookingResponseDto> findAllByUser(User user);

    List<Booking> findAllByBookingStatus(BookingStatus status);

    void buy(long id);
}
