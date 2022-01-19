package ua.com.alevel.persistence.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.dao.CourseStudentDao;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.entity.CourseStudent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class CourseStudentDaoImpl implements CourseStudentDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void create(CourseStudent courseStudent) {
        entityManager.persist(courseStudent);
    }

    @Override
    public void update(CourseStudent courseStudent) {
        entityManager.merge(courseStudent);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from CourseStudent s where s.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public boolean existById(long id) {
        Query query = entityManager.createQuery("select count(s.id) from CourseStudent s where s.id = :id")
                .setParameter("id", id);
        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public CourseStudent findById(long id) {
        return entityManager.find(CourseStudent.class, id);

    }

    @Override
    public DataTableResponse<CourseStudent> findAll(DataTableRequest request) {
        return null;
    }

    @Override
    public long count() {
        return 1;
    }

    @Override
    public void deleteByStudentId(long id) {

        entityManager.createQuery("DELETE FROM CourseStudent WHERE studentId=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
