package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.type.CinemaHallType;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;
import java.util.Map;

public interface ShowFacade extends BaseFacade<ShowRequestDto, ShowResponseDto> {

    ShowResponseDto findByMovieId(long id);

    List<ShowResponseDto> findAllByMovieId(long id);

    PageDataResponse<ShowResponseDto> findAllByMovieId(long id, WebRequest request);

    Map<String,List<ShowResponseDto>> getShowsByMovieIdSortedByCinemaHallType(long id);
}
