package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
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
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

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
        List<StudentResponseDto> list = new ArrayList<>();
        List<Student> students = studentDataTableResponse.geteList();
        StudentResponseDto responseDto = new StudentResponseDto();
//stream
        for (int i = 0; i < students.size(); i++) {
            responseDto.setId(students.get(i).getId());
            responseDto.setFirstName(students.get(i).getFirstName());
            responseDto.setLastName(students.get(i).getLastName());
            responseDto.setEmail(students.get(i).getEmail());
            responseDto.setPhone(students.get(i).getPhone());
            responseDto.setBirthDate((Date) students.get(i).getBirthDate());

            DataTableResponse<Course> student = courseService.findAllByStudentId( students.get(i).getId());
            List<Course> list1 = student.geteList();


            responseDto.setCourseResponseDtoSet(convertToDtoByEntity(
                   list1 ));
            list.add(responseDto);
        }
        return list;
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
    }

