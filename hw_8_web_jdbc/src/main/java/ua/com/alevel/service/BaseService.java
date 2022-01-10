package ua.com.alevel.service;

import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;

public interface BaseService <E extends BaseEntity>{

    void create(E e);

    void update(E e);

    void delete(long id);

    E findById(long id);

    DataTableResponse<E> findAll(DataTableRequest request);

    DataTableResponse<E> findAllSortedByFieldOrderedBy(DataTableRequest request);
}
