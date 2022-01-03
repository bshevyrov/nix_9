package ua.com.alevel.persistence.dao.impl;

import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.persistence.dao.query.JpaQueryUtil.CREATE_STUDENT_QUERY;
import static ua.com.alevel.persistence.dao.query.JpaQueryUtil.FIND_ALL_STUDENT_QUERY;

public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    private final JpaConfig jpaConfig;


    @Override
    public void create(Student student) {

        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_STUDENT_QUERY)) {
            preparedStatement.setString(1, student.getPhone());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, (Date) student.getBirthDate());
            preparedStatement.setString(4, student.getLastName());
            preparedStatement.setString(5, student.getFirstName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

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
    public DataTableResponse<Student> findAll(DataTableRequest request) {

        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> studentList = new ArrayList<>();
        long size = 0L;

        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_STUDENT_QUERY)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setBirthDate(resultSet.getDate("birth_date"));
                student.setEmail(resultSet.getString("email"));
                student.setEmail(resultSet.getString("phone"));
                student.setId(resultSet.getLong("id"));
                studentList.add(student);
                ++size;

            }
            response.seteList(studentList);
            response.seteListSize(size);


        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return response;
    }

    @Override
    public long count() {
        return 0;
    }
}
