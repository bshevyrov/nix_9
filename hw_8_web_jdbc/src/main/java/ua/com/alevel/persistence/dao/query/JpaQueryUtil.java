package ua.com.alevel.persistence.dao.query;

public final class JpaQueryUtil {

    private JpaQueryUtil() {
    }


    public static final String CREATE_STUDENT_QUERY = "INSERT INTO students VALUES (default,?,?,?,?,?);";
    public static final String FIND_ALL_STUDENTS_QUERY = "SELECT * FROM students;";
    public static final String FIND_ALL_COURSES_QUERY = "SELECT * FROM courses;";
    public static final String FIND_ALL_STUDENT_FROM_TO_SORTED_BY_COLUMN_QUERY = "SELECT * FROM students ORDERED BY ? ? OFFSET ? FETCH FIRST ? ROWS ONLY;";
// "SELECT * FROM students ORDERED BY *COLUMN NAME* *ASC/DESC* OFFSET *HOW MANY SKIPS* FETCH FIRST *HOW MANY SHOW* ROWS ONLY;";
    public static final String FIND_ALL_COURSES_BY_STUDENT_ID = "SELECT  c.* FROM courses c  JOIN course_student cs on c.id = cs.course_id  JOIN students  s ON cs.student_id = s.id WHERE s.id=?;";
}