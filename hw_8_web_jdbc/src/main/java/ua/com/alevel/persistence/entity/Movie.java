package ua.com.alevel.persistence.entity;

public class Movie extends BaseEntity {

    private String name;
    private String description;
//    private Hall hall;

    public Movie() {
        super();
    }

//    public Hall getHall() {
//        return hall;
//    }

//    public void setHall(Hall hall) {
//        this.hall = hall;
//    }

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
}
