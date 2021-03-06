package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.CinemaHallSeat;
import ua.com.alevel.persistence.repository.CinemaHallSeatRepository;
import ua.com.alevel.service.CinemaHallSeatService;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaHallSeatServiceImpl implements CinemaHallSeatService {

    private final CinemaHallSeatRepository cinemaHallSeatRepository;
    private final CrudRepositoryHelper<CinemaHallSeat, CinemaHallSeatRepository> crudRepositoryHelper;

    public CinemaHallSeatServiceImpl(CinemaHallSeatRepository cinemaHallSeatRepository
            , CrudRepositoryHelper<CinemaHallSeat, CinemaHallSeatRepository> crudRepositoryHelper) {
        this.cinemaHallSeatRepository = cinemaHallSeatRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void create(CinemaHallSeat entity) {
        crudRepositoryHelper.create(cinemaHallSeatRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(CinemaHallSeat entity) {
        crudRepositoryHelper.update(cinemaHallSeatRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void delete(Long id) {
        crudRepositoryHelper.delete(cinemaHallSeatRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CinemaHallSeat> findById(Long id) {
        return crudRepositoryHelper.findById(cinemaHallSeatRepository, id);

    }

    @Override
    public List<CinemaHallSeat> findAll() {
        return crudRepositoryHelper.findAll(cinemaHallSeatRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<CinemaHallSeat> findAll(DataTableRequest request) {
        return
                crudRepositoryHelper.findAll(cinemaHallSeatRepository, request);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CinemaHallSeat> findAllByCinemaHallId(long id) {
        return cinemaHallSeatRepository.findAllByCinemaHallId(id);
    }
}
