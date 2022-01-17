package ua.com.alevel.util;

public final class JpaQueryUtil {

    private JpaQueryUtil() {
    }

    public static final String DELETE_STUDENT_IF_NO_COURSE ="DELETE s FROM students s LEFT JOIN course_student cs ON s.id=cs.student_id WHERE cs.course_id IS NULL;";
    public static final String CREATE_COURSE_QUERY = "INSERT INTO courses VALUES (default,?,?,?,?);";;
    public static final String UPDATE_COURSE_QUERY = "UPDATE  courses SET description = ?, course_type = ?,name = ? WHERE id = ?;";
    public static final String DELETE_COURSE_BY_ID ="DELETE FROM courses WHERE id=?;" ;
    public static final String COUNT_STUDENT_QUERY = "SELECT COUNT(*) as count FROM students";
    public static final String COUNT_FIND_ALL_STUDENTS_BY_COURSE_ID = "SELECT COUNT(*) as count FROM students s  JOIN course_student cs on s.id = cs.student_id  JOIN courses  c ON cs.course_id = c.id WHERE c.id=?;";
    public static final String CREATE_STUDENT_QUERY = "INSERT INTO students VALUES (default,?,?,?,?,?,?);";
    public static final String UPDATE_STUDENT_QUERY = "UPDATE  students SET first_name = ?, last_name = ?, birth_date = ?, email = ?, phone = ? WHERE id=?;";
    public static final String CREATE_COURSE_STUDENT_QUERY = "INSERT INTO course_student VALUES (?,?);";
    public static final String FIND_STUDENT_BY_EMAIL = "SELECT * FROM students WHERE email=?;";
    public static final String FIND_COURSE_BY_ID = "SELECT * FROM courses WHERE id=?;";
    public static final String FIND_STUDENT_BY_ID ="SELECT * FROM students WHERE id=?;";
    public static final String DELETE_STUDENT_BY_ID = "DELETE FROM students WHERE id=?;";
    public static final String DELETE_COURSES_STUDENT_BY_STUDENT_ID_QUERY= "DELETE FROM course_student WHERE student_id=?;";
    public static final String FIND_ALL_FROM_TO_SORTED_BY_COLUMN_QUERY = "SELECT * FROM %s ORDER BY %s %s LIMIT ?,?;";
    public static final String FIND_ALL_STUDENTS_BY_COURSE_ID = "SELECT  s.* FROM students s  JOIN course_student cs on s.id = cs.student_id  JOIN courses  c ON cs.course_id = c.id WHERE c.id=? ORDER BY %s %s LIMIT ?,?;";
    public static final String FIND_ALL_STUDENTS_BY_COURSE_TYPE = "SELECT  s.* FROM students s  JOIN course_student cs on s.id = cs.student_id  JOIN courses  c ON cs.course_id = c.id WHERE c.course_type =?;";
    public static final String FIND_ALL_COURSES_BY_STUDENT_ID = "SELECT  c.* FROM courses c  JOIN course_student cs on c.id = cs.course_id  JOIN students  s ON cs.student_id = s.id WHERE s.id=?;";
    public static final String FIND_ALL_COURSE_FROM_TO_SORTED_BY_COLUMN_QUERY = "SELECT * FROM courses ORDER BY %s %s LIMIT ?,?;";
    public static final String FIND_ALL_STUDENTS_QUERY = "SELECT * FROM students;";
    public static final String FIND_ALL_COURSES_QUERY = "SELECT * FROM courses;";
    public static final String COUNT_STUDENTS = "SELECT COUNT(*) FROM students;";
}