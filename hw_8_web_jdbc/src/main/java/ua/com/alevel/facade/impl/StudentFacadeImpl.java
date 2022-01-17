package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CourseStudent;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.CourseStudentService;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.veiw.dto.request.PageAndSizeData;
import ua.com.alevel.veiw.dto.request.SortData;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    private final CourseService courseService;
    private final CourseStudentService courseStudentService;

    public StudentFacadeImpl(StudentService studentService, CourseService courseService, CourseStudentService courseStudentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.courseStudentService = courseStudentService;
    }


    @Override
    public void create(StudentRequestDto studentRequestDto) {
//        Student student = new Student(studentRequestDto);
        studentService.create(ClassConverterUtil
                .studentRequestDtoToStudent(studentRequestDto));
//        CourseStudent courseStudent = new CourseStudent();
 /*       Student currentStudent = studentService.findByEmail(student.getEmail());
        courseStudent.setStudentId(currentStudent.getId());
        courseStudentService.create(courseStudent);*/
    }

    @Override
    public void update(StudentRequestDto studentRequestDto) {
        studentService.update(ClassConverterUtil
                .studentRequestDtoToStudent(studentRequestDto));
    }

    @Override
    public void delete(long id) {
        studentService.delete(id);
    }

    @Override
    public StudentResponseDto findById(long id) {
        return new StudentResponseDto(studentService.findById(id));
    }

    @Override
    public List<StudentResponseDto> findAll() {
        DataTableResponse<Student> studentDataTableResponse = studentService.findAll(new DataTableRequest());
        return studentDataTableResponse
                .geteList()
                .stream()
                .map(StudentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<StudentResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Student> all = studentService.findAll(dataTableRequest);
        List<StudentResponseDto> list = all.geteList()
                .stream()
                .map(StudentResponseDto::new)
                .collect(Collectors.toList());
        PageDataResponse<StudentResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.geteListSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

    @Override
    public PageDataResponse<StudentResponseDto> findAllByCourseId(Long id, WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Student> all = studentService.findAllByCourseId(id, dataTableRequest);
        List<StudentResponseDto> list = all.geteList()
                .stream()
                .map(StudentResponseDto::new)
                .collect(Collectors.toList());
        PageDataResponse<StudentResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.geteListSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
//        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseId(id,request);
//        return dataTableResponse.geteList().stream().map(StudentResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDto> findAllByCourseType(CourseType type) {
        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseType(type);
        return dataTableResponse.geteList().stream().map(StudentResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public StudentResponseDto findByEmail(String email) {
        return new StudentResponseDto(studentService.findByEmail(email));
    }


}

