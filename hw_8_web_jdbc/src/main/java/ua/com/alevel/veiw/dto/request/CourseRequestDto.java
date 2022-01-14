package ua.com.alevel.veiw.dto.request;

import ua.com.alevel.persistence.type.CourseType;

public class CourseRequestDto extends RequestDto{

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

    public void setCourseType(String courseType) {
        this.courseType = CourseType.valueOf(courseType);
    }
}
