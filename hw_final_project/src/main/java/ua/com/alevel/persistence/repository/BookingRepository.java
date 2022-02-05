package ua.com.alevel.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BookingRepository extends BaseRepository<Booking> {

    List<Booking> findAllByUser(User user);

    Page<Booking> findAllByUserId(Long userId, Pageable pageable);

    List<Booking> findAllByBookingStatus(BookingStatus status);

    void deleteAllByBookingStatusAndTimestampGreaterThanEqual(BookingStatus bookingStatus, Timestamp timestamp);
}
