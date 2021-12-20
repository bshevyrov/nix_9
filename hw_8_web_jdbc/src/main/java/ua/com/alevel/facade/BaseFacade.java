package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.view.dto.RequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ResponseDto;

public interface BaseFacade<REQ extends RequestDto, RES extends ResponseDto> {

    void create(REQ req);

    void update(REQ req, Long id);

    void delete(Long id);

    RES findById(Long id);

//    PageDataResponse<RES> findAll();

    PageDataResponse<RES> findAll(WebRequest webRequest);

}
