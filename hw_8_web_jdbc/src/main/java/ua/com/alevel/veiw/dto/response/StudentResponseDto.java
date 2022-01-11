package ua.com.alevel.veiw.dto.response;

import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class StudentResponseDto extends ResponseDto {


    private String email;
    private String phone;
    private Date birthDate;
    private String firstName;
    private String lastName;


    public StudentResponseDto(Student student) {
        super(student.getId(), (Date) student.getCreateDate());
        setFirstName(student.getFirstName());
        setLastName(student.getLastName());
        setBirthDate((Date) student.getBirthDate());
        setPhone(student.getPhone());
        setEmail(student.getEmail());
    }

/*
    public Set<CourseType> getUniqTypes() {
        Set<CourseType> types = new HashSet<CourseType>();
        for (CourseResponseDto courseResponseDto : getCourseResponseDtoSet()) {
            types.add(courseResponseDto.getCourseType());
        }
        return types;
    }

*/

//    public Set<CourseResponseDto> getCourseResponseDtoSet() {
//        return courseResponseDtoSet;
//    }
//
//    public void setCourseResponseDtoSet(Set<CourseResponseDto> courseResponseDtoSet) {
//        this.courseResponseDtoSet = courseResponseDtoSet;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
