package ua.com.alevel.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import java.util.List;

@Repository
public interface StudentRepository extends BaseRepository<Student>{

    Page<Student> findAllByCourseId(Long id, Pageable pageable);

//    DataTableResponse<Student> findAllByCourseType(CourseType type);

    Student findByEmail(String email);

//    long countFindAllByCourseId(Long id);

    }
