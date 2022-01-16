package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.veiw.dto.request.PageDataRequest;
import ua.com.alevel.veiw.dto.request.RequestDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;
import ua.com.alevel.veiw.dto.response.ResponseDto;

import java.util.List;

public interface BaseFacade<REQ extends RequestDto, RES extends ResponseDto> {
    void create(REQ req);

    void update(REQ req);

    void delete(long id);

    RES findById(long id);

    List<RES> findAll();

    PageDataResponse<RES> findAll(WebRequest request);


}
