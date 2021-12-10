package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.HallDao;
import ua.com.alevel.entity.Hall;

import java.util.List;

@Service
public class HallDaoImpl implements HallDao {

    @Override
    public void create(Hall hall) {

    }

    @Override
    public void update(Hall hall) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existById(Long id) {
        return false;
    }

    @Override
    public Hall findById(Long id) {
        return null;
    }

    @Override
    public List<Hall> findAll() {
        return null;
    }
}
