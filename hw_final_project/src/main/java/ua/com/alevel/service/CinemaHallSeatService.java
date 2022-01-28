package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.CinemaHallSeat;

import java.util.List;

public interface CinemaHallSeatService extends BaseCrudService<CinemaHallSeat> {

    List<CinemaHallSeat> findAllByCinemaHallId(long id);

}
