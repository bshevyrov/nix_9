package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity> {

    void create(E e);

    void update(E e);

    void delete(String id);

    E findById(String id);

    String findIdByName(String name);

    List<E> findAll();
}
