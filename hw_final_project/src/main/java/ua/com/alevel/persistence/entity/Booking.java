package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.entity.user.ClientUser;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientUser client;

    public Booking() {
        super();
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

    public ClientUser getClient() {
        return client;
    }

    public void setClient(ClientUser client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return numberOfSeats == booking.numberOfSeats && bookingStatus == booking.bookingStatus && Objects.equals(timestamp, booking.timestamp) && Objects.equals(show, booking.show) && Objects.equals(client, booking.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingStatus, timestamp, numberOfSeats, show, client);
    }
}
