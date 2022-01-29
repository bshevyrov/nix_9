package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.Booking;
import ua.com.alevel.persistence.entity.CinemaHallSeat;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.type.ShowSeatStatus;

public class ShowSeatResponseDto extends ResponseDto {

    private ShowSeatStatus showSeatStatus;

    private double price;

    private CinemaHallSeat cinemaHallSeat;

    private Show show;

    private Booking booking;

//    public ShowSeat() {
//        super();
//    }

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

    public CinemaHallSeat getCinemaHallSeat() {
        return cinemaHallSeat;
    }

    public void setCinemaHallSeat(CinemaHallSeat cinemaHallSeat) {
        this.cinemaHallSeat = cinemaHallSeat;
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


}
