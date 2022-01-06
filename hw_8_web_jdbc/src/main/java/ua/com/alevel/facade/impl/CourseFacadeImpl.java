package ua.com.alevel.facade.impl;

import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    @Override
    public List<CourseResponseDto> findAllByStudentId(Long id) {
        DataTableResponse<Course> dataTableResponse = courseService.findAllByStudentId(id);
        List<CourseResponseDto> responseDtoList = new ArrayList<>();
        for (Course course : dataTableResponse.geteList()) {
            responseDtoList.add(convertCourseToCourseResponseDto(course));
        }
        return responseDtoList;


    }

    private CourseResponseDto convertCourseToCourseResponseDto(Course course) {
        CourseResponseDto responseDto = new CourseResponseDto();
        responseDto.setId(course.getId());
        responseDto.setName(course.getName());
        responseDto.setDescription(course.getDescription());
        responseDto.setCourseType(course.getCourseType());
        return responseDto;
    }


}
