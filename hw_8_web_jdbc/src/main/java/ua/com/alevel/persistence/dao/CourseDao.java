package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;

public interface CourseDao extends BaseDao<Course> {

    DataTableResponse<Course> findAllByStudentId(Long id);
}
