package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.BookingFacade;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.service.BookingService;
import ua.com.alevel.util.ClassConverterUtil;
import ua.com.alevel.util.FacadeUtil;
import ua.com.alevel.util.WebUtil;
import ua.com.alevel.view.dto.request.BookingRequestDto;
import ua.com.alevel.view.dto.request.PageAndSizeData;
import ua.com.alevel.view.dto.request.SortData;
import ua.com.alevel.view.dto.response.BookingResponseDto;
import ua.com.alevel.view.dto.response.PageDataResponse;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
        Booking booking = bookingService.findById(id).get();
        return ClassConverterUtil.bookingToResponseDto(booking);
    }

    @Override
    public List<BookingResponseDto> findAll() {
        return bookingService.findAll().stream()
                .map(ClassConverterUtil::bookingToResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public PageDataResponse<BookingResponseDto> findAll(WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
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
    public BookingResponseDto save(BookingRequestDto requestDto) {
        return ClassConverterUtil.bookingToResponseDto(
                bookingService.save(
                        ClassConverterUtil.
                                bookingRequestDtoToEntity(requestDto)));
    }

    @Override
    public List<BookingResponseDto> findAllByUser(User user) {
        return bookingService.findAllByUser(user).stream()
                .map(ClassConverterUtil::bookingToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PageDataResponse<BookingResponseDto> findAllByUser(User user, WebRequest request) {
        PageAndSizeData pageAndSizeData = WebUtil.generatePageAndSizeData(request);
        SortData sortData = WebUtil.generateSortData(request);
        DataTableRequest dataTableRequest = FacadeUtil.getDTReqFromPageAndSortData(pageAndSizeData, sortData);
        DataTableResponse<Booking> all = bookingService.findAllByUser(user, dataTableRequest);
        return getPageDataResponseFromDataTable(pageAndSizeData, sortData, all);

    }

    @Override
    public List<Booking> findAllByBookingStatus(BookingStatus status) {
        return bookingService.findAllByBookingStatus(status);
    }

    @Override
    public void buy(long id) {
        Booking booking = bookingService.findById(id).get();
        booking.setBookingStatus(BookingStatus.SUCCESS);
        booking.setTimestamp(Timestamp.from(Instant.now()));
        bookingService.update(booking);
    }

    @Override
    public void removeCopy(User user) {
        bookingService.removeCopy(user);
    }
}
