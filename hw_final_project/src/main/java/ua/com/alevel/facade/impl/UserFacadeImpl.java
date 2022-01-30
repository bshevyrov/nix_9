package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.ShowSeat;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.BookingService;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.ShowResponseDto;
import ua.com.alevel.view.dto.response.UserResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
 private final BookingService bookingService;

    public UserFacadeImpl(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }

    @Override
    public UserResponseDto findByEmail(String email) {

        return ClassConverterUtil.userToUserResponseDto(userService.findByEmail(email));
    }

    @Override
    public void addBooking(long userid, long bookingId) {
     User user  =userService.findById(userid).get();
        Booking booking = bookingService.findById(bookingId).get();
        user.addBooking(booking);
        userService.update(user);
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
        userService.create(ClassConverterUtil.userRequestDtoToUser(userRequestDto));

    }

    @Override
    public void update(UserRequestDto userRequestDto) {
        userService.update(ClassConverterUtil.userRequestDtoToUser(userRequestDto));

    }

    @Override
    public void delete(long id) {
        userService.delete(id);

    }

    @Override
    public UserResponseDto findById(long id) {
        return     ClassConverterUtil.userToUserResponseDto(userService.findById(id).get());

    }

    @Override
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream()
                .map(ClassConverterUtil::userToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<UserResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
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
