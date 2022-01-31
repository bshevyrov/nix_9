package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.repository.ShowRepository;
import ua.com.alevel.service.ShowService;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final CrudRepositoryHelper<Show, ShowRepository> crudRepositoryHelper;

    public ShowServiceImpl(ShowRepository showRepository, CrudRepositoryHelper<Show, ShowRepository> crudRepositoryHelper) {
        this.showRepository = showRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)

    public void create(Show entity) {
        if (entity.getId() != 0) {
            crudRepositoryHelper.update(showRepository, entity);
        }
        crudRepositoryHelper.create(showRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)

    public void update(Show entity) {
        crudRepositoryHelper.update(showRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)

    public void delete(Long id) {
        crudRepositoryHelper.delete(showRepository, id);
    }

    @Override
    @Transactional(readOnly = true)

    public Optional<Show> findById(Long id) {
        return crudRepositoryHelper.findById(showRepository, id);
    }


    @Override
    public List<Show> findAll() {
        return crudRepositoryHelper.findAll(showRepository);
    }

    @Override
    @Transactional(readOnly = true)

    public DataTableResponse<Show> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(showRepository, request);
    }

    @Override
    @Transactional(readOnly = true)

    public Optional<Show> findByMovieId(long id) {
        return showRepository.findByMovieId(id);
    }

    @Override
    @Transactional(readOnly = true)

    public List<Show> findAllByMovieId(Long id) {
        return showRepository.findAllByMovieId(id);
    }

    @Override
    @Transactional(readOnly = true)

    public DataTableResponse<Show> findAllByMovieId(long id, DataTableRequest request) {
        return null;
    }
}
