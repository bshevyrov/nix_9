package ua.com.alevel.veiw.dto.response;

import ua.com.alevel.persistence.type.CourseType;

import java.sql.Date;

public class CourseResponseDto extends ResponseDto{

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
}
