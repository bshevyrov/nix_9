package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.CinemaSeatType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cinema_seats")
public class CinemaSeat extends BaseEntity {

    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "cinema_seat_type")
    @Enumerated(EnumType.STRING)
    private CinemaSeatType cinemaSeatType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_hall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

    public CinemaSeat() {
        super();
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public CinemaSeatType getCinemaSeatType() {
        return cinemaSeatType;
    }

    public void setCinemaSeatType(CinemaSeatType cinemaSeatType) {
        this.cinemaSeatType = cinemaSeatType;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaSeat that = (CinemaSeat) o;
        return seatNumber == that.seatNumber && cinemaSeatType == that.cinemaSeatType && Objects.equals(cinemaHall, that.cinemaHall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, cinemaSeatType, cinemaHall);
    }
}
