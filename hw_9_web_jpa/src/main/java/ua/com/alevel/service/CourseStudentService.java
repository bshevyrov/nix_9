package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.CourseStudent;

public interface CourseStudentService extends BaseService<CourseStudent> {

    void deleteByStudentId(long id);
}
