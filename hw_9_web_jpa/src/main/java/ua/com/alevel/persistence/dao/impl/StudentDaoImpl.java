package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.dao.StudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Student;
import ua.com.alevel.persistence.type.CourseType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public void create(Student student) {
        entityManager.persist(student);
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
return new Student();
    }

    @Override
    public long count() {
return 0;
    }

    @Override
    public DataTableResponse<Student> findAll(DataTableRequest request)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> from = criteriaQuery.from(Student.class);
        if (request.getOrder().toLowerCase(Locale.ROOT).equals("desc")) {
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
return new DataTableResponse<Student>();
    }

    @Override
    public DataTableResponse<Student> findAllByCourseType(CourseType type) {
        return new  DataTableResponse<Student>();

    }

    @Override
    public Student findByEmail(String email) {
        return new Student();
    }




    @Override
    public long countFindAllByCourseId(Long id) {
return 0L;
    }}
