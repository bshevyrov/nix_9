package ua.com.alevel.facade;

import ua.com.alevel.dto.movie.MovieRequestDto;
import ua.com.alevel.dto.movie.MovieResponseDto;
import ua.com.alevel.entity.Hall;

import java.util.List;

public interface MovieFacade extends BaseFacade<MovieRequestDto, MovieResponseDto> {

    List<MovieResponseDto> findAllByHall(Long hallId);
}
