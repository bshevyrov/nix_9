package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.type.CinemaSeatType;

import java.util.Objects;

public class CinemaHallSeatResponseDto extends ResponseDto {

    private int seatNumber;

    private CinemaSeatType cinemaSeatType;

    private CinemaHall cinemaHall;

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
        CinemaHallSeatResponseDto that = (CinemaHallSeatResponseDto) o;
        return seatNumber == that.seatNumber && cinemaSeatType == that.cinemaSeatType && Objects.equals(cinemaHall, that.cinemaHall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, cinemaSeatType, cinemaHall);
    }
}
