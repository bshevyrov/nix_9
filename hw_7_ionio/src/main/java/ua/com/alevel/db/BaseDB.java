package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseDB<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(String id);

    E findById(String id);

    List<E> findAll();
}
