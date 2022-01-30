package ua.com.alevel.service;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;

import java.util.List;
import java.util.Optional;

public interface ShowService extends BaseCrudService<Show> {
    Optional<Show> findByMovieId(long id);

        List<Show> findAllByMovieId(Long id);

    DataTableResponse<Show> findAllByMovieId(long id, DataTableRequest request);



}
