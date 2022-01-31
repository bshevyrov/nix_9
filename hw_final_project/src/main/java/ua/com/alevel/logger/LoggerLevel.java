package ua.com.alevel.logger;

public enum LoggerLevel {

    INFO("info"),
    WARN("warn"),
    ERROR("error");

    private final String level;

    LoggerLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
