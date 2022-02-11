package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.entity.Movie;

import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class ShowResponseDto extends ResponseDto {


    private Date date;

    private LocalTime startTime;

    private LocalTime endTime;

    private CinemaHall cinemaHall;

    private Movie movie;

    public String getSimpleDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Month month = Month.of(calendar.get(Calendar.MONTH) + 1);
        Locale locale = Locale.getDefault();
        String monthStr = month.getDisplayName(TextStyle.SHORT, locale);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return monthStr + " " + day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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
