package ua.com.alevel.cron;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.annotations.InjectLog;
import ua.com.alevel.logger.LoggerLevel;
import ua.com.alevel.logger.LoggerService;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.service.ShowService;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ShowCronJob {

    private final ShowService showService;

    @InjectLog
    LoggerService loggerService;


    public ShowCronJob(ShowService showService) {
        this.showService = showService;
    }

    @Scheduled(fixedRate = 1000 * 60 * 15)
    public void deleteCurrentShows() {
        List<Show> all = showService.findAll();
        LocalTime time = LocalTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        for (Show show : all) {
            if (DateUtils.isSameDay(show.getDate(), Date.from(Instant.now()))) {

                if (time.compareTo(show.getStartTime()) > 0) {
                    showService.delete(show.getId());
                    loggerService.commit(LoggerLevel.WARN, "Cron delete " +
                            "id: " + show.getId() + " " +
                            " start time: " + show.getStartTime() + " " +
                            " movie name: " + show.getMovie().getTitle());
                }
            }
        }
    }
}
