package ua.com.alevel.view.dto.response;

import ua.com.alevel.view.dto.response.ResponseDto;
import ua.com.alevel.persistence.entity.Hall;
import ua.com.alevel.persistence.entity.Movie;

public class MovieResponseDto extends ResponseDto {

    private String name;
    private String description;

    public MovieResponseDto() {
    }

    public MovieResponseDto(Movie movie) {
        setId(movie.getId());
        setName(movie.getName());
        setDescription(movie.getDescription());
//        if (movie.getHall() != null) {
//            this.hall = movie.getHall();
//        }
    }
//    private Hall hall;

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
//    public Hall getHall() {
//        return hall;
//    }
//
//    public void setHall(Hall hall) {
//        this.hall = hall;

//    }
}
