package ua.com.alevel.dto.movie;

import ua.com.alevel.dto.ResponseDto;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.entity.Movie;

public class MovieResponseDto extends ResponseDto {
    private String name;
    private String description;
    private Hall hall;

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
