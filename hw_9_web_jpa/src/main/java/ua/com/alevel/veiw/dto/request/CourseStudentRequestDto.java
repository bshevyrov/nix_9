package ua.com.alevel.veiw.dto.request;

public class CourseStudentRequestDto extends RequestDto {

    private long courseId;
    private long studentId;

    public CourseStudentRequestDto() {
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
