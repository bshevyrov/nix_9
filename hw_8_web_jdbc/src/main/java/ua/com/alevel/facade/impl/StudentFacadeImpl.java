package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentFacadeImpl(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


    @Override
    public void create(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setEmail(studentRequestDto.getEmail());
        student.setBirthDate(studentRequestDto.getBirthDate());
        student.setFirstName(studentRequestDto.getFirstName());
        student.setLastName(studentRequestDto.getLastName());
        student.setPhone(studentRequestDto.getPhone());
        studentService.create(student);
    }

    @Override
    public void update(StudentRequestDto studentRequestDto, Long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public StudentResponseDto findById(long id) {
        return null;
    }

    @Override
    public List<StudentResponseDto> findAll() {
        DataTableResponse<Student> studentDataTableResponse = studentService.findAll(new DataTableRequest());
        return convertStudentsToStudentResponseDto(
                studentDataTableResponse.geteList());
    }

    private Set<CourseResponseDto> convertToDtoByEntity(List<Course> courses) {
        Set<CourseResponseDto> courseResponseDtoSet = new HashSet<>();
        for (Course cours : courses) {
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            courseResponseDto.setCourseType(cours.getCourseType());
            courseResponseDto.setName(cours.getName());
            courseResponseDto.setDescription(cours.getDescription());
            courseResponseDto.setId(cours.getId());
            courseResponseDto.setCreateDate((Date) cours.getCreateDate());
            courseResponseDtoSet.add(courseResponseDto);
        }
        return courseResponseDtoSet;
    }

    @Override
    public List<StudentResponseDto> findAllByCourseId(Long id) {
        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseId(id);
        return convertStudentsToStudentResponseDto(dataTableResponse.geteList());
    }

    @Override
    public List<StudentResponseDto> findAllByCourseType(CourseType type) {
        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseType(type);
        return convertStudentsToStudentResponseDto(dataTableResponse.geteList());
    }

    private List<StudentResponseDto> convertStudentsToStudentResponseDto(List<Student> students) {
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();

        for (Student student : students) {
            StudentResponseDto responseDto = new StudentResponseDto();
            responseDto.setId(student.getId());
            responseDto.setBirthDate((Date) student.getBirthDate());
            responseDto.setPhone(student.getPhone());
            responseDto.setEmail(student.getEmail());
            responseDto.setFirstName(student.getFirstName());
            responseDto.setLastName(student.getLastName());
            responseDto.setCreateDate((Date) student.getCreateDate());
            studentResponseDtoList.add(responseDto);


            DataTableResponse<Course> dataTableResponse = courseService.findAllByStudentId(student.getId());
            List<Course> list1 = dataTableResponse.geteList();
            responseDto.setCourseResponseDtoSet(convertToDtoByEntity(list1));
        }

        return studentResponseDtoList;
    }
}

