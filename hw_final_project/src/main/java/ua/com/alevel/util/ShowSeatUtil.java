package ua.com.alevel.util;

import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.view.dto.response.CinemaHallSeatResponseDto;
import ua.com.alevel.view.dto.response.ShowSeatResponseDto;

import java.util.List;
import java.util.Locale;

public final class ShowSeatUtil {

    private ShowSeatUtil() {
    }

    public static String createSeatMap(int totalSeat, List<CinemaHallSeatResponseDto> cinemaHallSeatList) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        int row = totalSeat / seatsInRow;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("map: [");


        int index = 0;
        for (int i = 0; i < row; i++) {
            stringBuilder.append("'");
            for (int j = 0; j < seatsInRow; j++) {
                if(StringUtils.equals(cinemaHallSeatList.get(index).getCinemaSeatType().name(),"FIRST_CLASS")){
                    stringBuilder.append("f");
                }
                if(StringUtils.equals(cinemaHallSeatList.get(index).getCinemaSeatType().name(),"ECONOMY_CLASS")) {
                    stringBuilder.append("e");
                }
                index++;
            }
            stringBuilder.append("',");
        }
        stringBuilder.append("],");
        //map: [
        //                'ff_ffe',
        //                'ff_ffe',
        //                'ee_eee',
        //                'ee_eee',
        //                'ee___e',
        //                'ee_eee',
        //                'ee_eee',
        //                'ee_eee',
        //                'eeeeef',
        //            ],
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String createSoldSeats(List<ShowSeatResponseDto> showSeats) {
        //Hard code  5 seat in row
        int seatsInRow = 5;
        StringBuilder unavailable = new StringBuilder();
        for (ShowSeatResponseDto showSeat : showSeats) {


            if (StringUtils.equals(showSeat.getShowSeatStatus().name().toUpperCase(Locale.ROOT), "UNAVAILABLE")) {
                int seatNum = showSeat.getCinemaHallSeat().getSeatNumber();
                int seatRow = 0;
                if (seatNum <= seatsInRow) {
                    seatRow = seatNum;
                } else {
                    seatRow = ((seatNum / seatsInRow));
                }
                int seatNumber = seatNum - (seatRow * seatsInRow);
                unavailable.append(seatRow).append("_").append(seatNumber).append(",");
            }


//            sc.get(['1_2', '4_1', '7_1', '7_2'])
        }
        return StringUtils.substring(unavailable.toString(), 0, unavailable.length() - 1);
    }
/*    map: [
            'ff_ffe',
            'ff_ffe',
            'ee_eee',
            'ee_eee',
            'ee___e',
            'ee_eee',
            'ee_eee',
            'ee_eee',
            'eeeeee',
            ],*/
}
