package ua.com.alevel.persistance.entity;

import java.util.Objects;

public class CinemaHall extends BaseEntity{

    private String name;
    private int totalSeats;
    private long cinemaId;

    public CinemaHall() {
        super();
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

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CinemaHall that = (CinemaHall) o;
        return totalSeats == that.totalSeats && cinemaId == that.cinemaId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, totalSeats, cinemaId);
    }
}
