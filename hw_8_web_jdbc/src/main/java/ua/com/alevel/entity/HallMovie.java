package ua.com.alevel.entity;

public class HallMovie extends BaseEntity{

    Long hallId;
    Long movieId;

    public HallMovie() {
        super();
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
