package ua.com.alevel.facade.impl;


import org.springframework.stereotype.Service;
import ua.com.alevel.dto.movie.MovieRequestDto;
import ua.com.alevel.dto.movie.MovieResponseDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.entity.Movie;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.sevice.HallService;
import ua.com.alevel.sevice.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFacadeImpl implements MovieFacade {

    private final HallService hallService;
    private final MovieService movieService;

    public MovieFacadeImpl(HallService hallService, MovieService movieService) {
        this.hallService = hallService;
        this.movieService = movieService;
    }

    @Override
    public void create(MovieRequestDto movieRequestDto) {
        //TODO могут быть ошибки в возвращении хола
        Hall hall = hallService.findById(movieRequestDto.getHallId());
        Movie movie = new Movie();
        movie.setName(movieRequestDto.getName());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setHall(hall);
        movieService.create(movie);
    }

    @Override
    public void update(MovieRequestDto movieRequestDto, Long id) {
        Movie movie = movieService.findById(id);
        movie.setName(movieRequestDto.getName());
        movie.setDescription(movieRequestDto.getDescription());
        // movie.setHall(movieRequestDto.getHallId());
        movieService.update(movie);
    }

    @Override
    public void delete(Long id) {
        hallService.delete(id);
    }

    @Override
    public MovieResponseDto findById(Long id) {
        return new MovieResponseDto(movieService.findById(id));
    }

    @Override
    public List<MovieResponseDto> findAll() {
        return movieService.findAll().stream().map(MovieResponseDto::new).collect(Collectors.toList());
    }
}
