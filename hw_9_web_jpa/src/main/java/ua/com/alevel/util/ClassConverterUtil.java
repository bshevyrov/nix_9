package ua.com.alevel.util;

import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.request.CourseStudentRequestDto;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassConverterUtil {

    private ClassConverterUtil() {
    }

    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setCreateDate(studentRequestDto.getCreateDate());
        student.setId(studentRequestDto.getId());
        student.setEmail(studentRequestDto.getEmail());
        student.setBirthDate(studentRequestDto.getBirthDate());
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setPhone(studentRequestDto.getPhone());
        return student;
    }

    public static Student resultSetToStudent(ResultSet resultSet) {
        Student student = new Student();
        try {
            student.setId(resultSet.getLong("id"));
            student.setCreateDate(resultSet.getDate("create_date"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));
            student.setBirthDate(resultSet.getDate("birth_date"));
        } catch (SQLException e) {
            e.getMessage();
        }
        return student;
    }


    public static Course courseRequestDtoToCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setId(courseRequestDto.getId());
        course.setCreateDate(courseRequestDto.getCreateDate());
        course.setDescription(courseRequestDto.getDescription());
        course.setName(courseRequestDto.getName());
        course.setCourseType(courseRequestDto.getCourseType());
        return course;
    }

    public static Course resultSetToCourse(ResultSet resultSet) {
        Course course = new Course();
        try {
            course.setId(resultSet.getLong("id"));
            course.setCreateDate(resultSet.getDate("create_date"));
            course.setCourseType(CourseType.valueOf(resultSet.getString("course_type")));
            course.setName(resultSet.getString("name"));
            course.setDescription(resultSet.getString("description"));
        } catch (SQLException e) {
            e.getMessage();
        }
        return course;
    }



    public static CourseResponseDto courseToCourseResponseDto(Course course) {
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setCreateDate((Date) course.getCreateDate());
        courseResponseDto.setCourseType(course.getCourseType());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setDescription(course.getDescription());
        return courseResponseDto;
    }

    public static StudentResponseDto studentToStudentResponceDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setCreateDate((Date) student.getCreateDate());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setBirthDate((Date) student.getBirthDate());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setEmail(student.getEmail());
        return studentResponseDto;
    }
}
