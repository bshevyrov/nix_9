package ua.com.alevel.veiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.veiw.dto.request.PageDataRequest;

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

    @GetMapping(path = {"/all"})
    public String getAllStudentSortedBy(@RequestParam(value = "field", required = false, defaultValue = "id") String field,
                                        @RequestParam(value = "sort", required = false, defaultValue = "ASC") String sort,
                                        @RequestParam(value = "from", required = false, defaultValue = "1") long from,
                                        @RequestParam(value = "to", required = false, defaultValue = "10") long to,
                                        Model model) {
        PageDataRequest request = new PageDataRequest();
        request.setOrder(field);
        request.setSort(sort);
        request.setPageSize((to - from) + 1);
        request.setCurrentPage(to / request.getPageSize());

        model.addAttribute("courses", courseFacade.findAllSortedByFieldOrderedBy(request).getItems());
        return "/pages/course/course_all";
    }
}