package ua.com.alevel.view.controller.client;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.AuthValidatorFacade;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.type.RoleType;
import ua.com.alevel.util.SecurityUtil;
import ua.com.alevel.view.controller.AbstractController;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.UserResponseDto;

@Controller
@RequestMapping("/clients")
public class ClientsUserDetailsController extends AbstractController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthValidatorFacade authValidatorFacade;
    private final UserFacade userFacade;


    public ClientsUserDetailsController(BCryptPasswordEncoder bCryptPasswordEncoder, AuthValidatorFacade authValidatorFacade, UserFacade userFacade) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authValidatorFacade = authValidatorFacade;
        this.userFacade = userFacade;

    }

    @GetMapping("/user/detail")
    public String detail(Model model) {
        UserResponseDto responseDto = userFacade.findByEmail(
                SecurityUtil.getUsername());
        model.addAttribute("user", responseDto);
        return "/pages/clients/user/user_detail";
    }

    @GetMapping("/user/update")
    public String updatePost(Model model) {
        UserResponseDto userResponseDto = userFacade.findByEmail(SecurityUtil.getUsername());
        UserRequestDto newUserRequestDto = new UserRequestDto();
        newUserRequestDto.setFirstName(userResponseDto.getFirstName());
        newUserRequestDto.setLastName(userResponseDto.getLastName());
        newUserRequestDto.setPhone(userResponseDto.getPhone());
                        model.addAttribute("newUserRequestDto", userResponseDto);
        return "/pages/clients/user/user_update";
    }

    @PostMapping("/user/update")
    public String update(@ModelAttribute("newUserRequestDto") UserRequestDto newUserRequestDto,
                         Model model) {
        UserResponseDto responseDto = userFacade.findByEmail(
                SecurityUtil.getUsername());

        newUserRequestDto.setEmail(responseDto.getEmail());
        newUserRequestDto.setId(responseDto.getId());
        newUserRequestDto.setPassword(responseDto.getPassword());
        newUserRequestDto.setRoleType(RoleType.ROLE_USER);
        newUserRequestDto.setEnabled(Boolean.TRUE);

        model.addAttribute("user", userFacade.findByEmail(SecurityUtil.getUsername()));
        return "/pages/clients/user/user_detail";
    }


    @GetMapping("/user/update/password")
    public String update(Model model) {
        model.addAttribute("newUserRequestDto", new UserRequestDto());
        return "/pages/clients/user/user_update_password";
    }

    @PostMapping("/user/update/password")
    public String update(@ModelAttribute("newUserRequestDto") UserRequestDto newUserRequestDto,
                         BindingResult bindingResult,
                         Model model) {
        UserResponseDto userResponseDto = userFacade.findByEmail(
                SecurityUtil.getUsername());
        showMessage(model, false);
        if (!bCryptPasswordEncoder.matches(newUserRequestDto.getOldPassword(),userResponseDto.getPassword()) ){
            bindingResult.reject(
                    "passwordCurrent", "Old password different from Current Password");
            return "/pages/clients/user/user_update_password";
        }
        newUserRequestDto.setEmail("Uniq email");
        authValidatorFacade.validate(newUserRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/pages/clients/user/user_update_password";
        }


        userFacade.updatePass(userResponseDto.getId(),bCryptPasswordEncoder
                .encode(newUserRequestDto.getPassword()));
                    return "redirect:/clients/user/detail";
    }
}
