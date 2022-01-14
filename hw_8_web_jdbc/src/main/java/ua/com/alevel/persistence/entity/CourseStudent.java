package ua.com.alevel.persistence.entity;


import ua.com.alevel.veiw.dto.request.CourseStudentRequestDto;

public class CourseStudent extends BaseEntity{

    private long courseId;
    private long studentId;

    public CourseStudent() {

    }

    public CourseStudent(CourseStudentRequestDto courseStudentRequestDto) {
        this.courseId = courseStudentRequestDto.getCourseId();
    this.studentId = courseStudentRequestDto.getStudentId();
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
