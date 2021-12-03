package ua.com.alevel.thirdlevel;

public class City {

    int id;
    String name;
    int[][] pathToNeighbours;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getPathToNeighbours() {
        return pathToNeighbours;
    }

    public void setPathToNeighbours(int[][] pathToNeighbours) {
        this.pathToNeighbours = pathToNeighbours;
    }
}
