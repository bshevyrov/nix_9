package ua.com.alevel.view.dto.request;

import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.entity.Movie;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class ShowRequestDto extends RequestDto {


    private Date date;

    private LocalTime startTime;

    private LocalTime endTime;

    private CinemaHall cinemaHall;

    private Movie movie;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime);
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalTime.parse(endTime);
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
        ShowRequestDto that = (ShowRequestDto) o;
        return Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(cinemaHall, that.cinemaHall) && Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, endTime, cinemaHall, movie);
    }
}
