package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

public interface StudentDao extends BaseDao<Student> {

    DataTableResponse<Student> findAllByCourseId(Long id, DataTableRequest dataTableRequest);

    DataTableResponse<Student> findAllByCourseType(CourseType type);

    Student findByEmail(String email);

    long countFindAllByCourseId(Long id);

    void createCourseStudent(long courseId, long studentId);

    void deleteCourseStudent(long courseId, long studentId) ;

    }
