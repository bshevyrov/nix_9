package ua.com.alevel.persistence.dao.query;

public final class JpaQueryUtil {

    private JpaQueryUtil() {
    }


    public static final String CREATE_STUDENT_QUERY = "INSERT INTO students VALUES (default,?,?,?,?,?);";
    public static final String FIND_ALL_STUDENT_QUERY = "SELECT * FROM students;";
    public static final String FIND_ALL_COURSES_BY_STUDENT_ID = "SELECT  * FROM courses AS c JOIN course_student AS cs on c.id = cs.course_id JOIN students s on cs.student_id = ?;";
}