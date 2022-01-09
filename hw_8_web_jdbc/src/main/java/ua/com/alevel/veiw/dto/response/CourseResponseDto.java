package ua.com.alevel.veiw.dto.response;

import ua.com.alevel.persistence.type.CourseType;

import java.util.Objects;

public class CourseResponseDto extends ResponseDto {

    private String name;
    private String description;
    private CourseType courseType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseResponseDto that = (CourseResponseDto) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && courseType == that.courseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, courseType);
    }
}
