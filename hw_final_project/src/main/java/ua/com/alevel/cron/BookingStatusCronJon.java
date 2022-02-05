package ua.com.alevel.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.service.BookingService;


@Service
public class BookingStatusCronJon {

    private final BookingService bookingService;

    public BookingStatusCronJon(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @Scheduled(fixedRate = 1000 * 60)
    public void deletePendingBooking() {
//log TODO
        bookingService.deletePendingBooking();
    }
}
