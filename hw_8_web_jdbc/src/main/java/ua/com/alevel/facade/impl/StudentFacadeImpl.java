package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.service.StudentService;
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
        studentService.delete(id);
    }

    @Override
    public StudentResponseDto findById(long id) {
        return null;
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

//    @Override
//    public PageDataResponse<StudentResponseDto> findAllSortedByFieldOrderedBy(PageDataRequest request) {
//        DataTableRequest dataTableRequest = new DataTableRequest();
//        dataTableRequest.setOrder(request.getOrder());
//        dataTableRequest.setSort(request.getSort());
//        dataTableRequest.setCurrentPage(request.getCurrentPage());
//        dataTableRequest.setPageSize(request.getPageSize());
//        dataTableRequest.setTotalPages(request.getTotalPageSize());
//        DataTableResponse<Student> dataTableResponse = studentService.findAllSortedByFieldOrderedBy(dataTableRequest);
//
//        PageDataResponse<StudentResponseDto> response = new PageDataResponse<>();
//        response.setItems(dataTableResponse.geteList().stream().map(StudentResponseDto::new).collect(Collectors.toList()));
//        response.setItemSize(dataTableResponse.geteListSize());
//        response.setOrder(request.getOrder());
//        response.setSort(request.getSort());
//        response.setCurrentPage(request.getCurrentPage());
//        response.setTotalPageSize((int) dataTableResponse.getTotalPage());
//        return response;
//    }


    @Override
    public List<StudentResponseDto> findAllByCourseId(Long id) {
        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseId(id);
        return dataTableResponse.geteList().stream().map(StudentResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDto> findAllByCourseType(CourseType type) {
        DataTableResponse<Student> dataTableResponse = studentService.findAllByCourseType(type);
        return dataTableResponse.geteList().stream().map(StudentResponseDto::new).collect(Collectors.toList());
    }


}

