package ua.com.alevel.sevice;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(long id);

    E findById(long id);

    List<E> findAll();
}
