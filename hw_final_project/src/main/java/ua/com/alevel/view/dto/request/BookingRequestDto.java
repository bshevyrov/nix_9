package ua.com.alevel.view.dto.request;

import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import java.sql.Timestamp;

public class BookingRequestDto extends RequestDto{

    private BookingStatus bookingStatus;

    private Timestamp timestamp;

    private int numberOfSeats;

    private Show show;

    private User user;

    private int totalPrice;



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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
