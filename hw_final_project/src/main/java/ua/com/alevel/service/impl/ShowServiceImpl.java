package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.repository.ShowRepository;
import ua.com.alevel.service.BaseCrudService;
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
    public void create(Show entity) {
    crudRepositoryHelper.create(showRepository,entity);
    }

    @Override
    public void update(Show entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Show> findById(Long id) {
        return showRepository.findByMovieId(id);
    }

    @Override
    public List<Show> findAll() {
        return null;
    }

    @Override
    public DataTableResponse<Show> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(showRepository, request);
    }
}
