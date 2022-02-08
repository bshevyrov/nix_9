package ua.com.alevel.view.dto.request;

import java.sql.Time;
import java.util.Objects;

public class MovieRequestDto extends RequestDto {

    private String title;

    private String description;

    private Time duration;

    private String director;

    private int releaseYear;

    private String imageUrl;

    private String genre;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRequestDto that = (MovieRequestDto) o;
        return releaseYear == that.releaseYear && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(duration, that.duration) && Objects.equals(director, that.director) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, duration, director, releaseYear, imageUrl, genre);
    }
}
