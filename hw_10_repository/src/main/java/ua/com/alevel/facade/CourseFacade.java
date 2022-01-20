package ua.com.alevel.facade;

import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseFacade extends BaseFacade<CourseRequestDto, CourseResponseDto> {

    List<CourseResponseDto> findAllByStudentId(Long id);
}
