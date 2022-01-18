package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.dao.CourseStudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CourseStudent;

@Service
public class CourseStudentDaoImpl implements CourseStudentDao {

    @Override
    public void create(CourseStudent courseStudent) {

    }

    @Override
    public void update(CourseStudent courseStudent) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean existById(long id) {
        return false;
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
    public long count() {
        return 0;
    }

    @Override
    public void deleteByStudentId(long id) {

    }
}
