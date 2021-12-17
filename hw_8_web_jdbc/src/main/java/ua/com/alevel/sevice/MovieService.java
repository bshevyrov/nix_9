package ua.com.alevel.sevice;

import ua.com.alevel.entity.Hall;
import ua.com.alevel.entity.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie> {

    List<Movie> findAllByHall(Hall hall);
}
