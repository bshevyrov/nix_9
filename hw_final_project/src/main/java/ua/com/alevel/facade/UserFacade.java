package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.UserResponseDto;

public interface UserFacade extends BaseFacade<UserRequestDto, UserResponseDto> {
    UserResponseDto findByEmail(String email);

/*
    void addBooking(long userid, long bookingId);
*/
}
