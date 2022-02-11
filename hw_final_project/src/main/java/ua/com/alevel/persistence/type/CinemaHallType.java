package ua.com.alevel.persistence.type;

public enum CinemaHallType {

    TWO_D("https://cdn4.iconfinder.com/data/icons/cinema-ticket-app/24/2D-512.png"),
    THREE_D("https://icon-library.com/images/icon-3d/icon-3d-11.jpg"),
    IMAX("https://pic.onlinewebfonts.com/svg/img_119078.png");

    private final String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    CinemaHallType(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
