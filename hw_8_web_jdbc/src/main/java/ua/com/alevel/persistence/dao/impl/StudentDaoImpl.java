package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.persistence.dao.query.JpaQueryUtil.*;

@Service
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
        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_STUDENTS_QUERY)) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setBirthDate(resultSet.getDate("birth_date"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreateDate(resultSet.getDate("create_date"));
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

    @Override
    public DataTableResponse<Student> findAllByCourseId(Long id) {
        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> list = new ArrayList<>();
        long size = 0L;
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_ALL_STUDENTS_BY_COURSE_ID);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_date"));
               list.add(student);
                size++;
            }
            response.seteList(list);
            response.seteListSize(size);
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return response;
    }

    @Override
    public DataTableResponse<Student> findAllByCourseType(CourseType type) {
        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> list = new ArrayList<>();
        long size = 0L;
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_ALL_STUDENTS_BY_COURSE_TYPE);
        ) {
            preparedStatement.setString(1, type.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthDate(resultSet.getDate("birth_date"));
                list.add(student);
                size++;
            }
            response.seteList(list);
            response.seteListSize(size);
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return response;
    }
}
