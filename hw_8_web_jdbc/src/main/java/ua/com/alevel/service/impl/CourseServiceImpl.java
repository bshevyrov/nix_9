package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public void create(BaseEntity baseEntity) {

    }

    @Override
    public void update(BaseEntity baseEntity) {

    }

    @Override
    public void delete(long id) {

    }


    @Override
    public BaseEntity findById(long id) {
        return null;
    }

    @Override
    public DataTableResponse<Course> findAll(DataTableRequest request) {
        return null;
    }

}
