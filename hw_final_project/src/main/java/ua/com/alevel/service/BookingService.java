package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import java.util.List;


public interface BookingService extends BaseCrudService<Booking> {

    Booking save(Booking booking);

    DataTableResponse<Booking> findAllByUser(User user, DataTableRequest request);

    List<Booking> findAllByUser(User user);

    List<Booking> findAllByBookingStatus(BookingStatus status);

    void removeCopy(User user);

    void deletePendingBooking();
}
