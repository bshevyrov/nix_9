package ua.com.alevel.persistance.entity;

import ua.com.alevel.persistance.type.PaymentMethodType;

import java.time.LocalDateTime;
import java.util.Objects;

public class Payment extends BaseEntity{

    private double amount;
    private LocalDateTime timeStamp;
    private String remoteTransactionId;
    private PaymentMethodType paymentMethodType;
    private long bookingId;

    public Payment() {
        super();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getRemoteTransactionId() {
        return remoteTransactionId;
    }

    public void setRemoteTransactionId(String remoteTransactionId) {
        this.remoteTransactionId = remoteTransactionId;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
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
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && bookingId == payment.bookingId && Objects.equals(timeStamp, payment.timeStamp) && Objects.equals(remoteTransactionId, payment.remoteTransactionId) && paymentMethodType == payment.paymentMethodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, timeStamp, remoteTransactionId, paymentMethodType, bookingId);
    }
}
