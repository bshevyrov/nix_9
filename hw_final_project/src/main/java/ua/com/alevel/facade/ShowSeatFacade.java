package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.ShowSeatRequestDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;

public interface ShowSeatFacade extends BaseFacade<ShowSeatRequestDto, ShowSeatResponseDto> {
    List<ShowSeatResponseDto> findAllByShowId(long id);
}
