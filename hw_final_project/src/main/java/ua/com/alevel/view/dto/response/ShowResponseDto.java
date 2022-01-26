package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.entity.Movie;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class ShowResponseDto extends  ResponseDto{


    private Date date;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private CinemaHall cinemaHall;

    private Movie movie;


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

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowResponseDto that = (ShowResponseDto) o;
        return Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(cinemaHall, that.cinemaHall) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, endTime, cinemaHall, movie);
    }
}
