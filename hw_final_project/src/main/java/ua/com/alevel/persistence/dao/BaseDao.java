package ua.com.alevel.persistence.dao;

import ua.com.alevel.persistence.entity.BaseEntity;

public interface BaseDao <E extends BaseEntity>{

    void create(E e);

    void update(E e);

    void delete(Long id);

    E findById(Long id);

//    DataTableResponse<E> findAll(DataTableRequest request);

}
