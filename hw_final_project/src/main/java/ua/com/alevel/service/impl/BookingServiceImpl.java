package ua.com.alevel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.BookingRepository;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.service.BookingService;
import ua.com.alevel.util.DataTableUtil;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CrudRepositoryHelper<Booking, BookingRepository> crudRepositoryHelper;

    public BookingServiceImpl(BookingRepository bookingRepository, CrudRepositoryHelper<Booking, BookingRepository> crudRepositoryHelper) {
        this.bookingRepository = bookingRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void create(Booking entity) {
        crudRepositoryHelper.create(bookingRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void update(Booking entity) {
        crudRepositoryHelper.update(bookingRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void delete(Long id) {
        crudRepositoryHelper.delete(bookingRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Booking> findById(Long id) {
        return crudRepositoryHelper.findById(bookingRepository, id);
    }

    @Override
    public List<Booking> findAll() {
        return crudRepositoryHelper.findAll(bookingRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public DataTableResponse<Booking> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(bookingRepository, request);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public DataTableResponse<Booking> findAllByUser(User user, DataTableRequest request) {
        PageRequest pageRequest = DataTableUtil.dataTableRequestToPageRequest(request);
        Page<Booking> page = bookingRepository.findAllByUserId(user.getId(), pageRequest);

        return DataTableUtil.responsePageToDTResponse(page, request);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAllByUser(User user) {
        return bookingRepository.findAllByUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAllByBookingStatus(BookingStatus status) {
        return bookingRepository.findAllByBookingStatus(status);
    }

    @Override
    public void removeCopy(User user) {
        List<Booking> list = bookingRepository.findAllByUser(user).stream()
                .filter(booking -> booking.getBookingStatus().name().equals("PENDING")).collect(Collectors.toList());
        for (Booking booking : list) {
            crudRepositoryHelper.delete(bookingRepository, booking.getId());
        }
    }

    @Override
    @Transactional
    public void deletePendingBooking() {
        //pending timeout
        int delayMinutes = 2;
        Timestamp timestamp = Timestamp.from(Instant.now());
        timestamp.setTime(timestamp.getTime()
                - TimeUnit.MINUTES.toMillis(delayMinutes));
        bookingRepository.deleteAllByBookingStatusAndTimestampGreaterThanEqual(BookingStatus.PENDING, timestamp);
    }
}
