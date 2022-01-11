package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.persistence.dao.CourseDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.type.CourseType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean existById(long id) {
        return false;
    }

    @Override
    public Course findById(long id) {
        return null;
    }

   /* @Override
    public DataTableResponse<Course> findAll(String tableName, DataTableRequest request) {

        DataTableResponse<Course> response = new DataTableResponse<>();
        List<Course> courseList = new ArrayList<>();
        long size = 0L;
        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_COURSES_QUERY)) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getLong("id"));
                course.setCreateDate(resultSet.getDate("create_date"));
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setCourseType(CourseType.valueOf(resultSet.getString("course_type")));
                courseList.add(course);
                ++size;
            }
            response.seteList(courseList);
            response.seteListSize(size);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return response;
    }*/

    @Override
    public long count() {
        return 0;
    }

    @Override
    public DataTableResponse<Course> findAll( DataTableRequest request) {
        DataTableResponse<Course> response = new DataTableResponse<>();
        List<Course> list = new ArrayList<>();
        long size = 0L;
        String sql= String.format(FIND_ALL_FROM_TO_SORTED_BY_COLUMN_QUERY,"courses",request.getSort(),request.getOrder());
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
        return response;    }


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

