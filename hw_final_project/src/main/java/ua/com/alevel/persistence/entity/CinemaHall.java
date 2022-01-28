package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.CinemaHallType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cinema_halls")
public class CinemaHall extends BaseEntity {

    @Column(name = "cinema_hall_type")
    @Enumerated(EnumType.STRING)
    CinemaHallType cinemaHallType;

    @Column(name = "name")
    private String name;

    @Column(name = "total_seats")
    private int totalSeats;

    public CinemaHall() {
        super();
    }

    public CinemaHallType getCinemaHallType() {
        return cinemaHallType;
    }

    public void setCinemaHallType(CinemaHallType cinemaHallType) {
        this.cinemaHallType = cinemaHallType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaHall that = (CinemaHall) o;
        return totalSeats == that.totalSeats && cinemaHallType == that.cinemaHallType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaHallType, name, totalSeats);
    }
}
