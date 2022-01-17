package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;

public interface CourseService extends BaseService<Course>{

    DataTableResponse<Course> findAllByStudentId(Long id);
}
