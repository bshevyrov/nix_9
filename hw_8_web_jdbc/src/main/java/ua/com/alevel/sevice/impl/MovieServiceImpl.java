package ua.com.alevel.sevice.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.MovieDao;
import ua.com.alevel.entity.Movie;
import ua.com.alevel.sevice.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void create(Movie movies) {
        movieDao.create(movies);
    }

    @Override
    public void update(Movie movies) {
        movieDao.update(movies);
    }

    @Override
    public void delete(long id) {
        //is exist&&
//        if (movieDao.existById(id)) {
            movieDao.delete(id);
//        }
    }

    @Override
    public Movie findById(long id) {
        Movie movie = new Movie();
//        if (movieDao.existById(id)) {
            movie = movieDao.findById(id);
//        }
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }
}
