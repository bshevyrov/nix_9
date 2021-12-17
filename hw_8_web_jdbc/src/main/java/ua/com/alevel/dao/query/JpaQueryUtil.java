package ua.com.alevel.dao.query;

public final class JpaQueryUtil {

    private JpaQueryUtil(){}

    public static final String CREATE_HALL_QUERY="INSERT INTO halls VALUES(default,?,?)";
    public static final String UPDATE_HALL_QUERY="UPDATE halls SET name = ?, num_of_seat = ? WHERE id = ?";
    public static final String DELETE_HALL_BY_ID_QUERY="DELETE FROM halls WHERE id = ";
    public static final String FIND_HALL_BY_ID_QUERY="SELECT * FROM halls WHERE id = ";
    public static final String FIND_ALL_HALL_QUERY="SELECT * FROM halls";
    public static final String EXIST_HALL_BY_ID_QUERY="SELECT COUNT(*) FROM halls WHERE id = ";

    public static final String CREATE_MOVIE_QUERY="INSERT INTO movies VALUES(default,?,?,?)";
    public static final String UPDATE_MOVIE_QUERY="UPDATE movies SET name = ?, description = ?, hall_id = ? WHERE id = ";
    public static final String DELETE_MOVIE_BY_ID_QUERY="DELETE FROM movies WHERE id = ";
    public static final String DELETE_MOVIE_BY_HALL_ID_QUERY="DELETE FROM movies WHERE hall_id = ";
    public static final String FIND_MOVIE_BY_ID_QUERY="SELECT * FROM  movies  AS m JOIN halls AS h ON m.hall_id = h.id WHERE m.id = ";
    public static final String FIND_ALL_MOVIE_QUERY="SELECT * FROM  movies AS m JOIN halls AS h ON  m.hall_id = h.id";
    public static final String FIND_ALL_MOVIE_BY_HALL_ID_QUERY="SELECT * FROM  movies AS m JOIN halls AS h ON  m.hall_id = h.id WHERE m.hall_id = ";
    public static final String EXIST_MOVIE_BY_ID_QUERY="SELECT COUNT(*) FROM movies WHERE id = ";
}
