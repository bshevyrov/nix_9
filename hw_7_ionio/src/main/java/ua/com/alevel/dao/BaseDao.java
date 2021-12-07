package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(String id);

    boolean isExistById(String id);

    String findIdByName(String name);

    E findById(String id);

    List<E> findAll();
}
