package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CourseStudent;
import ua.com.alevel.persistence.repository.CourseStudentRepository;
import ua.com.alevel.service.CourseStudentService;

import java.util.Optional;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    private CourseStudentRepository courseStudentRepository;

    @Override
    public void create(CourseStudent courseStudent) {
        courseStudentRepository.save(courseStudent);
    }

    @Override
    public void update(CourseStudent courseStudent) {
        courseStudentRepository.save(courseStudent);
    }

    @Override
    public void delete(long id) {
        courseStudentRepository.deleteById(id);
    }

    @Override
    public Optional<CourseStudent> findById(long id) {
        return courseStudentRepository.findById(id);
    }

    @Override
    public DataTableResponse<CourseStudent> findAll(DataTableRequest request) {
        return null;
    }
}
