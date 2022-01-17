package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;

import java.util.List;

public interface CourseService extends BaseService<Course>{

    DataTableResponse<Course> findAllByStudentId(Long id);
}
