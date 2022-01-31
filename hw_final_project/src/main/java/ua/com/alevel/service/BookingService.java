package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import java.util.List;


public interface BookingService extends BaseCrudService<Booking> {
    Booking findByUser(User user);

    Booking save(Booking booking);

    List<Booking> findAllByUser(User user);

    List<Booking> findAllByBookingStatus(BookingStatus status);

}
