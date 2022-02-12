package ua.com.alevel.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.annotations.InjectLog;
import ua.com.alevel.logger.LoggerLevel;
import ua.com.alevel.logger.LoggerService;
import ua.com.alevel.service.BookingService;


@Service
public class BookingStatusCronJon {

    private final BookingService bookingService;


    public BookingStatusCronJon(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @InjectLog
    private LoggerService loggerService;

    @Scheduled(fixedRate = 1000 * 60)
    public void deletePendingBooking() {
        loggerService.commit(LoggerLevel.WARN, "Clear pending booking");
        bookingService.deletePendingBooking();
    }
}
