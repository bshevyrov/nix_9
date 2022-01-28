package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;

public interface ShowFacade extends BaseFacade<ShowRequestDto, ShowResponseDto> {

    ShowResponseDto findByMovieId(long id);

    List<ShowResponseDto> findAllByMovieId(long id);

}
