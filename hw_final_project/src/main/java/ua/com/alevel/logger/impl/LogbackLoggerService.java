package ua.com.alevel.logger.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import ua.com.alevel.logger.LoggerLevel;
import ua.com.alevel.logger.LoggerService;

@Component("loggerService")
public class LogbackLoggerService implements LoggerService {

    /*private static final Logger LOGGER_INFO = LoggerFactory.getLogger(LoggerLevel.INFO.getLevel());
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger(LoggerLevel.WARN.getLevel());
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(LoggerLevel.ERROR.getLevel());*/
//    private static Logger logger = LogManager.getLogger("guru.springframework.blog.log4jproperties");
    private static Logger LOGGER_INFO = LogManager.getLogger(LoggerLevel.WARN.getLevel());
    private static Logger LOGGER_WARN = LogManager.getLogger(LoggerLevel.WARN.getLevel());
    private static Logger LOGGER_ERROR = LogManager.getLogger(LoggerLevel.WARN.getLevel());

    @Override
    public void commit(LoggerLevel level, String message) {
        switch (level) {
            case INFO -> LOGGER_INFO.info(message);
            case WARN -> LOGGER_WARN.warn(message);
            case ERROR -> LOGGER_ERROR.error(message);
        }
    }
}