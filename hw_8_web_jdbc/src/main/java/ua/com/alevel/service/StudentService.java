package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

public interface StudentService extends BaseService<Student>{

    DataTableResponse<Student> findAllByCourseId(Long id);
    DataTableResponse<Student> findAllByCourseType(CourseType type);
}
