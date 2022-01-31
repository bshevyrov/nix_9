package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.persistence.repository.MovieRepository;
import ua.com.alevel.service.MovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CrudRepositoryHelper<Movie, MovieRepository> crudRepositoryHelper;


    public MovieServiceImpl(MovieRepository movieRepository, CrudRepositoryHelper<Movie, MovieRepository> crudRepositoryHelper) {
        this.movieRepository = movieRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void create(Movie entity) {
        if (entity.getId() != 0) {
            crudRepositoryHelper.update(movieRepository, entity);
        }
        crudRepositoryHelper.create(movieRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(Movie entity) {
        crudRepositoryHelper.update(movieRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void delete(Long id) {
        crudRepositoryHelper.delete(movieRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movie> findById(Long id) {
        return crudRepositoryHelper.findById(movieRepository, id);
    }

    @Override
    public List<Movie> findAll() {
        return crudRepositoryHelper.findAll(movieRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Movie> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(movieRepository, request);
    }
}
