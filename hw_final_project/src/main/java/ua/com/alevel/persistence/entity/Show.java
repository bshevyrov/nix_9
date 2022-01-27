package ua.com.alevel.persistence.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shows")
public class Show extends BaseEntity {

    @Column(name = "date")
//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP")
//        @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_hall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    public Show() {
        super();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
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
        Show show = (Show) o;
        return Objects.equals(date, show.date) && Objects.equals(startTime, show.startTime) && Objects.equals(endTime, show.endTime) && Objects.equals(cinemaHall, show.cinemaHall) && Objects.equals(movie, show.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, startTime, endTime, cinemaHall, movie);
    }
}
