package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;

import java.util.List;

@Repository
public interface BookingRepository extends BaseRepository<Booking>{
    Booking findByUser(User user);

    List<Booking> findAllByUser(User user);

}
