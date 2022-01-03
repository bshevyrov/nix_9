package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(long id);

    boolean existById(long id);

    E findById(long id);

    DataTableResponse findAll(DataTableRequest request);

    long count();

}
