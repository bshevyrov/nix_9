package ua.com.alevel.veiw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.PageDataRequest;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @GetMapping()
    public String mainPage() {
        return "redirect:/students/all";
    }



    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        //модел  адд атрибьют, те модели что передаем на ХТМЛИНУ
        model.addAttribute("student", new StudentRequestDto());
        return "pages/student/student_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute("student") StudentRequestDto studentRequestDto) {
        studentFacade.create(studentRequestDto);
        return "redirect:/students";
    }

    @GetMapping(path = {"/course/{id}"})
    public String getAllByStudentId(@PathVariable("id") Long id, Model model) {
//TODO validate
        model.addAttribute("students", studentFacade.findAllByCourseId(id));
        model.addAttribute("courseId", id);
        return "/pages/student/student_all";

    }

    @GetMapping(path = {"/course"})
    public String getAllByStudentId(@RequestParam("type") String type, Model model) {
//TODO validate
        model.addAttribute("students", studentFacade.findAllByCourseType(CourseType.valueOf(type)));
//        model.addAttribute("courseId", id);
        return "/pages/student/student_all";
    }

//    @GetMapping("/all")
//    public String studentsAllPage(Model model) {
//
//        return "redirect:/students/all?field=id&sort=ASC&from=1&to=10";
//    }

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

        model.addAttribute("students", studentFacade.findAllSortedByFieldOrderedBy(request).getItems());
        return "/pages/student/student_all";
    }

}
