package ua.com.alevel.dao.query;

public final class JpaQueryUtil {

    private JpaQueryUtil(){}

    public static final String CREATE_HALL_QUERY="INSERT INTO halls VALUES(default,?,?)";
    public static final String UPDATE_HALL_QUERY="INSERT INTO halls VALUES(default,?,?)";
    public static final String DELETE_HALL_BY_ID_QUERY="DELETE FROM halls WHERE id = ";
    public static final String FIND_BY_ID_QUERY="INSERT INTO halls VALUES(default,?,?)";
    public static final String FIND_ALL_HALL_QUERY="SELECT * FROM halls";
}
