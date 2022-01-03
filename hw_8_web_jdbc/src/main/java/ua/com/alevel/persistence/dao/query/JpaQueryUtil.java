package ua.com.alevel.persistence.dao.query;

public final class JpaQueryUtil {

    private JpaQueryUtil() {
    }


    public static final String CREATE_STUDENT_QUERY = "INSERT INTO students VALUES (default,?,?,?,?,?);";
    public static final String FIND_ALL_STUDENT_QUERY = "SELECT * FROM students;";

}
