package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

public interface StudentDao extends BaseDao<Student> {


    DataTableResponse<Student> findAllByCourseId(Long id);
    DataTableResponse<Student> findAllByCourseType(CourseType type);
}
