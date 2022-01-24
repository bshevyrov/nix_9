package ua.com.alevel.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<Course> {
//
//    @Query(value = "SELECT c FROM Course c  JOIN CourseStudent cs on c.id = cs.courseId  JOIN Student  s ON cs.studentId = s.id WHERE s.id=:id")
//    Page<Course> findAllByStudentId(@Param("id") Long id, Pageable pageable);
//
    List<Course> findAllByStudentsId (long id);

}
