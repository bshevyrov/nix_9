package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Show;

import java.util.Optional;

@Repository
public interface ShowRepository extends BaseRepository<Show> {


    Optional<Show> findByMovieId(long id);
}
