package ua.com.alevel.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Show;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends BaseRepository<Show> {

    List<Show> findAllByMovieId(long id);

    Optional<Show> findByMovieId(long id);

    Page<Show> findAllByMovieId(long movieId, Pageable pageable);
}

