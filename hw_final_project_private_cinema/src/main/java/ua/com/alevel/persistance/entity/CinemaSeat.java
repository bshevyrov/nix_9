package ua.com.alevel.persistance.entity;

import ua.com.alevel.persistance.type.CinemaSeatType;

import java.util.Objects;

public class CinemaSeat extends BaseEntity {

    private int seatNumber;
    private CinemaSeatType cinemaSeatType;
    private long cinemaHallId;

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

    public long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CinemaSeat that = (CinemaSeat) o;
        return seatNumber == that.seatNumber && cinemaHallId == that.cinemaHallId && cinemaSeatType == that.cinemaSeatType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatNumber, cinemaSeatType, cinemaHallId);
    }
}
