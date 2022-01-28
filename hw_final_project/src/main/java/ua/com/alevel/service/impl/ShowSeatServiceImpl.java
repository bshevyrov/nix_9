package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.ShowSeat;
import ua.com.alevel.persistence.repository.ShowSeatRepository;
import ua.com.alevel.service.ShowSeatService;

import java.util.List;
import java.util.Optional;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    private final ShowSeatRepository showSeatRepository;
    private final CrudRepositoryHelper<ShowSeat,ShowSeatRepository> crudRepositoryHelper;

    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository, CrudRepositoryHelper<ShowSeat, ShowSeatRepository> crudRepositoryHelper) {
        this.showSeatRepository = showSeatRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }


    @Override
    public void create(ShowSeat entity) {
crudRepositoryHelper.create(showSeatRepository,entity);
    }

    @Override
    public void update(ShowSeat entity) {
        crudRepositoryHelper.update(showSeatRepository,entity);

    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(showSeatRepository,id);

    }

    @Override
    public Optional<ShowSeat> findById(Long id) {
        return crudRepositoryHelper.findById(showSeatRepository,id);
            }

    @Override
    public List<ShowSeat> findAll() {
        return crudRepositoryHelper.findAll(showSeatRepository);

    }

    @Override
    public DataTableResponse<ShowSeat> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(showSeatRepository,request);

    }

    @Override
    public List<ShowSeat> findAllByShowId(long id) {
        return showSeatRepository.findAllByShowId(id);
    }
}
