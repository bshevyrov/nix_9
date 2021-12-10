package ua.com.alevel.entity;

public class Hall extends BaseEntity {

    private String name;
    private int numOfSeats;
//    private Movie movie;

    public Hall() {
        super();
    }

   /* public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }*/

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
