package ua.com.alevel.dto.movie;

import ua.com.alevel.dto.ResponseDto;
import ua.com.alevel.persistence.entity.Hall;
import ua.com.alevel.persistence.entity.Movie;

public class MovieResponseDto extends ResponseDto {

    private String name;
    private String description;
    private Hall hall;

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

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public MovieResponseDto() {
    }

    public MovieResponseDto(Movie movie) {
        this.name = movie.getName();
        this.description = movie.getDescription();
        if (movie.getHall() != null) {
            this.hall = movie.getHall();
        }
        super.setId(movie.getId());
    }
}
