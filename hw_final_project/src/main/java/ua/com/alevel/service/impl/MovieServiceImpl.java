package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.persistence.repository.MovieRepository;
import ua.com.alevel.service.MovieService;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CrudRepositoryHelper<Movie,MovieRepository> crudRepositoryHelper;


    public MovieServiceImpl(MovieRepository movieRepository, CrudRepositoryHelper<Movie, MovieRepository> crudRepositoryHelper) {
        this.movieRepository = movieRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(Movie entity) {

    }

    @Override
    public void update(Movie entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Movie> findById(Long id) {
        return crudRepositoryHelper.findById(movieRepository,id);
    }

    @Override
    public DataTableResponse<Movie> findAll(DataTableRequest request) {

        return crudRepositoryHelper.findAll(movieRepository,request);
    }
}
