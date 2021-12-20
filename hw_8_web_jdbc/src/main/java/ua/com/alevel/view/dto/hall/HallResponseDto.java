package ua.com.alevel.view.dto.hall;

import ua.com.alevel.view.dto.response.ResponseDto;
import ua.com.alevel.persistence.entity.Hall;

public class HallResponseDto extends ResponseDto {

    private String name;
    private int numOfSeats;
    private Integer movieCount;

    public HallResponseDto() {
    }

    public HallResponseDto(Hall hall){
        setName(hall.getName());
        setNumOfSeats(hall.getNumOfSeats());
        setId(hall.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public Integer getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Integer movieCount) {
        this.movieCount = movieCount;
    }
}
