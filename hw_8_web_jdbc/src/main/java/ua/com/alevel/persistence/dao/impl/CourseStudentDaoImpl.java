package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.CourseStudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CourseStudent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static ua.com.alevel.util.JpaQueryUtil.CREATE_COURSE_STUDENT_QUERY;

@Service
public class CourseStudentDaoImpl implements CourseStudentDao {

    private final JpaConfig jpaConfig;

    public CourseStudentDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    @Override
    public void create(CourseStudent courseStudent) {
        System.out.println("c" + courseStudent.getCourseId() + "s" + courseStudent.getStudentId());
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_COURSE_STUDENT_QUERY)) {
            preparedStatement.setLong(1, courseStudent.getCourseId());
            preparedStatement.setLong(2, courseStudent.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

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
}
