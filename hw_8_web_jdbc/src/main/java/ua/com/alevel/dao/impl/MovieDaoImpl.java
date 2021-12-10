package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.MovieDao;
import ua.com.alevel.entity.Movie;

import java.util.List;

@Service
public class MovieDaoImpl implements MovieDao {

    @Override
    public void create(Movie movie) {

    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existById(Long id) {
        return false;
    }

    @Override
    public Movie findById(Long id) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public void deleteAllByHallId(Long hallId) {

    }

    @Override
    public List<Movie> findAllByHallId(Long hallId) {
        return null;
    }
}
