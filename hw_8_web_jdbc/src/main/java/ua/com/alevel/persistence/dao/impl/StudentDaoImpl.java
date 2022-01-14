package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.util.JpaQueryUtil.*;

@Service
public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    private final JpaConfig jpaConfig;


    @Override
    public void create(Student student) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_STUDENT_QUERY)) {
            preparedStatement.setDate(1, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setDate(4, (Date) student.getBirthDate());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhone());
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
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_STUDENT_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_COURSES_STUDENT_BY_STUDENT_ID_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean existById(long id) {
        return false;
    }

    @Override
    public Student findById(long id) {
        Student student = new Student();
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_STUDENT_BY_ID);
        ) {
            preparedStatement.setLong(1, (id));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            student = new Student(resultSet);
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return student;
    }

    @Override
    public long count() {
        int count = 0;
        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(COUNT_STUDENT_QUERY)) {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public DataTableResponse<Student> findAll(DataTableRequest request) {
        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> list = new ArrayList<>();
        long size = 0L;
        String sql = String.format(FIND_ALL_FROM_TO_SORTED_BY_COLUMN_QUERY, "students", request.getSort(), request.getOrder());
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, (request.getCurrentPage() - 1) * request.getPageSize());
            preparedStatement.setLong(2, request.getPageSize());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Student(resultSet));
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
    public DataTableResponse<Student> findAllByCourseId(Long id, DataTableRequest request) {
        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> list = new ArrayList<>();
        long size = 0L;
        String sql = String.format(FIND_ALL_STUDENTS_BY_COURSE_ID, request.getSort(), request.getOrder());
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, (id));
            preparedStatement.setLong(2, (request.getCurrentPage() - 1) * request.getPageSize());
            preparedStatement.setLong(3, request.getPageSize());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Student(resultSet));
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

    @Override
    public Student findByEmail(String email) {
        Student student = new Student();
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_STUDENT_BY_EMAIL);
        ) {
            preparedStatement.setString(1, (email));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            student = new Student(resultSet);
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return student;
    }

    @Override
    public long countFindAllByCourseId(Long id) {
        int size = 0;
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(COUNT_FIND_ALL_STUDENTS_BY_COURSE_ID);
        ) {
            preparedStatement.setLong(1, (id));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            size = resultSet.getInt("count");
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return size;
    }
}
