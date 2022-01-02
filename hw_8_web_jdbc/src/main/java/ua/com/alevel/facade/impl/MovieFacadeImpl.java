package ua.com.alevel.facade.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Hall;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.sevice.HallService;
import ua.com.alevel.sevice.MovieService;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.MovieRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFacadeImpl implements MovieFacade {

//    private final HallService hallService;
    private final MovieService movieService ;

    public MovieFacadeImpl(MovieService movieService) {
//        this.hallService = hallService;
        this.movieService = movieService;
    }

    @Override
    public void create(MovieRequestDto movieRequestDto) {
        //TODO могут быть ошибки в возвращении хола
//        Hall hall = hallService.findById(movieRequestDto.getHallId());
        Movie movie = new Movie();
        movie.setName(movieRequestDto.getName());
        movie.setDescription(movieRequestDto.getDescription());
//        movie.setHall(hall);
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

    }

//    @Override
//    public void delete(Long id) {
//        hallService.delete(id);
//    }

    @Override
    public MovieResponseDto findById(Long id) {
        return new MovieResponseDto(movieService.findById(id));
    }

    @Override
    public PageDataResponse<MovieResponseDto> findAll(WebRequest webRequest) {
        DataTableRequest dataTableRequest = new DataTableRequest();
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(webRequest);
        SortData sortData = WebRequestUtil.generateSortData(webRequest);
        dataTableRequest.setOrder(sortData.getOrder());
        dataTableRequest.setSort(sortData.getSort());
        dataTableRequest.setCurrentPage(pageAndSizeData.getPage());
        dataTableRequest.setPageSize(dataTableRequest.getPageSize());


       DataTableResponse<Movie> all = movieService.findAll(dataTableRequest);;

       PageDataResponse<MovieResponseDto> pageDataResponse = new PageDataResponse<>();
       List<MovieResponseDto> items = all.getItems().stream().map(MovieResponseDto::new).collect(Collectors.toList());

        pageDataResponse.setItems(items);
        pageDataResponse.setCurrentPage(dataTableRequest.getCurrentPage());
        pageDataResponse.setPageSize(dataTableRequest.getPageSize());
        pageDataResponse.setOrder(dataTableRequest.getOrder());
        pageDataResponse.setSort(dataTableRequest.getSort());
        pageDataResponse.setCurrentPage(dataTableRequest.getCurrentPage());
        pageDataResponse.setItemSize(pageDataResponse.getItemSize());
        pageDataResponse.initPaginationState(pageAndSizeData.getPage());
        return pageDataResponse;
    }


//    @Override
//    public List<MovieResponseDto> findAllByHall(Long hallId) {
//        return convertToDtoByEntity(movieService.findAllByHall(hallService.findById(hallId)));
//    }

    private List<MovieResponseDto> convertToDtoByEntity(List<Movie> movies) {
        return movies.stream()
                .map(MovieResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieResponseDto> findAllByHall(Long hallId) {
        return null;
    }
}
