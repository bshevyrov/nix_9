package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.repository.CourseRepository;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.service.CourseService;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private  CourseRepository courseRepository;


    @Override
    public void create(Course course) {
    courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);

    }

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(long id) {

        return  courseRepository.findById(id);
    }

    @Override
    public DataTableResponse<Course> findAll(DataTableRequest request) {
        DataTableResponse<Course> response = new DataTableResponse<>();
        response.seteList(courseRepository.findAllS());
        return response;
    }

    @Override
    public DataTableResponse<Course> findAllByStudentId(Long id) {
        return null;
    }
}
