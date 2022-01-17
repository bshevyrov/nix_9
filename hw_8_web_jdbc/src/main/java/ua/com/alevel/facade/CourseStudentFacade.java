package ua.com.alevel.facade;

import ua.com.alevel.veiw.dto.request.CourseStudentRequestDto;
import ua.com.alevel.veiw.dto.response.CourseStudentResponseDto;

public interface CourseStudentFacade extends BaseFacade<CourseStudentRequestDto, CourseStudentResponseDto>{
    void deleteByStudentId(long id);
}
