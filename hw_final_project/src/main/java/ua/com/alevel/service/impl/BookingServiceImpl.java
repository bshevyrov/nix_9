package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.crud.CrudRepositoryHelper;
import ua.com.alevel.persistence.datatable.DataTableRequest;
import ua.com.alevel.persistence.datatable.DataTableResponse;
import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.user.User;
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
    @Transactional(isolation = Isolation.READ_COMMITTED)
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

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public Booking findByUser(User user) {

       Booking booking= bookingRepository.findByUser(user);


return booking;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAllByUser(User user) {
        return bookingRepository.findAllByUser(user);
    }
}
