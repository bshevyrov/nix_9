package ua.com.alevel.veiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.CourseFacade;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseFacade courseFacade;

    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @GetMapping(path = {"/student/{id}"})
    public String getAllByStudentId(@PathVariable("id") Long id, Model model) {
//TODO validate
        model.addAttribute("courses", courseFacade.findAllByStudentId(id));
        model.addAttribute("studentId", id);
        return "/pages/course/course_all";
    }

    @GetMapping("/all")
    public String getAllCourses(Model model){
        model.addAttribute("courses",courseFacade.findAll());
        return "/pages/course/course_all";
    }
}