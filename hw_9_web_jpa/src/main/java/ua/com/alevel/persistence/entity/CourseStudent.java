package ua.com.alevel.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course_student")
public class CourseStudent  {

    @Column(name = "course_id")
    private long courseId;

    @Column(name = "student_id")
    private long studentId;

    public CourseStudent() {
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
