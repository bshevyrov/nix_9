package ua.com.alevel.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;
import java.util.Locale;

public final class ShowSeatUtil {

    private ShowSeatUtil() {
    }

    public static String[] createSeatMap(int totalSeat, List<CinemaHallSeatResponseDto> cinemaHallSeatList) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        int row = totalSeat / seatsInRow;
        String[] seatMap = new String[]{};
        int index = 0;
        for (int i = 0; i < row; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < seatsInRow; j++) {
                if (StringUtils.equals(cinemaHallSeatList.get(index).getCinemaSeatType().name(), "FIRST_CLASS")) {
                    stringBuilder.append("f");
                }
                if (StringUtils.equals(cinemaHallSeatList.get(index).getCinemaSeatType().name(), "ECONOMY_CLASS")) {
                    stringBuilder.append("e");
                }
                index++;
            }
            seatMap = ArrayUtils.add(seatMap, stringBuilder.toString());
        }
        return seatMap;
    }

    public static String[] createSoldSeats(List<ShowSeatResponseDto> showSeats) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        String[] soldSeats = new String[]{};
        for (ShowSeatResponseDto showSeat : showSeats) {
            StringBuilder stringBuilder = new StringBuilder();
            //Can add another ShowSeatStatus
            if (StringUtils.equals(showSeat.getShowSeatStatus().name().toUpperCase(Locale.ROOT), "UNAVAILABLE")) {
                int seatNum = showSeat.getCinemaHallSeat().getSeatNumber();
                int seatRow;
                if (seatNum <= seatsInRow) {
                    seatRow = 1;
                } else {
                    seatRow = ((seatNum / seatsInRow) + 1);
                }
                int seatNumber = seatNum - (seatsInRow * (seatRow - 1));
                stringBuilder.append(seatRow).append("_").append(seatNumber);
                soldSeats = ArrayUtils.add(soldSeats, stringBuilder.toString());
            }
        }
        return soldSeats;

    }
}
