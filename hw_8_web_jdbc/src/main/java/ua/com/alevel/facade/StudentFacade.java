package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentFacade extends BaseFacade<StudentRequestDto, StudentResponseDto> {

    PageDataResponse<StudentResponseDto> findAllByCourseId(Long id, WebRequest request);
    List<StudentResponseDto> findAllByCourseType(CourseType type);
    StudentResponseDto findByEmail(String email);

}
