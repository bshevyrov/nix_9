package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.BookingFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.BookingService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebRequestUtil;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.BookingResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Service
public class BookingFacadeImpl implements BookingFacade {

    private final BookingService bookingService;

    public BookingFacadeImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void create(BookingRequestDto bookingRequestDto) {
        bookingService.create(ClassConverterUtil.bookingRequestDtoToEntity(bookingRequestDto));
    }

    @Override
    public void update(BookingRequestDto bookingRequestDto) {
        bookingService.update(ClassConverterUtil.bookingRequestDtoToEntity(bookingRequestDto));

    }

    @Override
    public void delete(long id) {
        bookingService.delete(id);

    }

    @Override
    public BookingResponseDto findById(long id) {
        return ClassConverterUtil.bookingToResponseDto(bookingService.findById(id).get());
    }

    @Override
    public List<BookingResponseDto> findAll() {
        return bookingService.findAll().stream()
                .map(ClassConverterUtil::bookingToResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public PageDataResponse<BookingResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebRequestUtil.generatePageAndSizeData(request);
        SortData sortData = WebRequestUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Booking> all = bookingService.findAll(dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);

    }

    private PageDataResponse<BookingResponseDto> getPageDataResponseFromDataTable(PageAndSizeData pageAndSizeData, SortData sortData, DataTableResponse<Booking> all) {
        List<BookingResponseDto> list = all.getItems()
                .stream()
                .map(ClassConverterUtil::bookingToResponseDto)
                .collect(Collectors.toList());
        PageDataResponse<BookingResponseDto> pageDataResponse = FacadeUtil.getPageDataResponseFromDTResp(list, pageAndSizeData, sortData);
        pageDataResponse.setItemsSize(all.getItemsSize());
        pageDataResponse.initPaginationState(pageDataResponse.getCurrentPage());
        return pageDataResponse;
    }


    @Override
    public BookingResponseDto findByUser(User user) {
        return ClassConverterUtil.bookingToResponseDto(bookingService.findByUser(user));
    }
//
//    @Override
//    public List<BookingResponseDto> findAllByUser(User user) {
//        return bookingService.findAllByUser(user).stream()
//                .map(ClassConverterUtil::bookingToResponseDto)
//        .collect(Collectors.toList());
//    }
}
