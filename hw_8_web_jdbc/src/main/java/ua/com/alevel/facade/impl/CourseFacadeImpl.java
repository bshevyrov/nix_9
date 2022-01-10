package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.request.PageDataRequest;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseFacadeImpl implements CourseFacade {

    private final CourseService courseService;

    public CourseFacadeImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void create(CourseRequestDto courseRequestDto) {

    }

    @Override
    public void update(CourseRequestDto courseRequestDto, Long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public CourseResponseDto findById(long id) {
        return null;
    }

    @Override
    public List<CourseResponseDto> findAll() {
        return convertCourseToCourseResponseDto(courseService.findAll(new DataTableRequest()).geteList());    }

    @Override
    public PageDataResponse<CourseResponseDto> findAllSortedByFieldOrderedBy(PageDataRequest request) {
        DataTableRequest dataTableRequest = new DataTableRequest();
        dataTableRequest.setOrder(request.getOrder());
        dataTableRequest.setSort(request.getSort());
        dataTableRequest.setCurrentPage(request.getCurrentPage());
        dataTableRequest.setPageSize(request.getPageSize());
        DataTableResponse<Course> dataTableResponse = courseService.findAllSortedByFieldOrderedBy(dataTableRequest);

        PageDataResponse<CourseResponseDto> response = new PageDataResponse<>();
        response.setItems(convertCourseToCourseResponseDto(dataTableResponse.geteList()));
        response.setItemSize(dataTableResponse.geteListSize());
        response.setOrder(request.getOrder());
        response.setSort(request.getSort());
        response.setCurrentPage(request.getCurrentPage());

        return response;    }

    @Override
    public List<CourseResponseDto> findAllByStudentId(Long id) {
        DataTableResponse<Course> dataTableResponse = courseService.findAllByStudentId(id);
        return convertCourseToCourseResponseDto(dataTableResponse.geteList());


    }

    private List<CourseResponseDto> convertCourseToCourseResponseDto(List<Course> course) {
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();

        for (Course course1 : course) {
            CourseResponseDto responseDto = new CourseResponseDto();
            responseDto.setId(course1.getId());
            responseDto.setName(course1.getName());
            responseDto.setDescription(course1.getDescription());
            responseDto.setCourseType(course1.getCourseType());
            courseResponseDtoList.add(responseDto);
        }

        return courseResponseDtoList;
    }


}
