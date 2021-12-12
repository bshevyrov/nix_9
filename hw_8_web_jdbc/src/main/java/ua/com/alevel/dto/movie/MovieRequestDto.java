package ua.com.alevel.dto.movie;

import ua.com.alevel.dto.RequestDto;

public class MovieRequestDto extends RequestDto {


    private String name;
    private String description;
    private Long hallId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }
}
