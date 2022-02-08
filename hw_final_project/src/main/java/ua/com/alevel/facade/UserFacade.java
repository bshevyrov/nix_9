package ua.com.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.PageDataResponse;
import ua.com.alevel.view.dto.response.UserResponseDto;

public interface UserFacade extends BaseFacade<UserRequestDto, UserResponseDto> {

    UserResponseDto findByEmail(String email);

    void updatePass(long id, String encode);

    void ban(long id);

    void unban(long id);

    PageDataResponse<UserResponseDto> findAllUser(WebRequest request);

}
