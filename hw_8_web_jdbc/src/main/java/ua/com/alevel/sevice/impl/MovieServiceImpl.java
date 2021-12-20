package ua.com.alevel.sevice.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.dao.MovieDao;
import ua.com.alevel.persistence.entity.Hall;
import ua.com.alevel.persistence.entity.Movie;
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
//        Movie movie = new Movie();
////        if (movieDao.existById(id)) {
//            movie = movieDao.findById(id);
////        }
//        return movie;
        return movieDao.findById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public List<Movie> findAllByHall(Hall hall) {
        return movieDao.findAllByHallId(hall.getId());
    }
}
