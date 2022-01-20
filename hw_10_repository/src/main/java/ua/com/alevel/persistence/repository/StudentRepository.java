package ua.com.alevel.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

@Repository
public interface StudentRepository extends BaseRepository<Student>{

    DataTableResponse<Student> findAllByCourseId(Long id, DataTableRequest dataTableRequest);

    DataTableResponse<Student> findAllByCourseType(CourseType type);

    Student findByEmail(String email);
    }
