package ua.com.alevel.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.annotations.InjectLog;
import ua.com.alevel.logger.LoggerLevel;
import ua.com.alevel.logger.LoggerService;
import ua.com.alevel.service.BookingService;


@Service
public class BookingStatusCronJon {

    private final BookingService bookingService;
//    private static final Logger logger = LoggerFactory.getLogger(BookingStatusCronJon.class);

    public BookingStatusCronJon(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @InjectLog
    private LoggerService loggerService;

    @Scheduled(fixedRate = 1000 * 60)
    public void deletePendingBooking() {
loggerService.commit(LoggerLevel.INFO, "Clear pending booking11");
loggerService.commit(LoggerLevel.WARN, "Clear pending booking22");
loggerService.commit(LoggerLevel.ERROR, "Clear pending booking33");
//        logger.debug("Clear pending booking2");
//        logger.warn("Clear pending booking3");
//        logger.error("Clear pending bookingerr");
//        logger.info("Clear pending bookinginf");
    bookingService.deletePendingBooking();
    }
}
