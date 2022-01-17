package ua.com.alevel.facade;

import ua.com.alevel.view.request.RequestDto;
import ua.com.alevel.view.response.ResponseDto;

import java.util.List;

public interface BaseFacade <REQ extends RequestDto, RES extends ResponseDto>{

    void create(REQ req);
    void delete(long id);
    void update(REQ req);
    RES findById(long id);
    List<RES> findAll();

}