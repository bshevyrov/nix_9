package ua.com.alevel.persistance.dao;

import ua.com.alevel.persistance.entity.BaseEntity;

public interface BaseDao <E extends BaseEntity>{

    void create(E e);

    void update(E e);

    void delete(Long id);

    E findById(Long id);

//    DataTableResponse<E> findAll(DataTableRequest request);

}
