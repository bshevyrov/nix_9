package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebUtil;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserResponseDto findByEmail(String email) {
        return ClassConverterUtil.userToUserResponseDto(userService.findByEmail(email));
    }

    @Override
    public void updatePass(long id, String encode) {
        userService.updatePassword(id, encode);
    }

    @Override
    public void ban(long id) {
        userService.ban(id);

    }

    @Override
    public void unban(long id) {
        userService.unban(id);

    }

    @Override
    public PageDataResponse<UserResponseDto> findAllUser(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<User> all = userService.findAllUser(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }


    @Override
    public void create(UserRequestDto userRequestDto) {
        userService
                .create(ClassConverterUtil
                        .userRequestDtoToUser(userRequestDto));

    }

    @Override
    public void update(UserRequestDto userRequestDto) {
        userService
                .update(ClassConverterUtil
                        .userRequestDtoToUser(userRequestDto));
    }

    @Override
    public void delete(long id) {
        userService.delete(id);
    }

    @Override
    public UserResponseDto findById(long id) {
        return ClassConverterUtil.userToUserResponseDto(userService.findById(id).get());
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream()
                .map(ClassConverterUtil::userToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<UserResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<User> all = userService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);
    }

    private PageDataResponse<UserResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<User> all) {
        List<UserResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::userToUserResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<UserResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }

}
