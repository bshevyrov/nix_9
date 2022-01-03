package ua.com.alevel.persistence.dao.impl;

import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void create(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean existById(long id) {
        return false;
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public DataTableResponse findAll(DataTableRequest request) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
