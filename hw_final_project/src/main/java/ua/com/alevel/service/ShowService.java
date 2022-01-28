package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService extends BaseCrudService<Show> {
    Optional<Show> findByMovieId(long id);

        List<Show> findAllByMovieId(Long id);


}
