package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.ShowSeat;

import java.util.List;

public interface ShowSeatService extends BaseCrudService<ShowSeat> {
    List<ShowSeat> findAllByShowId(long id);

    ShowSeat save(ShowSeat showSeat);

    List<ShowSeat> findAllByBookingId(long id);
}

