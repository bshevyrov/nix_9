package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CourseStudentFacade;
import ua.com.alevel.persistence.entity.CourseStudent;
import ua.com.alevel.service.CourseStudentService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.veiw.dto.request.CourseStudentRequestDto;
import ua.com.alevel.veiw.dto.response.CourseStudentResponseDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;

import java.util.List;

@Service
public class CourseStudentFacadeImpl implements CourseStudentFacade {

    private final CourseStudentService courseStudentService;

    public CourseStudentFacadeImpl(CourseStudentService courseStudentService) {
        this.courseStudentService = courseStudentService;
    }

    @Override
    public void create(CourseStudentRequestDto courseStudentRequestDto) {
        courseStudentService.create(ClassConverterUtil.courseStudentRequestDtoToCourseStudent(courseStudentRequestDto));
    }

    @Override
    public void update(CourseStudentRequestDto courseStudentRequestDto) {
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public CourseStudentResponseDto findById(long id) {
        return null;
    }

    @Override
    public List<CourseStudentResponseDto> findAll() {
        return null;
    }

    @Override
    public PageDataResponse<CourseStudentResponseDto> findAll(WebRequest request) {
        return null;
    }

    @Override
    public void deleteByStudentId(long id) {
    courseStudentService.deleteByStudentId(id);
    }
}
