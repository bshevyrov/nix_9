package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.repository.BookingRepository;
import ua.com.alevel.service.BookingService;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CrudRepositoryHelper<Booking, BookingRepository> crudRepositoryHelper;

    public BookingServiceImpl(BookingRepository bookingRepository, CrudRepositoryHelper<Booking, BookingRepository> crudRepositoryHelper) {
        this.bookingRepository = bookingRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    public void create(Booking entity) {
        crudRepositoryHelper.create(bookingRepository, entity);
    }

    @Override
    public void update(Booking entity) {
        crudRepositoryHelper.update(bookingRepository, entity);
    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(bookingRepository, id);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return crudRepositoryHelper.findById(bookingRepository, id);
    }

    @Override
    public List<Booking> findAll() {
        return crudRepositoryHelper.findAll(bookingRepository);
    }

    @Override
    public DataTableResponse<Booking> findAll(DataTableRequest request) {
        return crudRepositoryHelper.findAll(bookingRepository, request);
    }
}
