package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.type.CinemaHallType;

import java.util.Objects;

public class CinemaHallResponseDto extends ResponseDto {


    CinemaHallType cinemaHallType;
    private String name;
    private int totalSeats;

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
        CinemaHallResponseDto that = (CinemaHallResponseDto) o;
        return totalSeats == that.totalSeats && cinemaHallType == that.cinemaHallType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cinemaHallType, name, totalSeats);
    }
}
