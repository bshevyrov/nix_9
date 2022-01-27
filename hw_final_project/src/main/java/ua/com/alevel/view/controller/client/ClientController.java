package ua.com.alevel.view.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.view.controller.AbstractController;

@Controller
@RequestMapping("/client")
public class ClientController extends AbstractController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
//        String user = SecurityUtil.getUsername();
//        DoctorUser doctorUserData = doctorUserFacade.findByEmail(user);
//        Doctor doctor = doctorUserData.getDoctor();
//        model.addAttribute("movies",doctor);
        return "pages/client/dashboard";
    }
}
