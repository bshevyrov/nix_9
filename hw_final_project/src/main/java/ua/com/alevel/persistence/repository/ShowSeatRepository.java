package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.ShowSeat;

import java.util.List;

@Repository
public interface ShowSeatRepository extends BaseRepository<ShowSeat> {

    List<ShowSeat> findAllByShowId(long id);

    List<ShowSeat> findAllByBookingId(long id);
}

