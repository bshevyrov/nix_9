package ua.com.alevel.persistence.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.repository.BaseRepository;
import ua.com.alevel.util.DataTableUtil;

import java.util.List;
import java.util.Optional;

@Service
public class CrudRepositoryHelperImpl<E extends BaseEntity,
        R extends BaseRepository<E>>
        implements CrudRepositoryHelper<E, R> {

    @Override
    public void create(R repository, E entity) {
    repository.save(entity);
    }

    @Override
    public void update(R repository, E entity) {
        checkExist(repository, entity.getId());
    repository.save(entity);
    }

    @Override
    public void delete(R repository, Long id) {
    checkExist(repository,id);
    repository.delete(repository.getById(id));
    }

    @Override
    public Optional<E> findById(R repository, Long id) {
        return repository.findById(id);
    }

    @Override
    public DataTableResponse<E> findAll(R repository, DataTableRequest dataTableRequest) {
        PageRequest pageRequest = DataTableUtil.dataTableRequestToPageRequest(dataTableRequest);
        Page<E> page = repository.findAll(pageRequest);
        return DataTableUtil.responsePageToDTResponse(page,dataTableRequest);

    }

    @Override
    public List<E> findAll(R repository) {
        return repository.findAll();
    }

    private void checkExist(R repository, long id) {
        if(!repository.existsById(id)){
            throw  new RuntimeException("Entity Not Found");
        }
    }
}
