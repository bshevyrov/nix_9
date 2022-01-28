package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.repository.CinemaHallRepository;
import ua.com.alevel.service.CinemaHallService;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallRepository cinemaHallRepository;
    private final CrudRepositoryHelper<CinemaHall,CinemaHallRepository> crudRepositoryHelper;

    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository, CrudRepositoryHelper<CinemaHall, CinemaHallRepository> crudRepositoryHelper) {
        this.cinemaHallRepository = cinemaHallRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(CinemaHall entity) {
crudRepositoryHelper.create(cinemaHallRepository,entity);
    }

    @Override
    public void update(CinemaHall entity) {
        crudRepositoryHelper.update(cinemaHallRepository,entity);

    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(cinemaHallRepository,id);

    }

    @Override
    public Optional<CinemaHall> findById(Long id) {

        return crudRepositoryHelper.findById(cinemaHallRepository,id);

    }

    @Override
    public List<CinemaHall> findAll() {
        return crudRepositoryHelper.findAll(cinemaHallRepository);
    }

    @Override
    public DataTableResponse<CinemaHall> findAll(DataTableRequest request) {

        return null;
    }
}
