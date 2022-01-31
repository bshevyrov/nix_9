package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.CinemaHallSeatRequestDto;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;

import java.util.List;

public interface CinemaHallSeatFacade extends BaseFacade<CinemaHallSeatRequestDto, CinemaHallSeatResponseDto> {

    List<CinemaHallSeatResponseDto> findAllByCinemaHallId(long id);

}
