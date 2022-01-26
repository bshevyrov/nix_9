package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.ShowSeatStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "show_seats")
public class ShowSeat extends BaseEntity {

    @Column(name = "show_seat_status")
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

    @Column(name = "price")
    private double price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_seat_id", referencedColumnName = "id")
    private CinemaSeat cinemaSeat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", referencedColumnName = "id")
    private Show show;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    public ShowSeat() {
        super();
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CinemaSeat getCinemaSeat() {
        return cinemaSeat;
    }

    public void setCinemaSeat(CinemaSeat cinemaSeat) {
        this.cinemaSeat = cinemaSeat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowSeat showSeat = (ShowSeat) o;
        return Double.compare(showSeat.price, price) == 0 && showSeatStatus == showSeat.showSeatStatus && Objects.equals(cinemaSeat, showSeat.cinemaSeat) && Objects.equals(show, showSeat.show) && Objects.equals(booking, showSeat.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showSeatStatus, price, cinemaSeat, show, booking);
    }
}