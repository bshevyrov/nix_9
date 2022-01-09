package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.CourseType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(description, course.description) && courseType == course.courseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, courseType);
    }
}
