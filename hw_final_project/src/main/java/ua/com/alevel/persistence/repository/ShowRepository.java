package ua.com.alevel.persistence.repository;

import org.springframework.data.domain.Example;
import ua.com.alevel.persistence.entity.Show;

import java.util.Optional;

public interface ShowRepository extends BaseRepository<Show> {


    Optional <Show> findByMovieId(long id);
}
