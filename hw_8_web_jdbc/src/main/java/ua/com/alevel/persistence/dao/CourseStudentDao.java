package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.entity.CourseStudent;

public interface CourseStudentDao extends BaseDao<CourseStudent> {

    void deleteByStudentId(long id);
}
