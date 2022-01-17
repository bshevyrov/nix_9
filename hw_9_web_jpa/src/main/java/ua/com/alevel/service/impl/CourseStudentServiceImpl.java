package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.dao.CourseStudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CourseStudent;
import ua.com.alevel.service.CourseStudentService;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    private final CourseStudentDao courseStudentDao;

    public CourseStudentServiceImpl(CourseStudentDao courseStudentDao) {
        this.courseStudentDao = courseStudentDao;
    }

    @Override
    public void create(CourseStudent courseStudent) {
        courseStudentDao.create(courseStudent);
    }

    @Override
    public void update(CourseStudent courseStudent) {
    }

    @Override
    public void delete(long id) {
    }

    @Override
    public CourseStudent findById(long id) {
        return null;
    }

    @Override
    public DataTableResponse<CourseStudent> findAll(DataTableRequest request) {
        return null;
    }

    @Override
    public void deleteByStudentId(long id) {
        courseStudentDao.deleteByStudentId(id);
    }
}
