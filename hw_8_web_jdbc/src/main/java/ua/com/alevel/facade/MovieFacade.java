package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.MovieRequestDto;
import ua.com.alevel.view.dto.response.MovieResponseDto;

import java.util.List;

public interface MovieFacade extends BaseFacade<MovieRequestDto, MovieResponseDto> {

    List<MovieResponseDto> findAllByHall(Long hallId);
}
