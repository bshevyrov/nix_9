package ua.com.alevel.view.dto.hall;

import ua.com.alevel.view.dto.RequestDto;

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
