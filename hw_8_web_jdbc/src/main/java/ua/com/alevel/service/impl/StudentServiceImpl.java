package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(long id) {
        studentDao.delete(id);
    }


    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public DataTableResponse<Student> findAll(DataTableRequest request) {
        return studentDao.findAll(request);
    }

    @Override
    public DataTableResponse<Student> findAllSortedByFieldOrderedBy(DataTableRequest request) {
        return studentDao.findAllSortedByFieldOrderedBy(request);
    }


    @Override
    public DataTableResponse<Student> findAllByCourseId(Long id) {
        return studentDao.findAllByCourseId(id);
    }

    @Override
    public DataTableResponse<Student> findAllByCourseType(CourseType type) {
        return studentDao.findAllByCourseType(type);
    }
}
