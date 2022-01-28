package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
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
    private final CrudRepositoryHelper<CinemaHallSeat,CinemaHallSeatRepository> crudRepositoryHelper;

    public CinemaHallSeatServiceImpl(CinemaHallSeatRepository cinemaHallSeatRepository
            , CrudRepositoryHelper<CinemaHallSeat, CinemaHallSeatRepository> crudRepositoryHelper) {
        this.cinemaHallSeatRepository = cinemaHallSeatRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(CinemaHallSeat entity) {

    }

    @Override
    public void update(CinemaHallSeat entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<CinemaHallSeat> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CinemaHallSeat> findAll() {
        return null;
    }

    @Override
    public DataTableResponse<CinemaHallSeat> findAll(DataTableRequest request) {
        return null;
    }

    @Override
    public List<CinemaHallSeat> findAllByCinemaHallId(long id) {
        return cinemaHallSeatRepository.findAllByCinemaHallId(id) ;
    }
}
