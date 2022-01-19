package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from Student s where s.id = :id")
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public boolean existById(long id) {
        Query query = entityManager.createQuery("select count(s.id) from Student s where s.id = :id")
                .setParameter("id", id);
        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public long count() {
        return (long) entityManager.createQuery("SELECT count(s) FROM Student s").getSingleResult();
    }

    @Override
    public DataTableResponse<Student> findAll(DataTableRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> from = criteriaQuery.from(Student.class);
        if (request.getOrder().equals("desc")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(from.get(request.getSort())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.asc(from.get(request.getSort())));
        }
        int page = (request.getCurrentPage() - 1) * request.getPageSize();
        int size = page + request.getPageSize();
        DataTableResponse<Student> response = new DataTableResponse<>();
        List<Student> list = entityManager.createQuery(criteriaQuery)
                .setFirstResult(page)
                .setMaxResults(size)
                .getResultList();
        response.seteList(list);
        return response;

    }

    @Override
    public DataTableResponse<Student> findAllByCourseId(Long id, DataTableRequest request) {
        String hql = "SELECT s FROM Student s  JOIN CourseStudent cs on s.id = cs.studentId  JOIN Course  c ON cs.courseId = c.id WHERE c.id=:ids ORDER BY s."+request.getSort()+" "+request.getOrder();
        DataTableResponse<Student> response = new DataTableResponse<>();
        Query query = entityManager.createQuery(hql);
        query.setParameter("ids",id);
        int page = (request.getCurrentPage() - 1) * request.getPageSize();
        int size = request.getPageSize();
        query.setFirstResult(page);
        query.setMaxResults(size);
        List list= query.getResultList();
        response.seteList(list);
        return response;
    }

    @Override
    public DataTableResponse<Student> findAllByCourseType(CourseType type) {
        return new DataTableResponse<Student>();

    }

    @Override
    public Student findByEmail(String email) {
        Query query= entityManager.createQuery("SELECT s FROM Student s WHERE s.email=:email");
   query.setParameter("email", email);
   List list = query.getResultList();
        System.out.println(list.size());
   return (Student) list.get(0);
    }


    @Override
    public long countFindAllByCourseId(Long id) {
        Set<Student> setStudents = entityManager.find(Course.class, id).getStudents();

        return setStudents.size();
    }
}
