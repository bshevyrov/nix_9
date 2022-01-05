package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;

    public StudentFacadeImpl(StudentService studentService) {
        this.studentService = studentService;
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
        for (int i = 0; i <students.size() ; i++) {
            responseDto.setId(students.get(i).getId());
            responseDto.setFirstName(students.get(i).getFirstName());
            responseDto.setLastName(students.get(i).getLastName());
            responseDto.setEmail(students.get(i).getEmail());
            responseDto.setPhone(students.get(i).getPhone());
            responseDto.setBirthDate((Date) students.get(i).getBirthDate());
            list.add(responseDto);
        }
        return list ;
    }
}
