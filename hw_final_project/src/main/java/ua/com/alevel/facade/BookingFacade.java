package ua.com.alevel.facade;

import ua.com.alevel.facade.BaseFacade;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.response.BookingResponseDto;

import java.util.List;

public interface BookingFacade extends BaseFacade<BookingRequestDto, BookingResponseDto> {
//    BookingResponseDto findByUser(User user);
//
//    List<BookingResponseDto> findAllByUser(User user);
}
