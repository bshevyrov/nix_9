package ua.com.alevel.sevice.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.HallDao;
import ua.com.alevel.dao.MovieDao;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.sevice.HallService;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private final HallDao hallDao;
    private final MovieDao movieDao;

    public HallServiceImpl(HallDao hallDao, MovieDao movieDao) {
        this.hallDao = hallDao;
        this.movieDao = movieDao;
    }

    @Override
    public void create(Hall hall) {
        hallDao.create(hall);
    }

    @Override
    public void update(Hall hall) {
        hallDao.update(hall);
    }

    @Override
    public void delete(long id) {
        if (hallDao.existById(id)) {
            hallDao.delete(id);
            movieDao.deleteAllByHallId(id);
        }
    }

    @Override
    public Hall findById(long id) {
        //TODO придуматьь что выдавать если нет
        //hallDao.existById(id);
        return hallDao.findById(id);
    }

    @Override
    public List<Hall> findAll() {
        return hallDao.findAll();
    }
}
