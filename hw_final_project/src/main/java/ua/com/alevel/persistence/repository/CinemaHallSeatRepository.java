package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.CinemaHallSeat;

import java.util.List;

@Repository
public interface CinemaHallSeatRepository extends BaseRepository<CinemaHallSeat> {

    List<CinemaHallSeat> findAllByCinemaHallId(long id);
}
