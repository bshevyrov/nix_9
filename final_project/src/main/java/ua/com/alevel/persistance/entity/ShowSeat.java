package ua.com.alevel.persistance.entity;

import ua.com.alevel.persistance.type.ShowSeatStatus;

import java.util.Objects;

public class ShowSeat extends BaseEntity{

    private ShowSeatStatus showSeatStatus;
    private double price;
    private long cinemaSeatId;
    private long showId;
    private long bookingId;

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

    public long getCinemaSeatId() {
        return cinemaSeatId;
    }

    public void setCinemaSeatId(long cinemaSeatId) {
        this.cinemaSeatId = cinemaSeatId;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowSeat showSeat = (ShowSeat) o;
        return Double.compare(showSeat.price, price) == 0 && cinemaSeatId == showSeat.cinemaSeatId && showId == showSeat.showId && bookingId == showSeat.bookingId && showSeatStatus == showSeat.showSeatStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), showSeatStatus, price, cinemaSeatId, showId, bookingId);
    }
}
