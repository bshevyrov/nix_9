package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.service.CourseService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.request.PageAndSizeData;
import ua.com.alevel.veiw.dto.request.SortData;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFacadeImpl implements CourseFacade {

    private final CourseService courseService;

    public CourseFacadeImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void create(CourseRequestDto courseRequestDto) {
        courseService.create(ClassConverterUtil
                .courseRequestDtoToCourse(courseRequestDto));
    }

    @Override
    public void update(CourseRequestDto courseRequestDto) {
        courseService.update(ClassConverterUtil
                .courseRequestDtoToCourse(courseRequestDto));
    }

    @Override
    public void delete(long id) {
        courseService.delete(id);
    }

    @Override
    public CourseResponseDto findById(long id) {
        return ClassConverterUtil.courseToCourseResponseDto(courseService.findById(id));
    }

    @Override
    public List<CourseResponseDto> findAll() {
        PageAndSizeData pageAndSizeData = WebRequestUtil.defaultPageAndSizeData();
        SortData sortData = WebRequestUtil.defaultSortData();
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);

        return courseService.findAll(dataTableRequest)
                .geteList()
                .stream()
                .map(ClassConverterUtil::courseToCourseResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<CourseResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Course> all = courseService.findAll(dataTableRequest);
        List<CourseResponseDto> list = all.geteList().stream().map(ClassConverterUtil::courseToCourseResponseDto).collect(Collectors.toList());
        PageDataResponse<CourseResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.geteListSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

    @Override
    public List<CourseResponseDto> findAllByStudentId(Long id) {
        DataTableResponse<Course> dataTableResponse = courseService.findAllByStudentId(id);
        return dataTableResponse.geteList().stream().map(ClassConverterUtil::courseToCourseResponseDto).collect(Collectors.toList());
    }
}
