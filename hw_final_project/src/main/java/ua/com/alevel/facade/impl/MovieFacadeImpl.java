package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.MovieFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.service.MovieService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.MovieRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFacadeImpl implements MovieFacade {


    private final MovieService movieService;

    public MovieFacadeImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override

    public void create(MovieRequestDto movieRequestDto) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(MovieRequestDto movieRequestDto) {

    }

    @Override
    public MovieResponseDto findById(long id) {
        return ClassConverterUtil.movieToMovieResponseDto(movieService.findById(id).get());
    }

    @Override
    public List<MovieResponseDto> findAll() {
        return movieService.findAll().stream()
                .map(ClassConverterUtil::movieToMovieResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<MovieResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Movie> all = movieService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);

    }

    private PageDataResponse<MovieResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<Movie> all) {
        List<MovieResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::movieToMovieResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<MovieResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

}
