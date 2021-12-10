package ua.com.alevel.dao;

import ua.com.alevel.entity.Movie;

import java.util.List;

public interface MovieDao extends BaseDao<Movie>{

    void deleteAllByHallId(Long hallId);

    List<Movie> findAllByHallId(Long hallId);
}
