package ua.com.alevel.persistance.entity;

import ua.com.alevel.persistance.type.BookingStatus;

import java.time.LocalDateTime;
import java.util.Objects;


public class Booking extends BaseEntity {

    private BookingStatus bookingStatus;
    private LocalDateTime timestamp;
    private int numberOfSeats;
    private long showId;
    private long userId;

    public Booking() {
        super();
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return numberOfSeats == booking.numberOfSeats && showId == booking.showId && userId == booking.userId && bookingStatus == booking.bookingStatus && Objects.equals(timestamp, booking.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookingStatus, timestamp, numberOfSeats, showId, userId);
    }
}
