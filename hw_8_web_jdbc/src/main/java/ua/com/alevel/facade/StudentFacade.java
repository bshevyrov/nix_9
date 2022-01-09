package ua.com.alevel.facade;

import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentFacade extends BaseFacade<StudentRequestDto, StudentResponseDto> {

    List<StudentResponseDto> findAllByCourseId(Long id);
    List<StudentResponseDto> findAllByCourseType(CourseType type);
}
