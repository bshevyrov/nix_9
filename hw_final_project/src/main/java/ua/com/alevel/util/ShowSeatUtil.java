package ua.com.alevel.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class ShowSeatUtil {

    private ShowSeatUtil() {
    }

    public static String[] createSeatMap(int totalSeat, List<CinemaHallSeatResponseDto> cinemaHallSeatList) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        int row = totalSeat / seatsInRow;
        String[] setss = new String[]{};
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
            setss = ArrayUtils.add(setss,stringBuilder.toString());
        }
        System.out.println(  Arrays.toString(setss));

        return setss;
    }

    public static String[] createSoldSeats(List<ShowSeatResponseDto> showSeats) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        String[] setss = new String[]{};

        for (ShowSeatResponseDto showSeat : showSeats) {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.equals(showSeat.getShowSeatStatus().name().toUpperCase(Locale.ROOT), "UNAVAILABLE")) {
                int seatNum = showSeat.getCinemaHallSeat().getSeatNumber();
                int seatRow = 0;
                if (seatNum <= seatsInRow) {
                    seatRow = seatNum;
                } else {
                    seatRow = ((seatNum / seatsInRow)+1);
                }
                int seatNumber = seatNum- ( seatsInRow*(seatRow-1));
                stringBuilder.append(seatRow).append("_").append(seatNumber);
                setss = ArrayUtils.add(setss, stringBuilder.toString());
            }


//            sc.get(['1_2', '4_1', '7_1', '7_2'])
        }
        System.out.println(  Arrays.toString(setss));
//        return setss;

    return new String[]{"1_1"};

}}
