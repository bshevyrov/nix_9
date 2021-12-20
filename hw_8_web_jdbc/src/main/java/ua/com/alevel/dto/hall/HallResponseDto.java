package ua.com.alevel.dto.hall;

import ua.com.alevel.dto.ResponseDto;
import ua.com.alevel.persistence.entity.Hall;

public class HallResponseDto extends ResponseDto {

    private String name;
    private int numOfSeats;

    public HallResponseDto() {
    }

    public HallResponseDto(Hall hall){
        this.name = hall.getName();
        this.numOfSeats = hall.getNumOfSeats();
        super.setId(hall.getId());
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
}
