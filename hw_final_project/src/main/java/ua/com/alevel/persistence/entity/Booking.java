package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.type.BookingStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private Timestamp timestamp;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "total_price")
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Booking() {
        super();
    }

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
        Booking booking = (Booking) o;
        return numberOfSeats == booking.numberOfSeats && Double.compare(booking.totalPrice, totalPrice) == 0 && bookingStatus == booking.bookingStatus && Objects.equals(show, booking.show) && Objects.equals(user, booking.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingStatus, numberOfSeats, totalPrice, show, user);
    }
}
