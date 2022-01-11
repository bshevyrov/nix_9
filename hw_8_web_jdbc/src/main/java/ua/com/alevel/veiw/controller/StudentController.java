package ua.com.alevel.veiw.controller;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.PageDataRequest;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentFacade studentFacade;

    private final CourseFacade courseFacade;

    public StudentController(StudentFacade studentFacade, CourseFacade courseFacade) {
        this.studentFacade = studentFacade;
        this.courseFacade = courseFacade;
    }

    @GetMapping()
    public String mainPage() {
        return "redirect:/students/all";
    }


/*    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap modelMap){
        Map<String,String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)){
            parameterMap.forEach(modelMap::addAttribute);
        }
        return  new ModelAndView("redirect:/students", modelMap);
    }*/
    @GetMapping(path = {"/all"})
    public String getAllStudentSortedBy(@RequestParam(value = "field", required = false, defaultValue = "id") String field,
                                        @RequestParam(value = "sort", required = false, defaultValue = "ASC") String sort,
                                        @RequestParam(value = "page", required = false, defaultValue = "1") long page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") long size,
                                        Model model) {
        PageDataRequest request = new PageDataRequest();
        request.setOrder(field);
        request.setSort(sort);
        request.setPageSize(size);
        request.setCurrentPage(page);
        long totalPages = studentFacade.findAll().size();
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("totalPages", totalPages);

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, (int) totalPages + 1)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("pageDataResponse", studentFacade.findAll());
        return "/pages/student/student_all";
    }

    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        //модел  адд атрибьют, те модели что передаем на ХТМЛИНУ
        model.addAttribute("studentRequestDto", new StudentRequestDto());
        model.addAttribute("courses",courseFacade.findAll());
        return "pages/student/student_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute StudentRequestDto studentRequestDto, Model model) {
        //model.addAttribute(studentRequestDto);
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
        return "/pages/student/student_all";
    }
//    @GetMapping("/all")
//    public String studentsAllPage(Model model) {
//
//        return "redirect:/students/all?field=id&sort=ASC&from=1&to=10";

//    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentFacade.delete(id);
        return "redirect:/students";
    }

}
