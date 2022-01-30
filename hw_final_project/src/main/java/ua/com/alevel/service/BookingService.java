package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;

import java.util.Collection;
import java.util.List;


public interface BookingService extends BaseCrudService<Booking> {
    Booking findByUser(User user);

    Booking save(Booking booking);

    List<Booking> findAllByUser(User user);
}
