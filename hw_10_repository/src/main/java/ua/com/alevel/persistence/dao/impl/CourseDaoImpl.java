package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.dao.CourseDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from Course s where s.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        studentValidation(id);
    }

    @Override
    public boolean existById(long id) {
        Query query = entityManager.createQuery("select count(s.id) from Course s where s.id = :id")
                .setParameter("id", id);
        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public DataTableResponse<Course> findAll(DataTableRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> from = criteriaQuery.from(Course.class);
        if (request.getOrder().equals("desc")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(from.get(request.getSort())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.asc(from.get(request.getSort())));
        }
        int page = (request.getCurrentPage() - 1) * request.getPageSize();
        int size = page + request.getPageSize();
        DataTableResponse<Course> response = new DataTableResponse<>();
        List<Course> list = entityManager.createQuery(criteriaQuery)
                .setFirstResult(page)
                .setMaxResults(size)
                .getResultList();
        response.seteList(list);
        return response;
    }

    @Override
    public long count() {
        return (long) entityManager.createQuery("SELECT count(s) FROM Course s").getSingleResult();
    }

    @Override
    public DataTableResponse<Course> findAllByStudentId(Long id) {
        Set<Course> courses = entityManager.find(Student.class, id).getCourses();
        List<Course> list = new ArrayList<>(courses);
        DataTableResponse<Course> response = new DataTableResponse<>();
        response.seteList(list);
        return response;
    }

    public void studentValidation(long courseId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> from = criteriaQuery.from(Student.class);

        List<Student> list = entityManager.createQuery(criteriaQuery)
                .getResultList();
        for (Student student : list) {
            if (student.getCourses().size() == 0) {
                entityManager.createQuery("delete from Student s where s.id = :id")
                        .setParameter("id", student.getId())
                        .executeUpdate();
            }

        }


    }
}

