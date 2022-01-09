package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.veiw.dto.request.RequestDto;
import ua.com.alevel.veiw.dto.response.ResponseDto;

import java.util.List;

public interface BaseFacade<REQ extends RequestDto, RES extends ResponseDto> {
    void create(REQ req);

    void update(REQ req, Long id);

    void delete(long id);

    RES findById(long id);

    List<RES> findAll();
}