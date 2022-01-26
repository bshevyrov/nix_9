package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.repository.ShowRepository;
import ua.com.alevel.service.ShowService;

import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public void create(Show entity) {

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
    public DataTableResponse<Show> findAll(DataTableRequest request) {
        return null;
    }
}
