package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.CourseType;

public class Course extends BaseEntity{

    private String name;
    private String description;
    private CourseType courseType;

    public Course() {
        super();
    }

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
