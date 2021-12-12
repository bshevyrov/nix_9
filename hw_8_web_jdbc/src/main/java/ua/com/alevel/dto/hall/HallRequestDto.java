package ua.com.alevel.dto.hall;

import ua.com.alevel.dto.RequestDto;

public class HallRequestDto extends RequestDto {
    private String name;
    private int numOfSeats;

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
