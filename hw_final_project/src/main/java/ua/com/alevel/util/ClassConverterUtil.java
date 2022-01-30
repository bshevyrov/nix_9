package ua.com.alevel.util;

import ua.com.alevel.persistence.entity.*;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.view.dto.request.*;
import ua.com.alevel.view.dto.response.*;

public final class ClassConverterUtil {

    private ClassConverterUtil() {
    }

    public static MovieResponseDto movieToMovieResponseDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
//        movieResponseDto.setCreateDate((Date) movie.getCreateDate());
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setImageUrl(movie.getImageUrl());
        movieResponseDto.setGenre(movie.getGenre());
        movieResponseDto.setDuration(movie.getDuration());
        movieResponseDto.setDirector(movie.getDirector());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setReleaseYear(movie.getReleaseYear());
        return movieResponseDto;
    }

    public static Movie movieRequestDtoToMovie(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
//        movie.setId(movieRequestDto.getId());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setImageUrl(movieRequestDto.getImageUrl());
        movie.setGenre(movieRequestDto.getGenre());
        movie.setDuration(movieRequestDto.getDuration());
        movie.setDirector(movieRequestDto.getDirector());
        movie.setTitle(movieRequestDto.getTitle());
        movie.setReleaseYear(movieRequestDto.getReleaseYear());
        return movie;
    }

    public static CinemaHallResponseDto cinemaHallToCinemaHallResponseDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCinemaHallType(cinemaHall.getCinemaHallType());
        cinemaHallResponseDto.setName(cinemaHall.getName());
        cinemaHallResponseDto.setTotalSeats(cinemaHall.getTotalSeats());
        return cinemaHallResponseDto;
    }

    public static ShowResponseDto showToShowResponseDto(Show show) {

        ShowResponseDto responseDto = new ShowResponseDto();
        responseDto.setId(show.getId());
        responseDto.setDate(show.getDate());
        responseDto.setCinemaHall(show.getCinemaHall());
        responseDto.setMovie(show.getMovie());
        responseDto.setEndTime(show.getEndTime());
        responseDto.setStartTime(show.getStartTime());
        return responseDto;

    }

    public static Show SRDtoToEntity(ShowRequestDto showRequestDto) {

        Show show = new Show();
//        show.setId(showRequestDto.getId());
        show.setCinemaHall(showRequestDto.getCinemaHall());
        show.setMovie(showRequestDto.getMovie());
        show.setDate(showRequestDto.getDate());
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        return show;
    }

    public static CinemaHallSeat cinemaHallSeatRequestDtoToCinemaHallSeat(CinemaHallSeatRequestDto cinemaHallSeatRequestDto) {

        CinemaHallSeat cinemaHallSeat = new CinemaHallSeat();
        cinemaHallSeat.setCinemaHall(cinemaHallSeat.getCinemaHall());
        cinemaHallSeat.setId(cinemaHallSeat.getId());
        cinemaHallSeat.setCinemaSeatType(cinemaHallSeat.getCinemaSeatType());
        cinemaHallSeat.setSeatNumber(cinemaHallSeat.getSeatNumber());

        return cinemaHallSeat;
    }

    public static CinemaHallSeat cinemaHallSeatResponseDtoToCinemaHallSeat(CinemaHallSeatResponseDto cinemaHallSeatRequestDto) {

        CinemaHallSeat cinemaHallSeat = new CinemaHallSeat();
        cinemaHallSeat.setId(cinemaHallSeatRequestDto.getId());
        cinemaHallSeat.setCinemaHall(cinemaHallSeatRequestDto.getCinemaHall());
        cinemaHallSeat.setId(cinemaHallSeatRequestDto.getId());
        cinemaHallSeat.setCinemaSeatType(cinemaHallSeatRequestDto.getCinemaSeatType());
        cinemaHallSeat.setSeatNumber(cinemaHallSeatRequestDto.getSeatNumber());

        return cinemaHallSeat;
    }

    public static CinemaHallSeatResponseDto cinemaHallSeatToCinemaHallSeatResponseDto(CinemaHallSeat cinemaHallSeat) {

        CinemaHallSeatResponseDto cinemaHallSeatResponseDto = new CinemaHallSeatResponseDto();
        cinemaHallSeatResponseDto.setCinemaHall(cinemaHallSeat.getCinemaHall());
        cinemaHallSeatResponseDto.setId(cinemaHallSeat.getId());
        cinemaHallSeatResponseDto.setCinemaSeatType(cinemaHallSeat.getCinemaSeatType());
        cinemaHallSeatResponseDto.setSeatNumber(cinemaHallSeat.getSeatNumber());

        return cinemaHallSeatResponseDto;
    }


    public static ShowSeat showSeatResponseDtoToShowSeat(ShowSeatResponseDto showSeatResponseDto) {

        ShowSeat showSeat = new ShowSeat();
        showSeat.setShow(showSeatResponseDto.getShow());
        showSeat.setShowSeatStatus(showSeatResponseDto.getShowSeatStatus());
        showSeat.setPrice(showSeatResponseDto.getPrice());
        showSeat.setId(showSeatResponseDto.getId());
        showSeat.setBooking(showSeatResponseDto.getBooking());
        showSeat.setCinemaHallSeat(showSeatResponseDto.getCinemaHallSeat());


        return showSeat;
    }

    public static ShowSeat showSeatRequestDtoToEntity(ShowSeatRequestDto showSeatRequestDto) {

        ShowSeat showSeat = new ShowSeat();
        showSeat.setShow(showSeatRequestDto.getShow());
        showSeat.setShowSeatStatus(showSeatRequestDto.getShowSeatStatus());
        showSeat.setPrice(showSeatRequestDto.getPrice());
//        showSeat.setId(showSeatRequestDto.getId());
        showSeat.setBooking(showSeatRequestDto.getBooking());
        showSeat.setCinemaHallSeat(showSeatRequestDto.getCinemaHallSeat());

        return showSeat;

    }

    public static ShowSeatResponseDto showSeatToShowSeatResponseDto(ShowSeat showSeat) {

        ShowSeatResponseDto showSeatResponseDto = new ShowSeatResponseDto();
        showSeatResponseDto.setShow(showSeat.getShow());
        showSeatResponseDto.setShowSeatStatus(showSeat.getShowSeatStatus());
        showSeatResponseDto.setPrice(showSeat.getPrice());
        showSeatResponseDto.setId(showSeat.getId());
        showSeatResponseDto.setBooking(showSeat.getBooking());
        showSeatResponseDto.setCinemaHallSeat(showSeat.getCinemaHallSeat());

        return showSeatResponseDto;
    }




    public static Show showResponseDtoToEntity(ShowResponseDto showResponseDto) {
        Show show = new Show();
        show.setId(showResponseDto.getId());
        show.setDate(showResponseDto.getDate());
        show.setCinemaHall(showResponseDto.getCinemaHall());
        show.setMovie(showResponseDto.getMovie());
        show.setEndTime(showResponseDto.getEndTime());
        show.setStartTime(showResponseDto.getStartTime());
        return show;

    }

    public static Booking bookingRequestDtoToEntity(BookingRequestDto bookingRequestDto) {
        Booking booking = new Booking();

        booking.setBookingStatus(bookingRequestDto.getBookingStatus());
        booking.setUser(bookingRequestDto.getUser());
        booking.setShow(bookingRequestDto.getShow());
//        booking.setId(bookingRequestDto.getId());
        //TODO проверить тайм стамп именно когда оплатил
        booking.setTimestamp(bookingRequestDto.getTimestamp());
        booking.setNumberOfSeats(bookingRequestDto.getNumberOfSeats());

        return booking;
    }

    public static Booking bookingResponseDtoToEntity(BookingResponseDto bookingResponseDto) {
        Booking booking = new Booking();

        booking.setBookingStatus(bookingResponseDto.getBookingStatus());
//        booking.setUser(bookingResponseDto.getUser());
        booking.setId(bookingResponseDto.getId());
        booking.setTimestamp(bookingResponseDto.getTimestamp());
        booking.setNumberOfSeats(bookingResponseDto.getNumberOfSeats());
        return booking;
    }

    public static BookingResponseDto bookingToResponseDto(Booking booking) {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setShow(booking.getShow());
        bookingResponseDto.setBookingStatus(booking.getBookingStatus());
        bookingResponseDto.setUser(booking.getUser());
        bookingResponseDto.setId(booking.getId());
        bookingResponseDto.setTimestamp(booking.getTimestamp());
        bookingResponseDto.setNumberOfSeats(booking.getNumberOfSeats());
        return bookingResponseDto;
    }


    public static User userResponseDtoToEntity(UserResponseDto userResponseDto) {
        User user = new User();
         user.setId(userResponseDto.getId());
        user.setEmail(userResponseDto.getEmail());
        user.setFirstName(userResponseDto.getFirstName());
        user.setLastName(userResponseDto.getLastName());
        user.setPhone(userResponseDto.getPhone());
        user.setPassword(userResponseDto.getPassword());
        user.setRoleType(userResponseDto.getRoleType());
        user.setEnabled(userResponseDto.getEnabled());
        return user;

    }

    public static UserResponseDto userToUserResponseDto(User user) {

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setRoleType(user.getRoleType());
        userResponseDto.setEnabled(user.getEnabled());
        return userResponseDto;
    }

    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {
        User user = new User();
       user.setEmail(userRequestDto.getEmail());
//       user.setId(userRequestDto.getId());
       user.setFirstName(userRequestDto.getFirstName());
       user.setLastName(userRequestDto.getLastName());
       user.setPhone(userRequestDto.getPhone());
       user.setPassword(userRequestDto.getPassword());
       user.setRoleType(userRequestDto.getRoleType());
       user.setEnabled(userRequestDto.getEnabled());
        return user;
    }
}

