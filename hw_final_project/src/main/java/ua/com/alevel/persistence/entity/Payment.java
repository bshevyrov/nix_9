package ua.com.alevel.persistence.entity;

import ua.com.alevel.persistence.type.PaymentMethodType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity{

    @Column(name = "amount")
    private double amount;

    @Column(name = "time_stamp",columnDefinition = "TIMESTAMP")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timeStamp;

//    private String remoteTransactionId;
//    private PaymentMethodType paymentMethodType;
//
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
       private Booking booking;

    public Payment() {
        super();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
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
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Objects.equals(timeStamp, payment.timeStamp) && Objects.equals(booking, payment.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, timeStamp, booking);
    }
}
