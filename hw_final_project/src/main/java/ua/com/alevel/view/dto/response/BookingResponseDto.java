package ua.com.alevel.view.dto.response;

import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.persistence.entity.user.ClientUser;
import ua.com.alevel.persistence.type.BookingStatus;
import ua.com.alevel.view.dto.request.RequestDto;

import java.sql.Timestamp;

public class BookingResponseDto extends ResponseDto {

    private BookingStatus bookingStatus;

    private Timestamp timestamp;

    private int numberOfSeats;

    private Show show;

    private ClientUser client;


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



}
