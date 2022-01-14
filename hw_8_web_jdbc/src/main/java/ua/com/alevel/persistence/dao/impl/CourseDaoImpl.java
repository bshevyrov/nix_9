package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.CourseDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.type.CourseType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ua.com.alevel.util.JpaQueryUtil.*;

@Service
public class CourseDaoImpl implements CourseDao {


    private final JpaConfig jpaConfig;

    public CourseDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    @Override
    public void create(Course course) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_COURSE_QUERY)) {
            preparedStatement.setDate(1, (java.sql.Date) course.getCreateDate());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.setString(4, course.getCourseType().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(long id) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_COURSE_BY_ID)) {
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
    public Course findById(long id) {
        Course course = new Course();
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_COURSE_BY_ID);) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                course = new Course(resultSet);
            }

        } catch (SQLException throwables) {
            throwables.getMessage();
        }

        return course;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public DataTableResponse<Course> findAll(DataTableRequest request) {
        DataTableResponse<Course> response = new DataTableResponse<>();
        List<Course> list = new ArrayList<>();
        long size = 0L;
        String sql = String.format(FIND_ALL_FROM_TO_SORTED_BY_COLUMN_QUERY, "courses", request.getSort(), request.getOrder());
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(sql);
        ) {
            // "SELECT * FROM students ORDERED BY *COLUMN NAME* *ASC/DESC* OFFSET *HOW MANY SKIPS* FETCH FIRST *HOW MANY SHOW* ROWS ONLY;";

//            preparedStatement.setString(1, request.getOrder());
            preparedStatement.setLong(1, (request.getCurrentPage() - 1) * request.getPageSize());
            preparedStatement.setLong(2, request.getPageSize());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Course(resultSet));
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
    public DataTableResponse<Course> findAllByStudentId(Long id) {
        DataTableResponse<Course> response = new DataTableResponse<>();
        List<Course> list = new ArrayList<>();
        long size = 0L;
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(FIND_ALL_COURSES_BY_STUDENT_ID);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getLong("c.id"));
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setCourseType(CourseType.valueOf(resultSet.getString("course_type")));
                course.setCreateDate(resultSet.getDate("create_date"));
                list.add(course);
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

