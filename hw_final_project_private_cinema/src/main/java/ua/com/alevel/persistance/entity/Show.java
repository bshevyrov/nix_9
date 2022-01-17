package ua.com.alevel.persistance.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Show extends BaseEntity {

    private Date date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long cinemaHallId;
    private long movieId;

    public Show() {
        super();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Show show = (Show) o;
        return cinemaHallId == show.cinemaHallId && movieId == show.movieId && Objects.equals(date, show.date) && Objects.equals(startTime, show.startTime) && Objects.equals(endTime, show.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, startTime, endTime, cinemaHallId, movieId);
    }
}
