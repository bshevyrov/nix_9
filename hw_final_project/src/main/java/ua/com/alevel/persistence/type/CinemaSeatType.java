package ua.com.alevel.persistence.type;

public enum CinemaSeatType {
    ECONOMY_CLASS(50), FIRST_CLASS(100);

    private int price;

    CinemaSeatType(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
