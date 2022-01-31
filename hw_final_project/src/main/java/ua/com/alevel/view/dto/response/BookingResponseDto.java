package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import java.sql.Timestamp;
import java.util.Objects;

public class BookingResponseDto extends ResponseDto {

    private BookingStatus bookingStatus;

    private Timestamp timestamp;

    private int numberOfSeats;

    private Show show;

    private User user;

    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingResponseDto that = (BookingResponseDto) o;
        return numberOfSeats == that.numberOfSeats && Double.compare(that.totalPrice, totalPrice) == 0 && bookingStatus == that.bookingStatus && Objects.equals(timestamp, that.timestamp) && Objects.equals(show, that.show) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingStatus, timestamp, numberOfSeats, show, user, totalPrice);
    }
}
