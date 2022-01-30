package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.persistence.entity.Show;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public interface ShowRepository extends BaseRepository<Show> {

    List<Show> findAllByMovieId(long id);

    Optional<Show> findByMovieId(long id);

//    DataTableResponse<E> findAllByMovie(Movie movie, DataTableRequest request);
}

