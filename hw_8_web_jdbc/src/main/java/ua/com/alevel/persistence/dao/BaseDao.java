package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.Student;

import java.util.List;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(long id);

    boolean existById(long id);

    E findById(long id);

    DataTableResponse<E> findAll(DataTableRequest request);

    long count();

    DataTableResponse<E> findAllSortedByFieldOrderedBy(DataTableRequest request);

}
